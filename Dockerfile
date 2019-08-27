FROM openjdk:11
COPY target/RPNCalculator.jar /usr/home/
WORKDIR /usr/home/
CMD ["java","-jar","RPNCalculator.jar"]