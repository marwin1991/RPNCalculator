FROM maven:3.6.1-jdk-11-slim as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn clean install

# Step : Package image
FROM openjdk:11-slim
COPY --from=target /build/target/RPNCalculator.jar /app/RPNCalculator.jar
CMD exec java $JAVA_OPTS -jar /app/RPNCalculator.jar 2 3 +