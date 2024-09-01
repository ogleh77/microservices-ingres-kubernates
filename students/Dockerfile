FROM openjdk:17-jdk
LABEL authors="mohamedogleh"
WORKDIR app
COPY target/students-0.0.1.jar app/student.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","app/student.jar"]

