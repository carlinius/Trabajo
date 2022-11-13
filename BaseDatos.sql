-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para actividad
CREATE DATABASE IF NOT EXISTS `actividad` /*!40100 DEFAULT CHARACTER SET latin2 */;
USE `actividad`;

-- Volcando estructura para tabla actividad.matriculas
CREATE TABLE IF NOT EXISTS `matriculas` (
  `NumeroMatricula` int(50) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `registroCivil` varchar(100) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `FechaNacimiento` varchar(20) NOT NULL,
  `fechaIngresoGuarderia` varchar(20) NOT NULL,
  `Grado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla actividad.matriculas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `matriculas` DISABLE KEYS */;
/*!40000 ALTER TABLE `matriculas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
