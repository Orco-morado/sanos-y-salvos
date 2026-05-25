CREATE TABLE historial_mascota (
    id_historial int(4) NOT NULL AUTO_INCREMENT,
    descripcion_tratamientos varchar(110) NOT NULL,
    cant_vacunas int(2) NOT NULL,
    des_estado_mascota varchar(200) NOT NULL,
    estado tinyint(1) NOT NULL,
    PRIMARY KEY (id_historial)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;