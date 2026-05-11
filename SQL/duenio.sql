-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2026 a las 00:54:45
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
-- Base de datos: `sanosysalvos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duenio`
--

CREATE TABLE `duenio` (
  `id` int(11) NOT NULL,
  `rut` int(11) NOT NULL,
  `dv` char(1) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `numero` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `duenio`
--

INSERT INTO `duenio` (`id`, `rut`, `dv`, `nombre`, `apellido`, `numero`, `direccion`, `activo`) VALUES
(1, 23045678, '9', 'Maria', 'Perez', 21345678, '135 de la avanida maple', 1),
(2, 20467983, '6', 'Marco', 'Montes', 17823457, '012 de la calle guarico', 1),
(3, 24080123, '7', 'Francine', 'Bequer', 34567891, '986 del pase arbolera', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `duenio`
--
ALTER TABLE `duenio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `duenio`
--
ALTER TABLE `duenio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
