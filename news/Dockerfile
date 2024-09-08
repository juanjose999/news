# Etapa 1: Construcción
FROM maven:3.8.6-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el directorio src para aprovechar el caché de Docker
COPY pom.xml .
COPY src ./src

# Construye la aplicación (sin ejecutar los tests para mayor rapidez)
RUN mvn clean install -DskipTests

# Etapa 2: Ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado en la fase de construcción al contenedor
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
