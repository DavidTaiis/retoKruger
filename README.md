# retoKruger
Abrir el proyecto con intelliJ IDEA actualizar dependencias

En Postgresql crear base de datos con nombre retoKruger

En el archivo application.propierties especificar usuario y contraseña de base de datos

Ejecutar el proyecto para crear las tablas en base de datos

Ejecutar en la base de datos los siguientes querys para creación roles y usuario administrador

INSERT INTO public.rol(
	id, nombre)
	VALUES (1, 'Administrador');

INSERT INTO public.rol(
	id, nombre)
	VALUES (2, 'Empleado');

INSERT INTO public.usuario(
	id, apellidos, cedula, celular, contrasena, correo, direccion, dosis, fecha, fecha_nacimiento, nombres, rol, vacuna, vacunado)
	VALUES (1, 'Administrador', 'admin', null, 'admin', 'admin@admin.com', null, null, null, null, 'Administrador', 1, null, null);


Ejecutar nuevamente el proyecto

Dirigirse a la siguiente dirección para pruebas de Apis

http://localhost:8080/swagger-ui/index.html

Nota: los filtros se encuentran en el Api findAll, para la fecha es necesario que tenga este formato 2022-10-20/2022-11-30
