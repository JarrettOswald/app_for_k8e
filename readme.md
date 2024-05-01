## Простой сервис для k8e и настройки ci/cd.

kubectl create deployment app-deployment --image=your_repo/my-spring-boot-image:latest --port=8080

## [Jenkinsfile](Jenkinsfile)

* **Checkout**: Выполняет проверку кода из системы контроля версий.
* **mvn clean package**: Выполняет сборку проекта Maven с очисткой и упаковкой.
* **Build Docker Image**: Строит Docker-образ с помощью команды docker build.
* **Docker Push**: Выполняет вход в Docker Hub с использованием учетных данных из Jenkins Credentials и загружает
  Docker-образ в репозиторий Docker Hub.

## Application

* [localhost:8080/status](src%2Fmain%2Fjava%2Fru%2Fkorepanov%2Fapp%2Fcontrollers%2FStatusController.java)