CREATE TABLE reporte_desaparicion (
    id int(11) NOT NULL AUTO_INCREMENT,
    id_duenio int(11) NOT NULL,
    nombre_mascota varchar(50) NOT NULL,
    fecha date NOT NULL,
    numero_duenio int(11) NOT NULL,
    direccion varchar(50) NOT NULL,
    tipo_mascota varchar(50) NOT NULL,
    activo tinyint(1) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;