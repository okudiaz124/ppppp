# Guía de copiado manual — MediSupply

Esta guía contiene el **orden exacto para trasladar los archivos del repositorio de práctica `ppppp` al proyecto `pc20729u202419311` en IntelliJ IDEA**. Los enlaces abren el código listo para copiar. Los cambios y commits en el repositorio de evaluación los realizas tú.

> **Importante:** no clones `ppppp` dentro del proyecto de evaluación, no reemplaces su carpeta `.git` ni copies el historial de commits del repositorio de práctica. Conserva el historial real que ya empezaste.

## Antes de continuar

Tu repositorio de evaluación ya tiene estos dos commits:

1. `initial project setup` — `78a1154`.
2. `configurar proyecto MediSupply` — `5cb10f6`.

Los **pasos 01 y 02** están realizados. Sigue desde el **paso 03** si ya creaste esos archivos; si no, revisa antes de avanzar.

### Paso 01. Configurar Maven (ya realizado)

- [`pom.xml`](./pom.xml) — referencia de dependencias.
- Tu repositorio de evaluación debe conservar el `artifactId` y `name` **`pc20729u202419311`**, aunque el `pom.xml` de práctica tenga otro nombre.
- Comprobar Spring Boot 4.0.x, Java 25, Spring Web MVC, JPA, MySQL, Lombok, DevTools, SpringDoc y Validation.
- No copiar ni sustituir `mvnw`, `.mvn` o `.git` del proyecto de evaluación.

### Paso 02. Aplicación y configuración (ya realizado)

- [`MediSupplyApplication.java`](./src/main/java/com/medisupply/platform/u202419311/MediSupplyApplication.java) — clase principal.
- [`application.properties`](./src/main/resources/application.properties) — conexión a `medi_supply` y puerto 8080.
- El paquete principal debe llamarse **`com.medisupply.platform.u202419311`**.
- En la carpeta de pruebas, conservar el mismo paquete para que los tests detecten la aplicación.

## Cómo copiar un archivo en IntelliJ

1. Desde el enlace de esta guía abre el archivo original en GitHub.
2. Haz clic en **Copy raw file** (icono de copiar) o entra en **Raw**, selecciona todo y copia.
3. En IntelliJ, abre `src/main/java/com/medisupply/platform/u202419311`.
4. Crea el **Package** que figura en la ruta del archivo (sin repetir `com.medisupply.platform.u202419311`).
5. Haz clic derecho en el paquete → **New → Java Class** (o **Record/Enum** cuando corresponda), escribe el nombre sin `.java`, abre el archivo y reemplaza el contenido con el texto copiado.
6. Para `.properties`, crea el archivo dentro de `src/main/resources` y copia el contenido.
7. Verifica la primera línea `package`, guarda, comprueba que no haya errores y luego ejecuta el bloque de comandos del paso correspondiente.
8. Si ya existe el archivo, **edítalo**; no crees duplicados.

## Orden de archivos y commits

### Paso 03. Value Objects y validaciones

