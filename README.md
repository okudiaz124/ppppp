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

## Configurar Git y acceder a GitHub

Abrir la terminal de IntelliJ IDEA o Terminal de macOS.

Configurar el nombre y correo que aparecen en los commits:

```bash
git config --global user.name "Matthew Shinko Okuhama Diaz"
git config --global user.email "mattoku4@gmail.com"
git config --global --list
```

Iniciar sesión en GitHub con GitHub CLI:

```bash
gh auth login
```

Seleccionar `GitHub.com`, luego `HTTPS`, responder `Yes` a la autenticación de Git y elegir `Login with a web browser`. Abrir `https://github.com/login/device`, introducir el código temporal mostrado **en tu propia terminal** y autorizar la aplicación. No compartir ese código ni tokens.

Comprobar la sesión:

```bash
gh auth status
```

Si el comando `gh` no existe y Homebrew está instalado:

```bash
brew install gh
```

Clonar este repositorio:

```bash
git clone https://github.com/okudiaz124/ppppp.git
cd ppppp
```

Para registrar cambios reales en el proyecto:

```bash
git status
git add .
git commit -m "feat: agregar funcionalidad"
git push origin main
```

En un equipo compartido, cerrar la sesión y limpiar los datos globales al terminar:

```bash
gh auth logout
git config --global --unset user.name
git config --global --unset user.email
```

La configuración `user.name` y `user.email` identifica los commits; por sí sola **no inicia sesión** en GitHub.
