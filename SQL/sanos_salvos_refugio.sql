-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2026 a las 20:27:52
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
-- Base de datos: `sanos_salvos_refugio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'root', '2026-05-09 15:14:40', 0, 1),
(2, '2', 'insert table refugio', 'SQL', 'V2__insert_table_refugio.sql', 232298345, 'root', '2026-05-21 18:23:25', 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `refugio`
--

CREATE TABLE `refugio` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `num_contacto_r` varchar(11) NOT NULL,
  `correo_r` varchar(50) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `capacidad_maxima` int(11) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `refugio`
--

INSERT INTO `refugio` (`id`, `nombre`, `direccion`, `num_contacto_r`, `correo_r`, `id_tipo`, `capacidad_maxima`, `activo`) VALUES
(1, 'Amigos Peludos', '123 de concha y toro', '23456234', 'amigos.pel@amigospeludos.cl', 2, 50, 1),
(2, 'Refugio', '345 santa rosa', '99803458', 'refugi@refugio.cl', 3, 103, 1),
(3, 'Refugio Canino', '145 calle siempreviva', '98765432', 'rcanin@refugio.cl', 1, 205, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_refugio`
--

CREATE TABLE `tipo_refugio` (
  `id_tipo` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_refugio`
--

INSERT INTO `tipo_refugio` (`id_tipo`, `tipo`, `activo`) VALUES
(1, 'privado', 1),
(2, 'publico', 1),
(3, 'independiente', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Indices de la tabla `refugio`
--
ALTER TABLE `refugio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `tipo_refugio`
--
ALTER TABLE `tipo_refugio`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `refugio`
--
ALTER TABLE `refugio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_refugio`
--
ALTER TABLE `tipo_refugio`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
