FROM openjdk:17-jdk
LABEL authors="mohamedogleh"
WORKDIR app
COPY target/courses-0.0.1.jar app/course.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app/course.jar"]
