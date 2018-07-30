-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table gameoforum.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(40) CHARACTER SET latin1 NOT NULL,
  `firstName` varchar(35) DEFAULT NULL,
  `lastName` varchar(35) DEFAULT NULL,
  `email` varchar(254) CHARACTER SET latin1 NOT NULL,
  `registrationTime` bigint(20) NOT NULL,
  `dob` date NOT NULL,
  `gender` enum('Male','Female','Other') CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  KEY `login` (`password`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Dumping data for table gameoforum.user: ~50 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`, `username`, `password`, `firstName`, `lastName`, `email`, `registrationTime`, `dob`, `gender`) VALUES
	(1, 'cecil1', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Cecil', 'Camels', 'cecil1@yahoo.com', 1408068190, '1998-12-13', 'Male'),
	(2, 'bella2', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Bella', 'Miller', 'bella2@yahoo.com', 1484003675, '1955-05-24', 'Female'),
	(3, 'selena3', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Selena', 'Anderson', 'selena3@hotmail.com', 1397610252, '1960-04-12', 'Female'),
	(4, 'simon4', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Simon', 'Wyatt', 'simon4@hotmail.com', 1511022182, '1967-04-25', 'Male'),
	(5, 'frank5', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Frank', 'Anderson', 'frank5@gmail.com', 1517018512, '1983-06-21', 'Male'),
	(6, 'kent6', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Kent', 'Swanson', 'kent6@gmail.com', 1408799649, '1963-11-12', 'Male'),
	(7, 'aaron7', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Aaron', 'Anderson', 'aaron7@gmail.com', 1510393869, '1947-01-29', 'Male'),
	(8, 'cody8', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Cody', 'Steele', 'cody8@hotmail.com', 1474772429, '1954-02-05', 'Male'),
	(9, 'ray9', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Ray', 'Wyatt', 'ray9@yahoo.com', 1421563037, '1966-07-31', 'Male'),
	(10, 'andrea10', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Andrea', 'Wyatt', 'andrea10@yahoo.com', 1524446636, '1961-10-20', 'Female'),
	(11, 'nate11', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Nate', 'Vincenti', 'nate11@hotmail.com', 1453086034, '1945-06-19', 'Male'),
	(12, 'isabelle12', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Isabelle', 'Doe', 'isabelle12@gmail.com', 1422167718, '1947-04-21', 'Female'),
	(13, 'cindy13', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Cindy', 'Perkins', 'cindy13@hotmail.com', 1444951254, '1943-11-09', 'Female'),
	(14, 'ana14', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Ana', 'Thorpe', 'ana14@hotmail.com', 1395473747, '1962-10-09', 'Female'),
	(15, 'kendra15', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Kendra', 'Traeger', 'kendra15@gmail.com', 1461840169, '1979-10-15', 'Female'),
	(16, 'berta16', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Berta', 'Baker', 'berta16@yahoo.com', 1407201846, '1948-11-13', 'Female'),
	(17, 'berta17', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Berta', 'Thorpe', 'berta17@gmail.com', 1475520048, '1962-01-15', 'Female'),
	(18, 'dona18', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Dona', 'Vincenti', 'dona18@yahoo.com', 1460614037, '1968-05-01', 'Female'),
	(19, 'nana19', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Nana', 'Ludgate', 'nana19@yahoo.com', 1438793876, '1985-07-21', 'Female'),
	(20, 'serra20', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Serra', 'Thompson', 'serra20@gmail.com', 1466988864, '1960-10-02', 'Female'),
	(21, 'nate21', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Nate', 'Miller', 'nate21@yahoo.com', 1420860978, '2001-02-18', 'Male'),
	(22, 'mandy22', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Mandy', 'Traeger', 'mandy22@yahoo.com', 1480661734, '1948-10-13', 'Female'),
	(23, 'harry23', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Harry', 'Camels', 'harry23@yahoo.com', 1416149586, '1999-06-21', 'Male'),
	(24, 'mary24', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Mary', 'Spencer', 'mary24@yahoo.com', 1396910632, '1989-11-11', 'Female'),
	(25, 'abby25', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Abby', 'Burnstein', 'abby25@gmail.com', 1460471530, '1978-04-01', 'Female'),
	(26, 'karla26', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Karla', 'Lewis', 'karla26@yahoo.com', 1448483972, '1977-08-16', 'Female'),
	(27, 'nana27', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Nana', 'Andrews', 'nana27@yahoo.com', 1423405933, '1979-09-18', 'Female'),
	(28, 'hillary28', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Hillary', 'Thorpe', 'hillary28@gmail.com', 1460191538, '1947-06-15', 'Female'),
	(29, 'frank29', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Frank', 'Burnstein', 'frank29@yahoo.com', 1476880604, '1947-04-17', 'Male'),
	(30, 'aaron30', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Aaron', 'Evans', 'aaron30@hotmail.com', 1464835512, '1993-11-08', 'Male'),
	(31, 'cindy31', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Cindy', 'Spencer', 'cindy31@gmail.com', 1398698917, '1966-12-13', 'Female'),
	(32, 'efrain32', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Efrain', 'Burlington', 'efrain32@hotmail.com', 1424294837, '2001-05-17', 'Male'),
	(33, 'kendra33', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Kendra', 'Traeger', 'kendra33@hotmail.com', 1425213201, '1988-08-19', 'Female'),
	(34, 'bob34', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Bob', 'Andrews', 'bob34@yahoo.com', 1474939438, '1994-08-07', 'Male'),
	(35, 'nana35', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Nana', 'Lewis', 'nana35@hotmail.com', 1405777634, '1942-04-08', 'Female'),
	(36, 'lenny36', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Lenny', 'Burnstein', 'lenny36@gmail.com', 1400986941, '1946-01-29', 'Male'),
	(37, 'fedor37', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Fedor', 'Wilson', 'fedor37@yahoo.com', 1443664997, '1999-09-01', 'Male'),
	(38, 'ray38', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Ray', 'Smith', 'ray38@yahoo.com', 1410118249, '1940-09-16', 'Male'),
	(39, 'jennifer39', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Jennifer', 'Thompson', 'jennifer39@yahoo.com', 1431499838, '1985-01-13', 'Female'),
	(40, 'mirna40', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Mirna', 'Gates', 'mirna40@gmail.com', 1479422225, '1978-10-05', 'Female'),
	(41, 'zara41', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Zara', 'Wilson', 'zara41@hotmail.com', 1390208212, '1995-03-02', 'Female'),
	(42, 'andy42', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Andy', 'Burlington', 'andy42@yahoo.com', 1408973090, '1986-02-28', 'Male'),
	(43, 'guy43', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Guy', 'Edwards', 'guy43@hotmail.com', 1469864257, '1951-12-12', 'Male'),
	(44, 'selena44', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Selena', 'White', 'selena44@hotmail.com', 1407392743, '1940-06-06', 'Female'),
	(45, 'aurora45', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Aurora', 'Thorpe', 'aurora45@yahoo.com', 1446296426, '1986-01-20', 'Female'),
	(46, 'ray46', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Ray', 'Williams', 'ray46@yahoo.com', 1460486334, '1969-07-24', 'Male'),
	(47, 'terry47', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Terry', 'Anderson', 'terry47@yahoo.com', 1525598725, '1994-09-09', 'Male'),
	(48, 'valencia48', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Valencia', 'Burnstein', 'valencia48@gmail.com', 1399603256, '1990-07-04', 'Female'),
	(49, 'randy49', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Randy', 'Smith', 'randy49@hotmail.com', 1463923623, '1977-08-23', 'Male'),
	(50, 'derick50', 'aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d', 'Derick', 'Thorpe', 'derick50@gmail.com', 1479836299, '1993-08-21', 'Male');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
