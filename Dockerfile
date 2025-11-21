# Dockerfile para Backend Spring Boot
FROM gradle:8.5-jdk21 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración de Gradle
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Copiar código fuente
COPY src ./src

# Construir la aplicación
RUN gradle clean build -x test --no-daemon

# Imagen final
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el JAR construido
COPY --from=build /app/build/libs/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Variables de entorno para la base de datos
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/reservasapps?createDatabaseIfNotExist=true
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=rootpassword
ENV SERVER_PORT=8080

# Ejecutar la aplicación con perfil docker
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]

