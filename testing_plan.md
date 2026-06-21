# Testing Plan - Sanos y Salvos

## 1. Objetivo

Validar que los microservicios de **Sanos y Salvos** funcionen correctamente a nivel unitario, integracion, API REST, base de datos, gateway y registro en Eureka.

El plan cubre:

- Pruebas automatizadas con Maven/JUnit.
- Pruebas manuales de endpoints REST.
- Validacion de conexion a MySQL.
- Validacion de migraciones Flyway.
- Validacion del API Gateway.
- Validacion de Eureka Server.
- Pruebas basicas de contenedores Docker.

## 2. Alcance

Servicios incluidos:

| Servicio | Puerto | Base de datos | Ruta gateway |
| --- | ---: | --- | --- |
| gateway | 8080 | No aplica | Punto de entrada |
| eureka-server | 8761 | No aplica | No aplica |
| mascota-service | 8081 | sanos_salvos_mascota | /api/v1/mascotas/** |
| duenio-service | 8082 | sanos_salvos_duenio | /api/v1/duenios/** |
| comuna-service | 8083 | sanos_salvos_comuna | /api/v1/comunas/** |
| refugio-service | 8084 | sanos_salvos_refugio | /api/v1/refugios/** |
| veterinaria-service | 8085 | sanos_salvos_veterinaria | /api/v1/veterinarias/** |
| reporte_avistamiento-service | 8086 | sanos_salvos_avistamiento | /api/v1/reporte-avistamiento/** |
| reporte_desaparicion-service | 8087 | sanos_salvos_desaparicion | /api/v1/reporte-desaparicion/** |
| detalles_encuentro-service | 8088 | sanos_salvos_encuentro | /api/v1/detalles-encuentro/** |
| historial_mascota-service | 8089 | sanos_salvos_historial | /api/v1/historial-mascota/** |
| hallador-service | 8091 | sanos_salvos_hallador | /api/v1/halladores/** |

## 3. Herramientas

- Java 21.
- Maven Wrapper: `mvnw.cmd` en Windows o `./mvnw` en Linux/Mac.
- Spring Boot 4.0.6.
- JUnit/Spring Boot Test.
- MySQL local en `localhost:3306`.
- Flyway para migraciones.
- Postman, Insomnia o `curl` para pruebas manuales.
- Docker para validar imagenes.

## 4. Preparacion del ambiente

1. Levantar MySQL en `localhost:3306`.
2. Crear las bases de datos necesarias:

```sql
CREATE DATABASE IF NOT EXISTS sanos_salvos_mascota;
CREATE DATABASE IF NOT EXISTS sanos_salvos_duenio;
CREATE DATABASE IF NOT EXISTS sanos_salvos_comuna;
CREATE DATABASE IF NOT EXISTS sanos_salvos_refugio;
CREATE DATABASE IF NOT EXISTS sanos_salvos_veterinaria;
CREATE DATABASE IF NOT EXISTS sanos_salvos_avistamiento;
CREATE DATABASE IF NOT EXISTS sanos_salvos_desaparicion;
CREATE DATABASE IF NOT EXISTS sanos_salvos_encuentro;
CREATE DATABASE IF NOT EXISTS sanos_salvos_historial;
CREATE DATABASE IF NOT EXISTS sanos_salvos_hallador;
```

3. Confirmar credenciales configuradas:

```properties
spring.datasource.username=root
spring.datasource.password=
```

4. Ejecutar primero Eureka:

```powershell
cd microservicio-service\eureka-server
.\mvnw.cmd spring-boot:run
```

5. Ejecutar los microservicios requeridos y luego el gateway:

```powershell
cd microservicio-service\gateway
.\mvnw.cmd spring-boot:run
```

## 5. Comandos de pruebas automatizadas

Ejecutar pruebas de un servicio:

```powershell
cd microservicio-service\comuna-service
.\mvnw.cmd test
```

Ejecutar pruebas de todos los servicios manualmente:

```powershell
cd microservicio-service\mascota-service; .\mvnw.cmd test
cd ..\duenio-service; .\mvnw.cmd test
cd ..\comuna-service; .\mvnw.cmd test
cd ..\refugio-service; .\mvnw.cmd test
cd ..\veterinaria-service; .\mvnw.cmd test
cd ..\reporte_avistamiento-service; .\mvnw.cmd test
cd ..\reporte_desaparicion-service; .\mvnw.cmd test
cd ..\detalles_encuentro-service; .\mvnw.cmd test
cd ..\historial_mascota-service; .\mvnw.cmd test
cd ..\hallador-service; .\mvnw.cmd test
cd ..\gateway; .\mvnw.cmd test
cd ..\eureka-server; .\mvnw.cmd test
```

Resultado esperado:

- Build en estado `SUCCESS`.
- Sin errores de contexto Spring.
- Sin errores de conexion a base de datos cuando se ejecuten pruebas con contexto completo.
- Sin errores de migraciones Flyway.

## 6. Casos de prueba por API

Aplicar esta matriz a cada recurso principal:

| Caso | Endpoint | Resultado esperado |
| --- | --- | --- |
| Listar registros | `GET /api/v1/{recurso}` | HTTP 200 y lista JSON |
| Buscar existente | `GET /api/v1/{recurso}/{id}` | HTTP 200 y objeto JSON |
| Buscar inexistente | `GET /api/v1/{recurso}/999999` | HTTP 404 o respuesta controlada |
| Crear valido | `POST /api/v1/{recurso}` | HTTP 201/200 y registro creado |
| Crear invalido | `POST /api/v1/{recurso}` con campos faltantes | HTTP 400 o error controlado |
| Actualizar existente | `PUT /api/v1/{recurso}/{id}` | HTTP 200 y datos actualizados |
| Actualizar inexistente | `PUT /api/v1/{recurso}/999999` | HTTP 404 o respuesta controlada |
| Eliminar existente | `DELETE /api/v1/{recurso}/{id}` | HTTP 200/204 |
| Eliminar inexistente | `DELETE /api/v1/{recurso}/999999` | HTTP 404 o respuesta controlada |

Endpoints base:

- `/api/v1/mascotas`
- `/api/v1/especies`
- `/api/v1/duenios`
- `/api/v1/comunas`
- `/api/v1/refugios`
- `/api/v1/tipos`
- `/api/v1/veterinarias`
- `/api/v1/reporte-avistamiento`
- `/api/v1/reporte-desaparicion`
- `/api/v1/detalles-encuentro`
- `/api/v1/historial-mascota`
- `/api/v1/halladores`

Endpoints especiales:

- `GET /api/v1/refugios/comunas/{id}`
- `GET /api/v1/veterinarias/comunas/{id}`
- `GET /api/v1/historial-mascota/{id}/completo`

## 7. Pruebas del gateway

Con el gateway activo en `http://localhost:8080`, validar que enrute correctamente:

```powershell
curl http://localhost:8080/api/v1/comunas
curl http://localhost:8080/api/v1/mascotas
curl http://localhost:8080/api/v1/duenios
curl http://localhost:8080/api/v1/refugios
curl http://localhost:8080/api/v1/veterinarias
curl http://localhost:8080/api/v1/reporte-avistamiento
curl http://localhost:8080/api/v1/reporte-desaparicion
curl http://localhost:8080/api/v1/detalles-encuentro
curl http://localhost:8080/api/v1/historial-mascota
curl http://localhost:8080/api/v1/halladores
```

Resultado esperado:

- El gateway responde usando el servicio correspondiente.
- Si un servicio esta apagado, el error debe ser claro y no debe afectar a los demas servicios.

## 8. Pruebas de Eureka

URL:

```text
http://localhost:8761
```

Validaciones:

- Eureka levanta correctamente.
- Cada microservicio aparece registrado con su nombre.
- Los servicios mantienen estado `UP`.
- Si se apaga un servicio, Eureka lo elimina o marca fuera de servicio despues del intervalo configurado.

## 9. Pruebas de base de datos y Flyway

Validaciones:

- Cada servicio conecta a su base de datos correspondiente.
- Las migraciones ubicadas en `src/main/resources/db/migration` se ejecutan sin error.
- Las tablas necesarias existen despues del arranque.
- Los datos iniciales de los scripts `V2__...sql` quedan insertados.
- `duenio-service` tiene `spring.flyway.enabled=false`; si se espera migracion automatica, debe activarse o documentarse como decision del proyecto.

## 10. Pruebas Docker

Construir imagen de un servicio:

```powershell
cd microservicio-service\comuna-service
docker build -t comuna-service:test .
```

Validaciones:

- La imagen se construye sin errores.
- El contenedor inicia correctamente.
- El puerto expuesto coincide con `server.port`.
- El servicio puede conectarse a MySQL y Eureka desde el entorno Docker.

Nota: si se ejecuta dentro de Docker, `localhost` apunta al contenedor, no al host. Puede ser necesario usar variables de entorno, red Docker o `host.docker.internal`.

## 11. Criterios de aceptacion

El testing se considera aprobado cuando:

- Todos los comandos `mvnw test` terminan en `SUCCESS`.
- Eureka registra los microservicios activos.
- El gateway responde en el puerto `8080`.
- Todos los endpoints CRUD principales responden con codigos HTTP correctos.
- Las respuestas de error son controladas para IDs inexistentes y datos invalidos.
- No existen errores de conexion con MySQL.
- Las migraciones Flyway se ejecutan sin fallas en los servicios donde estan habilitadas.
- Las imagenes Docker principales se construyen correctamente.

## 12. Registro de resultados

| Fecha | Servicio | Tipo de prueba | Resultado | Observaciones |
| --- | --- | --- | --- | --- |
|  |  | Unit/Integration/API/Docker | Pendiente |  |
|  |  | Unit/Integration/API/Docker | Pendiente |  |
|  |  | Unit/Integration/API/Docker | Pendiente |  |

## 13. Riesgos detectados

- No existe un `docker-compose.yml` visible para levantar todo el ambiente de forma unificada.
- Los servicios dependen de MySQL local con usuario `root` y password vacia.
- Las pruebas con `@SpringBootTest` pueden fallar si MySQL o Eureka no estan activos.
- Hay servicios con endpoints secundarios como `/api/v1/tipos` y `/api/v1/especies` que no aparecen en las rutas del gateway.
- Hay puertos cercanos o repetidos a revisar: `hallador-service` usa `8091` y el proyecto base `microservicio-service` tambien declara `8091`.

## 14. Pendientes recomendados

- Agregar perfil `test` con H2 o Testcontainers para no depender de MySQL local.
- Agregar pruebas de controller con `MockMvc`.
- Agregar pruebas de service con repositorios mockeados.
- Agregar pruebas de repository con datos controlados.
- Agregar una coleccion Postman/Insomnia con todos los endpoints.
- Agregar `docker-compose.yml` para MySQL, Eureka, gateway y microservicios.
