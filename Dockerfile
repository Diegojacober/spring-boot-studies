FROM gradle:jdk21-alpine as BUILD
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN gradle clean build || return 0 
COPY . .
RUN gradle clean build


FROM openjdk:21-slim
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME/build/libs/*jar ./app.jar

EXPOSE 8080

CMD ["java","-jar", "app.jar"]
