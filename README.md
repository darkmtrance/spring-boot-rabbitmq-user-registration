Introducción

Este repositorio proporciona una guía paso a paso para instalar y configurar RabbitMQ utilizando Docker. RabbitMQ es un broker de mensajería que permite la comunicación entre aplicaciones mediante el intercambio de mensajes. Usar Docker simplifica el proceso de instalación y gestión, ideal para entornos de desarrollo y pruebas.
Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente en tu máquina:

- Docker: Puedes descargarlo desde [Docker's website](https://www.docker.com/get-started/).
- Docker Compose (opcional): Utilizado para gestionar aplicaciones multi-contenedor.

Instalación

## Paso 1: Ejecutar un Contenedor de RabbitMQ
Inicia un contenedor de RabbitMQ utilizando el siguiente comando:
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0.2-management-alpine
```
Donde:

-d: Ejecuta el contenedor en modo desprendido.

--name: Asigna un nombre al contenedor.

-p: Mapea los puertos del contenedor a tu máquina local:
    5672: Para el servidor RabbitMQ.
    15672: Para la interfaz de gestión.

## Paso 2: Acceder a la Consola de Gestión de RabbitMQ
Abre un navegador web y navega a http://localhost:15672/. Inicia sesión con las credenciales predeterminadas:
```bash
Usuario: guest
Contraseña: guest
```

## Paso 3: Configuración Adicional (Opcional)
Si deseas utilizar un archivo de configuración personalizado, puedes montarlo al iniciar RabbitMQ. Por ejemplo:
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -v /path/to/your/rabbitmq.conf:/etc/rabbitmq/rabbitmq.conf rabbitmq:4.0.2-management-alpine
```

## Paso 4: Persistencia de Datos
Para asegurarte de que los datos persistan incluso si el contenedor se reinicia, puedes montar un volumen:
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -v /path/to/data:/var/lib/rabbitmq rabbitmq:4.0.2-management-alpine
```