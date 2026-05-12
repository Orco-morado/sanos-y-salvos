-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2026 a las 01:28:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sanos_y_salvos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_avistamiento`
--

CREATE TABLE `reporte_avistamiento` (
  `id_reporte_avistamiento` int(3) NOT NULL,
  `descripcion_avistamiento` varchar(50) NOT NULL,
  `direccion_avistamiento` varchar(20) NOT NULL,
  `nombre_persona_avistamiento` varchar(40) NOT NULL,
  `fecha_avistamiento` date NOT NULL,
  `estado_avistamiento` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reporte_avistamiento`
--

INSERT INTO `reporte_avistamiento` (`id_reporte_avistamiento`, `descripcion_avistamiento`, `direccion_avistamiento`, `nombre_persona_avistamiento`, `fecha_avistamiento`, `estado_avistamiento`) VALUES
(3, 'perro negro similar a la descripcion de cholo, le ', 'el araucano 11502', 'jose jose', '2026-04-29', 1),
(4, 'gato blanco con mancha nera en la cara ', 'Calle El Cabildo 450', 'pedro pascal', '2026-05-10', 1),
(5, 'perro amarillo con un pie cojo posiblemente el que', 'Avenida La Florida 9', 'juan pablo', '2026-05-01', 1),
(6, 'perro negro similar a cholo, le falta un pedazo en', 'Avenida México 9496,', 'maria jose', '2026-05-10', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reporte_avistamiento`
--
ALTER TABLE `reporte_avistamiento`
  ADD PRIMARY KEY (`id_reporte_avistamiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reporte_avistamiento`
--
ALTER TABLE `reporte_avistamiento`
  MODIFY `id_reporte_avistamiento` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
