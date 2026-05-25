CREATE TABLE reporte_avistamiento (
    id_avistamiento int(3) NOT NULL AUTO_INCREMENT,
    descripcion varchar(50) NOT NULL,
    direccion_avistamiento varchar(20) NOT NULL,
    persona_avistamiento varchar(40) NOT NULL,
    fecha_avistamiento date NOT NULL,
    estado_avistamiento tinyint(1) NOT NULL,
    PRIMARY KEY (id_avistamiento)
);