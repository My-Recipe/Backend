FROM openjdk:17
ARG JAR_FILE=./build/libs/myRecipe_backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} myRecipe_backend.jar
ENTRYPOINT ["java","-jar","/myRecipe_backend.jar", "--spring.profiles.active=prod"]