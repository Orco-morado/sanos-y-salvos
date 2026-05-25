CREATE TABLE detalles_encuentro (
    id_informe int(3) NOT NULL AUTO_INCREMENT,
    fecha_encuentro date NOT NULL,
    detalles_mascota varchar(100) NOT NULL,
    descripcion_para_encuentro varchar(100) NOT NULL,
    direccion varchar(100) NOT NULL,
    PRIMARY KEY (id_informe)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;