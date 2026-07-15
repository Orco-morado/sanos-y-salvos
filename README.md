# sanos-y-salvos
🛠️ Paso a Paso de Ejecución 

Paso 1: Iniciar el Motor de Base de DatosDado que los microservicios se conectan a tu base de datos local a través de host.docker.internal, es obligatorio que el motor de base de datos esté encendido antes de levantar los contenedores.  Abre el panel de control de XAMPP.  Inicia el servicio de MySQL.  

Paso 2: Iniciar el Motor de ContenedoresAbre la aplicación Docker Desktop y espera a que el motor (Engine) indique que está corriendo (estado Running).  

Paso 3: Desplegar la Infraestructura (Docker Compose)Abre una terminal (PowerShell o CMD) en la carpeta raíz de tu proyecto (donde se encuentra el archivo docker-compose.yml) y ejecuta el siguiente comando:Bashdocker compose up -d --build
Nota: El flag --build forzará a Docker a compilar el código Java más reciente de cada módulo, empaquetarlo y luego crear la red y levantar los contenedores en segundo plano (-d).

Paso 4: Validar el Registro de Servicios (Eureka)El orquestador levantará primero el servidor Eureka y luego el resto de los módulos. Para verificar que todos los microservicios se encendieron y se registraron correctamente:  Abre tu navegador web.Ingresa a la interfaz gráfica de Eureka: http://localhost:8761.  Deberías ver listados los servicios (GATEWAY, COMUNA-SERVICE, MASCOTA-SERVICE, etc.) bajo la sección "Instances currently registered with Eureka".

🌐 Conexión al Host y Consumo de APIsEl entorno está diseñado para que todo el tráfico del cliente pase por una única puerta de enlace: el API Gateway, el cual está expuesto en tu host en el puerto 8080.  Para conectarte a las distintas funcionalidades, debes hacer tus peticiones HTTP (ya sea desde el frontend, Postman o el navegador) apuntando al Gateway. Él se encargará de rutear la petición al microservicio correspondiente.  Ejemplos de Endpoints 

Disponibles:
Comunas: http://localhost:8080/api/v1/comunas/  
Mascotas: http://localhost:8080/api/v1/mascotas/  
Dueños: http://localhost:8080/api/v1/duenios/  
Refugios: http://localhost:8080/api/v1/refugios/  
Veterinarias: http://localhost:8080/api/v1/veterinarias/  
Avistamientos: http://localhost:8080/api/v1/reporte-avistamiento/  
Desapariciones: http://localhost:8080/api/v1/reporte-desaparicion/  

🛑 Detener el Entorno

Cuando termines de trabajar y desees apagar la arquitectura para liberar recursos de tu máquina, ejecuta el siguiente comando en la misma terminal donde levantaste los servicios:Bashdocker compose down
Esto detendrá t odos los contenedores de los microservicios y eliminará la red interna (microservicios-net) de manera limpia.¿Qué te parece? ¡Si quieres agregarle una sección explicando algo más específico para los profesores o el equipo, me avisas y lo incluimos!


💡
docker compose up -d --build
(Compila el código, construye las imágenes, crea la red interna)

docker compose ps
(Muestra el estado actual de tus contenedores)

docker compose down
(Detiene todos los contenedores y elimina la red creada, liberando todos los recursos de tu máquina.)