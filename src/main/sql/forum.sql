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

-- Dumping structure for table forum.forum
CREATE TABLE IF NOT EXISTS `forum` (
  `forumId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parentId` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`forumId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table forum.forum: ~7 rows (approximately)
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` (`forumId`, `parentId`, `name`, `description`) VALUES
	(1, 0, 'Game', 'Anything game related.'),
	(2, 0, 'Social', 'Join our community!'),
	(3, 1, 'Story Discussion', 'Discuss the story.'),
	(4, 1, 'Game Help', 'Need help? Check here!'),
	(5, 1, 'Suggestions', 'Any feedback is greatly appreciated!'),
	(6, 2, 'Introduce Yourself', 'A great place to get to know the community!'),
	(7, 2, 'Forum Games', 'Play silly games. Or whatever.');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
