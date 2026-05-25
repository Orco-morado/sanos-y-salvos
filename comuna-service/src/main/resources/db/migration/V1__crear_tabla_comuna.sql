CREATE TABLE comuna (
    id_comuna int(3) NOT NULL AUTO_INCREMENT,
    nombre_comuna varchar(50) NOT NULL,
    cod_postal int(11) NOT NULL,
    activo tinyint(1) NOT NULL,
    PRIMARY KEY (id_comuna)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;