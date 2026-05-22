-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2026 a las 18:56:11
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
-- Estructura de tabla para la tabla `refugio`
--

CREATE TABLE `refugio` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `num_contacto_r` varchar(11) NOT NULL,
  `correo_r` varchar(50) NOT NULL,
  `capacidad_maxima` int(11) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `refugio`
--

INSERT INTO `refugio` (`id`, `nombre`, `direccion`, `num_contacto_r`, `correo_r`, `capacidad_maxima`, `activo`) VALUES
(1, 'Amigos Peludos', '123 de concha y toro', '23456234', 'amigos.pel@amigospeludos.cl', 50, 1),
(2, 'Refugio', '345 santa rosa', '99803458', 'refugi@refugio.cl', 103, 1),
(3, 'Refugio Canino', '145 calle siempreviva', '98765432', 'rcanin@refugio.cl', 205, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `refugio`
--
ALTER TABLE `refugio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `refugio`
--
ALTER TABLE `refugio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
