-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2026 a las 03:26:15
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
-- Estructura de tabla para la tabla `detalles_encuentro`
--

CREATE TABLE `detalles_encuentro` (
  `id_informe` int(3) NOT NULL,
  `fecha_encuentro` date NOT NULL,
  `detalles_mascota` varchar(100) NOT NULL,
  `descripcion_para_encuentro` varchar(100) NOT NULL,
  `direccion` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalles_encuentro`
--

INSERT INTO `detalles_encuentro` (`id_informe`, `fecha_encuentro`, `detalles_mascota`, `descripcion_para_encuentro`, `direccion`) VALUES
(1, '2026-05-08', 'perro negro rasa boxer con mancha blanca en el ojo derecho, le falta un pedazo en la oreja izquierda', 'se espera que el dueño este vestido de polera azul marca nike, con un jeas negro y zapatillas de col', 'Av. Diego P'),
(2, '2026-05-29', 'gato blanco con pelo largo, ojos verdes y collar negro', 'descripcion para encuentro\r\ndueño pelo largo castaño, chaqueta de mezclilla, polera negra, jeans azu', 'metro lo pr'),
(3, '2026-05-14', 'perro sin rasa especifica de pelo dorado y tamaño medio, tiene una mancha en el pelo con la forma de', 'descripcion para encuentro\r\ndueño pelo rubio recogido en un moño, aros grandes, cortavientos azul ma', 'Av. Camilo ');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalles_encuentro`
--
ALTER TABLE `detalles_encuentro`
  ADD PRIMARY KEY (`id_informe`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalles_encuentro`
--
ALTER TABLE `detalles_encuentro`
  MODIFY `id_informe` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
