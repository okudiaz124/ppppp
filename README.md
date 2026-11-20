# MediSupply · Backend

**API REST de solicitudes de suministros médicos** desarrollada con Java y Spring Boot. El código está organizado por capas y bounded contexts, con reglas de negocio sencillas, persistencia en MySQL y manejo de errores en dos idiomas.

> **Empieza aquí:** [GUÍA COMPLETA PARA COPIAR LOS ARCHIVOS, EN ORDEN Y CON COMMITS](./GUIA_DE_COPIADO.md). Cada nombre de archivo en la guía es un enlace directo al código de GitHub, listo para copiar y pegar en IntelliJ.

## Tecnologías

| Herramienta | Uso |
|---|---|
| Java 25 | Lenguaje |
| Spring Boot 4.0.x | Backend |
| Spring Web MVC | API REST |
| Spring Data JPA | Acceso a datos |
| MySQL | Base de datos `medi_supply` |
| Lombok | Reducción de código repetitivo |
| SpringDoc OpenAPI | Documentación de la API |
| Maven | Dependencias y ejecución |

## Organización de archivos

```text
src/main/java/com/medisupply/platform/u202419311/
├── MediSupplyApplication.java
├── procurement/
│   ├── domain/
│   │   ├── model/
│   │   │   ├── aggregates/
│   │   │   │   ├── SupplyRequest.java
│   │   │   │   └── SupplyRequestStatus.java
│   │   │   └── valueobjects/
│   │   │       ├── RequestCode.java
│   │   │       ├── FacilityId.java
│   │   │       ├── FulfillmentPeriod.java
│   │   │       └── SupplyBatch.java
│   │   └── repositories/
│   │       └── SupplyRequestRepository.java
│   ├── application/internal/commandservices/
│   │   ├── CreateSupplyRequestCommand.java
│   │   └── CreateSupplyRequestHandler.java
│   ├── infrastructure/persistence/jpa/
│   │   ├── entities/SupplyRequestEntity.java
│   │   ├── repositories/SupplyRequestJpaRepository.java
│   │   └── adapters/SupplyRequestRepositoryAdapter.java
│   └── interfaces/rest/
│       ├── SupplyRequestsController.java
│       ├── resources/
│       │   ├── CreateSupplyRequestResource.java
│       │   └── SupplyRequestResource.java
│       └── transform/SupplyRequestAssembler.java
└── shared/
    ├── domain/
    │   ├── DomainValidationException.java
    │   ├── BusinessConflictException.java
    │   └── Result.java
    └── interfaces/rest/
        ├── GlobalExceptionHandler.java
        └── resources/ApiError.java

src/main/resources/
├── application.properties
├── messages.properties
└── messages_es.properties
```

## Ruta rápida

| Orden | Lo que se desarrolla | Enlace |
|---|---|---|
| 01–02 | Configuración, Java 25 y clase principal | [Ver guía](./GUIA_DE_COPIADO.md#paso-01-configurar-maven-ya-realizado) |
| 03 | Objetos de valor y validaciones | [Ver archivos](./GUIA_DE_COPIADO.md#paso-03-value-objects-y-validaciones) |
| 04–05 | Agregado y contrato de repositorio | [Ver archivos](./GUIA_DE_COPIADO.md#paso-04-agregado-y-estado-de-la-solicitud) |
| 06 | Persistencia con JPA y MySQL | [Ver archivos](./GUIA_DE_COPIADO.md#paso-06-persistencia-con-jpa) |
| 07 | Comando y caso de uso | [Ver archivos](./GUIA_DE_COPIADO.md#paso-07-comando-y-caso-de-uso) |
| 08–09 | Recursos HTTP y endpoint POST | [Ver archivos](./GUIA_DE_COPIADO.md#paso-08-recursos-y-transformador-http) |
| 10 | Mensajes en inglés y español | [Ver archivos](./GUIA_DE_COPIADO.md#paso-10-errores-y-mensajes-en-dos-idiomas) |
| 11 | Compilar y probar | [Ver instrucciones](./GUIA_DE_COPIADO.md#paso-11-verificar-el-funcionamiento) |

## Endpoint del examen

`POST /api/v1/supply-requests`

```json
{
  "requestCode": "SUP-001",
  "facilityId": "550e8400-e29b-41d4-a716-446655440000",
  "fulfillmentPeriodStartDate": "2026-11-21",
  "fulfillmentPeriodEndDate": "2026-11-25",
  "supplyBatchQuantity": 10,
  "supplyBatchUnit": "BOX",
  "urgencyLevel": 3,
  "status": "PENDING",
  "requestNotes": "Materiales para emergencias"
}
```

| Código HTTP | Resultado |
|---|---|
| `201 Created` | Solicitud registrada |
| `400 Bad Request` | Datos inválidos |
| `409 Conflict` | Código de solicitud duplicado |
| `500 Internal Server Error` | Error inesperado |

Para mensajes en español, incluir `Accept-Language: es-PE`.

## Preparación y ejecución

1. Usar JDK 25 e importar las dependencias del `pom.xml` con Maven.
2. Iniciar MySQL y preparar el esquema `medi_supply`. La configuración está en [`application.properties`](./src/main/resources/application.properties).
3. Ejecutar `./mvnw clean compile` y `./mvnw spring-boot:run` **si tienes Maven Wrapper**; también puedes usar `mvn` si lo tienes instalado.
4. Acceder a Swagger UI mediante `http://localhost:8080/swagger-ui/index.html` y probar el endpoint.

## Trabajo en el repositorio de evaluación

El repositorio **`ppppp` es una referencia de desarrollo**. El proyecto de evaluación es [`okudiaz124/pc20729u202419311`](https://github.com/okudiaz124/pc20729u202419311).

- Conserva el `pom.xml` del repositorio de evaluación con su `artifactId` propio: `pc20729u202419311`.
- Copia los archivos Java respetando los paquetes y los comentarios existentes.
- Registra commits separados por los cambios que realmente vas implementando.
- **No copies las carpetas `.git` ni `target`**.
- [Guía de configuración de Git, autenticación y commits](./GUIA_DE_COPIADO.md#cómo-copiar-un-archivo-en-intellij).

## Estado

Código de referencia subido a GitHub. **No se ha confirmado su compilación ni el funcionamiento con una instancia real de MySQL.** Antes de entregar, completar la revisión contra todas las páginas del examen y ejecutar las pruebas correspondientes.
