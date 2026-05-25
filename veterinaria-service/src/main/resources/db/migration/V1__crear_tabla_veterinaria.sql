CREATE TABLE veterinaria (
    id int(11) NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    direccion varchar(100) NOT NULL,
    num_contacto_v int(11) NOT NULL,
    correo_v varchar(100) NOT NULL,
    id_tipovet int(11) NOT NULL,
    activo tinyint(1) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;