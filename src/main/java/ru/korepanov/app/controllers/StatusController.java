package ru.korepanov.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StatusController {

    private final String message = """
            host: %s
            version: %s
            """;

    @Value("${app.version}")
    private String version;

    @GetMapping("/status")
    public String status(HttpServletRequest request) {
        return String.format(message, request.getLocalAddr(), version);
    }
}
