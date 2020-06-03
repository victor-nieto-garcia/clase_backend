-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-06-2020 a las 05:39:52
-- Versión del servidor: 10.2.31-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(255) DEFAULT NULL,
  `valor_total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `cliente`, `valor_total`) VALUES
(1, 'string', 5000),
(2, 'string', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_items`
--

DROP TABLE IF EXISTS `factura_items`;
CREATE TABLE IF NOT EXISTS `factura_items` (
  `factura_id` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_283g3cvagak8fmhnjsun7lmyn` (`items_id`),
  KEY `FK10td8082kmppa0y6vcxndmjox` (`factura_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura_items`
--

INSERT INTO `factura_items` (`factura_id`, `items_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `valor_total` double NOT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkwnhatcjl5aynqitkhy513pka` (`producto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `item`
--

INSERT INTO `item` (`id`, `cantidad`, `valor_total`, `producto_id`) VALUES
(1, 2, 2000, 1),
(2, 3, 3000, 2),
(3, 2, 2000, 4),
(4, 3, 3000, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`) VALUES
(1, 'azjucar', 200),
(2, 'string', 0),
(25, 'Tomate', 5000),
(26, 'Cebolla', 500);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura_items`
--
ALTER TABLE `factura_items`
  ADD CONSTRAINT `FK10td8082kmppa0y6vcxndmjox` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`),
  ADD CONSTRAINT `FKrps2y77ug21tchon0op2166jp` FOREIGN KEY (`items_id`) REFERENCES `item` (`id`);

--
-- Filtros para la tabla `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FKkwnhatcjl5aynqitkhy513pka` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
