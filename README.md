# Proyecto CRUD - Spring y React con Docker Compose

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) implementada con **Spring Boot** en el backend y **React** en el frontend, gestionada y orquestada utilizando **Docker Compose**. El sistema permite la administración de una lista de clientes, donde se pueden realizar operaciones sobre los registros.

## Descripción del Proyecto

La aplicación permite gestionar información de clientes con los siguientes datos:
- Nombre
- Apellido
- Correo electrónico
- Género
- Dirección IP
- País

Este proyecto consta de dos partes principales:
- **Backend**: API REST creada con **Spring Boot** y **JPA/Hibernate** para gestionar la base de datos MySQL.
- **Frontend**: Interfaz de usuario construida con **React** que consume la API REST y permite al usuario interactuar con los datos.

La base de datos MySQL se ejecuta dentro de un contenedor Docker, facilitando el despliegue en entornos locales o en servidores.

## Tecnologías y Dependencias Utilizadas 🛠️

### Backend (Spring Boot)
- **Spring Boot** 3.3.2
- **Spring Data JPA**: Para interactuar con la base de datos.
- **MySQL Connector**: Conexión a MySQL desde Spring Boot.
- **Spring Web**: Para crear servicios RESTful.
- **Spring Validation**: Para validar datos de entrada.
- **Spring HATEOAS**: Para soporte de hipermedios.
- **Lombok**: Para reducir código repetitivo con anotaciones.
- **JUnit & Mockito**: Para pruebas unitarias.

### Frontend (React)
- **React** 18.3.1: Biblioteca para construir interfaces de usuario interactivas.
- **React Router**: Para manejar las rutas de la aplicación.
- **Axios**: Para hacer peticiones HTTP al backend.
- **Redux**: Para manejar el estado global de la aplicación.
- **Material UI**: Para construir una interfaz de usuario moderna y accesible.
- **Bootstrap**: Para un diseño responsivo y rápido.
- **SweetAlert2**: Para mostrar alertas y notificaciones en la interfaz.

### Contenedores y Orquestación
- **Docker**: Para contenerizar la aplicación.
- **Docker Compose**: Para orquestar el despliegue de múltiples contenedores (Frontend, Backend, Base de Datos).

## Despliegue con Docker Compose 🔧

### Requisitos 📋
- **Docker**: Necesitas tener **Docker** y **Docker Compose** instalados en tu máquina. Puedes seguir la [guía de instalación de Docker](https://docs.docker.com/get-docker/) y la [guía de instalación de Docker Compose](https://docs.docker.com/compose/install/).

### Pasos para Ejecutar la Aplicación

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <directorio_del_repositorio>
2. Configura el archivo docker-compose.yml: Asegúrate de que el archivo docker-compose.yml esté configurado correctamente con los puertos y credenciales necesarias.
3. Construye e inicia los contenedores con Docker Compose:
  bash
   docker-compose up --build

4. Esto levantará los siguientes contenedores:

- Frontend: React, accesible en http://localhost:4173.
- Backend: Spring Boot, accesible en http://localhost:8080.
- Base de Datos: MySQL, accesible en localhost:3309 (puedes usar herramientas como MySQL Workbench para acceder).
Accede a la aplicación:

4. Abre tu navegador y visita http://localhost:4173 para acceder a la interfaz de usuario.
Desde allí podrás gestionar los registros de clientes.

## Puertos Expuestos
- Frontend (React): http://localhost:4173
- Backend (Spring Boot): http://localhost:8080
- Base de Datos (MySQL): localhost:3309 (accesible mediante MySQL Workbench u otra herramienta similar).

## Consideraciones
Si alguno de los puertos ya está en uso en tu máquina, puedes modificar el archivo docker-compose.yml para cambiar los puertos expuestos.
Si es la primera vez que ejecutas los contenedores, asegúrate de que Docker tiene acceso adecuado a tu red local y los puertos que usas no están siendo bloqueados por un firewall.

## Datos de Referencia del Desarrollador
Nombre: Agustín Gómez
mail: agustingomez220598@gmail.com
LinkedIn: [LinkedIn de Agustín](https://www.linkedin.com/in/agustin-gomez-develop/)
GitHub: [GitHub de Agustín](https://github.com/Agustingomez98)




