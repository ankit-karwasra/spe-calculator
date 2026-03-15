FROM eclipse-temurin:8-jdk

COPY target/scientific-calculator-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-cp","app.jar","com.calc.ScientificCalculator"]