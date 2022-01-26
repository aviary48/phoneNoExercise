FROM adoptopenjdk/openjdk14:ubi
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build/libs/*.jar app.jar
COPY sample.db sample.db
EXPOSE 2224
CMD ["java","-jar","app.jar"]
