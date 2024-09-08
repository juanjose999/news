# Utiliza una imagen base con OpenJDK 17 y Maven para construir la aplicación
FROM maven:3.8.4-openjdk-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de tu proyecto al directorio de trabajo
COPY . .

# Construye la aplicación utilizando Maven (sin ejecutar los tests para mayor rapidez)
RUN mvn clean install -DskipTests

# Utiliza una imagen más ligera de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo para la ejecución
WORKDIR /app

# Copia el archivo JAR generado en la fase de construcción al contenedor
COPY --from=build /app/target/service-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080, que es el puerto por defecto de Spring Boot
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
