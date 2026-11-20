# MediSupply - Backend

API REST para registrar solicitudes de suministros médicos.

## Tecnologías
- Java 25
- Spring Boot 4.0.4
- Maven
- Spring Data JPA
- MySQL
- SpringDoc OpenAPI

## Base de datos
La aplicación usa el esquema `medi_supply` y la tabla `supply_requests`.

Se necesita MySQL en ejecución. Por defecto se utiliza el usuario `root` y contraseña vacía. Se pueden configurar las variables de entorno `DB_USERNAME` y `DB_PASSWORD`.

## Ejecución
Abrir el proyecto con IntelliJ IDEA, seleccionar JDK 25 y ejecutar `MediSupplyApplication`.

Con Maven:

```bash
mvn spring-boot:run
```

## Endpoint
`POST /api/v1/supply-requests`

Ejemplo de solicitud:

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
  "requestNotes": "Urgent medical supplies required for emergency care"
}
```

Devuelve 201 al registrar, 400 ante datos inválidos, 409 cuando el código está repetido y 500 ante errores imprevistos.

El estado puede omitirse para utilizar `PENDING`. Para solicitar mensajes en español, utilizar la cabecera `Accept-Language: es-PE`. De lo contrario, se utiliza inglés.

La documentación interactiva está disponible en `/swagger-ui/index.html`.

## Estructura
- `procurement/domain`: reglas de negocio, agregado y objetos de valor.
- `procurement/application`: comando y caso de uso.
- `procurement/interfaces`: recurso HTTP y ensamblador.
- `procurement/infrastructure`: persistencia JPA.
- `shared`: patrón Result y manejo común de errores.

## Alcance
Solo se desarrolla el registro POST. No se implementan endpoints GET, PUT ni DELETE.