Validaciones del código, UUID, período y cantidad. Incluye `contains()` y `addUnits()`.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`DomainValidationException.java`](./src/main/java/com/medisupply/platform/u202419311/shared/domain/DomainValidationException.java) — `src/main/java/com/medisupply/platform/u202419311/shared/domain/DomainValidationException.java`
- [`RequestCode.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/RequestCode.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/RequestCode.java`
- [`FacilityId.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FacilityId.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FacilityId.java`
- [`FulfillmentPeriod.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FulfillmentPeriod.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FulfillmentPeriod.java`
- [`SupplyBatch.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/SupplyBatch.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/SupplyBatch.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/shared/domain/DomainValidationException.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/RequestCode.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FacilityId.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/FulfillmentPeriod.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/valueobjects/SupplyBatch.java"
git commit -m "feat: agregar objetos de valor y validaciones"
git push origin main
```


### Paso 04. Agregado y estado de la solicitud

Estado y reglas del agregado principal, incluida urgencia del 1 al 5 y fechas de auditoría.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`SupplyRequestStatus.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequestStatus.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequestStatus.java`
- [`SupplyRequest.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequest.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequest.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequestStatus.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/domain/model/aggregates/SupplyRequest.java"
git commit -m "feat: crear agregado de solicitudes"
git push origin main
```


### Paso 05. Repositorio del dominio

Contrato del repositorio, sin dependencia directa de JPA.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`SupplyRequestRepository.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/domain/repositories/SupplyRequestRepository.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/domain/repositories/SupplyRequestRepository.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/procurement/domain/repositories/SupplyRequestRepository.java"
git commit -m "feat: definir repositorio de solicitudes"
git push origin main
```


### Paso 06. Persistencia con JPA

Mapeo a tabla `supply_requests`, restricción `UNIQUE` y almacenamiento mediante JPA.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`SupplyRequestEntity.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/entities/SupplyRequestEntity.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/entities/SupplyRequestEntity.java`
- [`SupplyRequestJpaRepository.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/repositories/SupplyRequestJpaRepository.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/repositories/SupplyRequestJpaRepository.java`
- [`SupplyRequestRepositoryAdapter.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/adapters/SupplyRequestRepositoryAdapter.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/adapters/SupplyRequestRepositoryAdapter.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/entities/SupplyRequestEntity.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/repositories/SupplyRequestJpaRepository.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/infrastructure/persistence/jpa/adapters/SupplyRequestRepositoryAdapter.java"
git commit -m "feat: guardar solicitudes en MySQL"
git push origin main
```


### Paso 07. Comando y caso de uso

Convierte datos de entrada en objetos de dominio, comprueba duplicados y guarda.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`Result.java`](./src/main/java/com/medisupply/platform/u202419311/shared/domain/Result.java) — `src/main/java/com/medisupply/platform/u202419311/shared/domain/Result.java`
- [`CreateSupplyRequestCommand.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestCommand.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestCommand.java`
- [`CreateSupplyRequestHandler.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestHandler.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestHandler.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/shared/domain/Result.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestCommand.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/application/internal/commandservices/CreateSupplyRequestHandler.java"
git commit -m "feat: implementar registro de solicitudes"
git push origin main
```


### Paso 08. Recursos y transformador HTTP

Clases para el JSON de entrada, el JSON de respuesta y la conversión entre capas.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`CreateSupplyRequestResource.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/CreateSupplyRequestResource.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/CreateSupplyRequestResource.java`
- [`SupplyRequestResource.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/SupplyRequestResource.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/SupplyRequestResource.java`
- [`SupplyRequestAssembler.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/transform/SupplyRequestAssembler.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/transform/SupplyRequestAssembler.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/CreateSupplyRequestResource.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/resources/SupplyRequestResource.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/transform/SupplyRequestAssembler.java"
git commit -m "feat: crear recursos y mapeadores REST"
git push origin main
```


### Paso 09. Endpoint POST

Implementa `POST /api/v1/supply-requests` y devuelve HTTP 201 o un conflicto.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`BusinessConflictException.java`](./src/main/java/com/medisupply/platform/u202419311/shared/domain/BusinessConflictException.java) — `src/main/java/com/medisupply/platform/u202419311/shared/domain/BusinessConflictException.java`
- [`SupplyRequestsController.java`](./src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/SupplyRequestsController.java) — `src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/SupplyRequestsController.java`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/shared/domain/BusinessConflictException.java" \
  "src/main/java/com/medisupply/platform/u202419311/procurement/interfaces/rest/SupplyRequestsController.java"
git commit -m "feat: exponer endpoint de solicitudes"
git push origin main
```


### Paso 10. Errores y mensajes en dos idiomas

Errores HTTP 400, 409 y 500 con mensajes según `Accept-Language`.

**Crea cada archivo en la ruta que indica el enlace y copia todo su contenido:**

- [`ApiError.java`](./src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/resources/ApiError.java) — `src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/resources/ApiError.java`
- [`GlobalExceptionHandler.java`](./src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/GlobalExceptionHandler.java) — `src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/GlobalExceptionHandler.java`
- [`messages.properties`](./src/main/resources/messages.properties) — `src/main/resources/messages.properties`
- [`messages_es.properties`](./src/main/resources/messages_es.properties) — `src/main/resources/messages_es.properties`

```bash
git add "src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/resources/ApiError.java" \
  "src/main/java/com/medisupply/platform/u202419311/shared/interfaces/rest/GlobalExceptionHandler.java" \
  "src/main/resources/messages.properties" \
  "src/main/resources/messages_es.properties"
git commit -m "feat: gestionar errores y mensajes localizados"
git push origin main
```

## Paso 11. Verificar el funcionamiento

Primero comprueba que estás dentro del repositorio de evaluación:

```bash
git remote -v
git status
java -version
./mvnw -version
```

La URL debe terminar en `okudiaz124/pc20729u202419311.git`. **No hagas commits desde otro repositorio**.

Comprobar la compilación:

```bash
./mvnw clean compile
```

La aplicación necesita MySQL activo y la base de datos `medi_supply`. La configuración usa `DB_USERNAME` y `DB_PASSWORD` si tu servidor requiere credenciales diferentes. No publiques contraseñas en GitHub.

Para ejecutar el servicio:

```bash
./mvnw spring-boot:run
```

En una segunda terminal, probar el endpoint:

```bash
curl -i -X POST http://localhost:8080/api/v1/supply-requests \
  -H "Content-Type: application/json" \
  -H "Accept-Language: es-PE" \
  -d '{
    "requestCode":"SUP-001",
    "facilityId":"550e8400-e29b-41d4-a716-446655440000",
    "fulfillmentPeriodStartDate":"2026-11-21",
    "fulfillmentPeriodEndDate":"2026-11-25",
    "supplyBatchQuantity":10,
    "supplyBatchUnit":"BOX",
    "urgencyLevel":3,
    "status":"PENDING",
    "requestNotes":"Materiales para el área de emergencia"
  }'
```

El primer envío debe devolver **201** si MySQL está listo. Repetir el mismo `requestCode` debe devolver **409**. Enviar una cantidad menor o igual a cero debe devolver **400**. Prueba también `Accept-Language: en-US`.

### Si algo sale mal

- **Error de clase o paquete:** revisar el `package` y la ruta del archivo; no crear otra `@SpringBootApplication`.
- **No reconoce Lombok:** comprobar el procesador de anotaciones y recargar Maven.
- **Error de MySQL:** verificar servicio, usuario, contraseña y existencia de `medi_supply`.
- **Error 500:** revisar la consola de IntelliJ y la excepción concreta.
- **Git push rechazado:** revisar `git remote -v`, `git status` y `git pull --rebase` solo si tu árbol de trabajo está limpio.

## Reglas del desarrollo

- JavaDoc en inglés con el nombre de autor indicado en el enunciado.
- Comentarios cortos con `//` en español cuando ayuden.
- Documentación `.md` en español.
- Sin endpoints GET, PUT ni DELETE si no forman parte del enunciado.
- Un commit por grupo de archivos **realmente creado y revisado**.
- No alterar fechas, identidad ni historial de commits.

## Estado de comprobación

Esta es una base de referencia preparada a partir de las imágenes del examen disponibles en la conversación. **No hay constancia de que el proyecto completo se haya compilado o probado contra MySQL.** La evaluación debe contrastarse con las ocho páginas del enunciado; en la conversación se recibieron cuatro páginas.
