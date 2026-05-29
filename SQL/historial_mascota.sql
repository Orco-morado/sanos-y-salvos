-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2026 a las 21:31:33
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
-- Estructura de tabla para la tabla `historial_mascota`
--

CREATE TABLE `historial_mascota` (
  `id_historial` int(11) NOT NULL AUTO_INCREMENT,
  `id_mascota` int(11) NOT NULL, -- LA COLUMNA NUEVA
  `descripcion_tratamientos` varchar(200) NOT NULL,
  `cant_vacunas` int(11) NOT NULL,
  `des_estado_mascota` varchar(150) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci; ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_mascota`
--

INSERT INTO `historial_mascota` (`id_historial`, `descripcion_tratamientos`, `cant_vacunas`, `des_estado_mascota`, `estado`) VALUES
(1, 'tratamiento contra pulgas, esguince de tobillo, vacuna contra rabia, tratamiento desparasitante y hi', 3, 'Encontrado en una plaza. Asustado, sucio y con mucha sed, pero sin lesiones físicas visibles. Aún llevaba su collar.', 1),
(2, 'vendar la pata, pastilla para el dolor y vacuna de la rabia.', 4, 'vecino lo trajo porque andaba cojeando Tiene un corte en la pata trasera, Estaba un poco nervioso pero no es agresivo, tiene un chip de información ', 1),
(3, 'Darle agua con jeringa, comida suave de a poco y darle unas vitaminas', 0, 'Lo encontraron en un sitio abandonado. Está muy flaquito y débil, casi no tenía fuerzas, tiene un collar con el numero del dueño', 1),
(4, 'Revisión completa, su primera vacuna, remedio para las pulgas y limpieza de orejas', 1, 'Es un cachorro que andaba llorando en un parque, se nota sano, gordito y con el pelo limpio, no se sabe mayor información de el perro', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historial_mascota`
--
ALTER TABLE `historial_mascota`
  ADD PRIMARY KEY (`id_historial`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_mascota`
--
ALTER TABLE `historial_mascota`
  MODIFY `id_historial` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
