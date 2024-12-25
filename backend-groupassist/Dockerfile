FROM eclipse-temurin:17.0.13_11-jdk

EXPOSE 8080

WORKDIR /root

# Copiar el archivo pom.xml y otros archivos necesarios para la construcción
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Descargar dependencias sin ejecutar pruebas
RUN ./mvnw dependency:go-offline

# Copiar el código fuente de la aplicación
COPY ./src /root/src

# Ejecutar el comando de construcción
RUN ./mvnw clean install -DskipTests

# Copiar el script wait-for-it.sh al contenedor
COPY ./wait-for-it.sh /root/wait-for-it.sh

# Hacer ejecutable el script wait-for-it.sh
RUN chmod +x /root/wait-for-it.sh

# Comando para ejecutar la aplicación
ENTRYPOINT ["/root/wait-for-it.sh", "database:3306", "--", "java", "-jar", "/root/target/customerapp-0.0.1-SNAPSHOT.jar"]
