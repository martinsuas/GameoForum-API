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

-- Dumping structure for table gameoforum.thread
CREATE TABLE IF NOT EXISTS `thread` (
  `threadId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `forumId` int(10) unsigned NOT NULL,
  `userId` int(10) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  `creationTime` bigint(20) NOT NULL,
  PRIMARY KEY (`threadId`),
  KEY `forumId` (`forumId`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;

-- Dumping data for table gameoforum.thread: 175 rows
/*!40000 ALTER TABLE `thread` DISABLE KEYS */;
INSERT INTO `thread` (`threadId`, `forumId`, `userId`, `title`, `creationTime`) VALUES
	(1, 2, 33, 'When can I discover the magic?', 1437869506),
	(2, 5, 23, 'Where do I obtain most of the zombies?', 1523763576),
	(3, 4, 41, 'How many times must I defeat all of the Demon Lords?', 1409844667),
	(4, 2, 46, 'How do I discover some of the fruit?', 1423150103),
	(5, 1, 29, 'How many times must I check the orcs?', 1420209495),
	(6, 3, 17, 'How do I revive all of the Holy Swords?', 1518787613),
	(7, 4, 9, 'When can I betray some of the zombies?', 1456818902),
	(8, 5, 31, 'With who do I find all of the dragons?', 1467407130),
	(9, 1, 7, 'How many times must I find some of the elementals?', 1468947119),
	(10, 2, 22, 'How many times must I check most of the magic beans?', 1407716895),
	(11, 3, 40, 'Where do I discover all of the dragons?', 1406420300),
	(12, 4, 10, 'With who do I betray the elementals?', 1427006668),
	(13, 2, 19, 'With who do I check some of the magic?', 1399899556),
	(14, 1, 32, 'How do I obtain all of the fruit?', 1523451883),
	(15, 4, 31, 'Where do I defeat most of the orcs?', 1464110195),
	(16, 2, 35, 'How do I betray most of the goblins?', 1496192450),
	(17, 4, 3, 'With who do I plot against most of the zombies?', 1399626494),
	(18, 5, 29, 'With who do I check all of the orcs?', 1496739687),
	(19, 3, 45, 'When can I obtain all of the insects?', 1511939452),
	(20, 4, 41, 'When can I check the goblins?', 1527781033),
	(21, 2, 6, 'How do I betray the demons?', 1427353152),
	(22, 3, 28, 'Where do I find all of the Holy Swords?', 1402288024),
	(23, 4, 48, 'Where do I revive most of the imps?', 1492023417),
	(24, 3, 7, 'When can I discover some of the goblins?', 1491536373),
	(25, 5, 42, 'How many times must I check most of the pidgeons?', 1432700887),
	(26, 3, 41, 'When can I check the Demon Lords?', 1423137811),
	(27, 5, 1, 'How do I betray some of the elementals?', 1512365636),
	(28, 1, 39, 'With who do I betray the goblins?', 1485975935),
	(29, 3, 31, 'How many times must I defeat most of the vampires?', 1409589596),
	(30, 3, 16, 'When can I find all of the imps?', 1400407154),
	(31, 5, 20, 'How many times must I defeat most of the elementals?', 1521603063),
	(32, 2, 31, 'With who do I plot against the orcs?', 1460592518),
	(33, 1, 3, 'Where do I revive some of the elementals?', 1491277916),
	(34, 5, 35, 'How many times must I defeat most of the zombies?', 1453667767),
	(35, 1, 31, 'With who do I revive the goblins?', 1428104872),
	(36, 2, 18, 'Where do I check some of the dragons?', 1448028530),
	(37, 4, 8, 'With who do I revive the insects?', 1479528552),
	(38, 1, 22, 'How many times must I defeat the Demon Lords?', 1413616065),
	(39, 5, 19, 'With who do I revive the zombies?', 1502748465),
	(40, 1, 23, 'With who do I revive most of the magic?', 1490633561),
	(41, 4, 42, 'How many times must I discover the imps?', 1463715879),
	(42, 3, 26, 'How do I plot against most of the goblins?', 1485110155),
	(43, 1, 26, 'Where do I discover most of the demons?', 1441531239),
	(44, 5, 16, 'Where do I defeat most of the lizards?', 1495213908),
	(45, 4, 12, 'Where do I betray the vampires?', 1426063653),
	(46, 1, 45, 'How do I betray some of the vampires?', 1390432580),
	(47, 4, 25, 'Where do I check some of the goblins?', 1487067753),
	(48, 4, 37, 'How many times must I betray all of the fruit?', 1434460876),
	(49, 4, 12, 'With who do I revive some of the Holy Swords?', 1496934833),
	(50, 5, 22, 'How many times must I discover the magic?', 1504621646),
	(51, 1, 48, 'With who do I plot against all of the vampires?', 1517901453),
	(52, 3, 2, 'Where do I plot against most of the demons?', 1391091432),
	(53, 3, 43, 'How many times must I check most of the magic beans?', 1514849605),
	(54, 1, 3, 'How do I betray all of the vampires?', 1475288278),
	(55, 1, 34, 'When can I plot against most of the lizards?', 1498837226),
	(56, 5, 37, 'With who do I check some of the vampires?', 1509888067),
	(57, 2, 29, 'How do I betray all of the vampires?', 1396638130),
	(58, 1, 27, 'How do I defeat most of the pidgeons?', 1405443696),
	(59, 4, 43, 'Where do I find some of the magic beans?', 1469756672),
	(60, 5, 23, 'How many times must I discover the lizards?', 1412571588),
	(61, 4, 43, 'When can I check some of the imps?', 1423627648),
	(62, 1, 13, 'Where do I obtain the goblins?', 1424795770),
	(63, 2, 42, 'How many times must I obtain the insects?', 1414196955),
	(64, 2, 1, 'How many times must I obtain all of the orcs?', 1441183693),
	(65, 5, 10, 'Where do I betray all of the dragons?', 1454677708),
	(66, 2, 12, 'How do I check all of the orcs?', 1506707551),
	(67, 5, 28, 'How many times must I discover the zombies?', 1467758540),
	(68, 2, 44, 'When can I defeat all of the orcs?', 1391304758),
	(69, 1, 13, 'How do I find all of the insects?', 1455116385),
	(70, 5, 42, 'How many times must I discover the magic?', 1527367493),
	(71, 4, 2, 'How many times must I plot against most of the zombies?', 1414924670),
	(72, 2, 10, 'How do I plot against all of the insects?', 1458899177),
	(73, 1, 11, 'Where do I find most of the demons?', 1412205328),
	(74, 3, 40, 'With who do I plot against some of the zombies?', 1487319101),
	(75, 4, 26, 'When can I revive some of the demons?', 1460622545),
	(76, 4, 13, 'Where do I obtain most of the dragons?', 1437353633),
	(77, 1, 10, 'Where do I find all of the vampires?', 1504733480),
	(78, 4, 41, 'When can I plot against all of the dragons?', 1481833105),
	(79, 1, 6, 'With who do I check the goblins?', 1422576356),
	(80, 2, 30, 'With who do I plot against some of the magic beans?', 1426318950),
	(81, 2, 1, 'With who do I revive all of the pidgeons?', 1484473493),
	(82, 1, 40, 'When can I find most of the insects?', 1493811654),
	(83, 5, 45, 'How do I plot against all of the zombies?', 1475793324),
	(84, 3, 38, 'Where do I plot against all of the lizards?', 1453654222),
	(85, 3, 35, 'Where do I defeat some of the orcs?', 1410329189),
	(86, 1, 29, 'How do I check all of the imps?', 1410718305),
	(87, 3, 35, 'How many times must I revive some of the magic beans?', 1526892971),
	(88, 5, 11, 'With who do I defeat the orcs?', 1515466196),
	(89, 4, 36, 'How many times must I revive the magic beans?', 1530204861),
	(90, 4, 21, 'With who do I betray most of the dragons?', 1512820587),
	(91, 2, 30, 'How many times must I obtain most of the fruit?', 1483902121),
	(92, 3, 29, 'When can I plot against all of the pidgeons?', 1476314597),
	(93, 4, 6, 'With who do I obtain some of the zombies?', 1460445753),
	(94, 3, 49, 'When can I betray some of the orcs?', 1409013650),
	(95, 5, 28, 'How many times must I find all of the imps?', 1460983104),
	(96, 5, 43, 'Where do I check most of the goblins?', 1526205404),
	(97, 4, 41, 'How many times must I find most of the zombies?', 1394933780),
	(98, 2, 26, 'When can I betray some of the magic?', 1412427962),
	(99, 4, 40, 'With who do I find all of the goblins?', 1437011050),
	(100, 3, 35, 'When can I discover some of the vampires?', 1502076278),
	(101, 5, 42, 'When can I defeat all of the insects?', 1464325004),
	(102, 2, 15, 'How do I discover some of the magic beans?', 1453302359),
	(103, 2, 5, 'How many times must I check most of the vampires?', 1453997743),
	(104, 2, 11, 'Where do I find some of the vampires?', 1491601246),
	(105, 1, 27, 'How do I obtain the demons?', 1486497558),
	(106, 3, 36, 'Where do I defeat the fruit?', 1494870354),
	(107, 5, 38, 'With who do I plot against some of the fruit?', 1519160692),
	(108, 1, 46, 'With who do I find the imps?', 1515884269),
	(109, 2, 8, 'How many times must I find some of the orcs?', 1528821492),
	(110, 4, 46, 'With who do I betray most of the insects?', 1442146249),
	(111, 1, 44, 'How many times must I defeat some of the elementals?', 1513159351),
	(112, 3, 45, 'With who do I obtain most of the pidgeons?', 1518800859),
	(113, 3, 12, 'How do I betray the dragons?', 1438468373),
	(114, 3, 19, 'With who do I plot against the dragons?', 1500148551),
	(115, 4, 33, 'When can I revive some of the elementals?', 1506232079),
	(116, 1, 10, 'With who do I plot against all of the pidgeons?', 1455396164),
	(117, 2, 11, 'When can I revive the pidgeons?', 1391496943),
	(118, 2, 24, 'Where do I find some of the Holy Swords?', 1512808697),
	(119, 3, 26, 'Where do I revive all of the vampires?', 1435163226),
	(120, 3, 12, 'Where do I discover some of the dragons?', 1413811391),
	(121, 1, 10, 'With who do I find some of the Demon Lords?', 1514250748),
	(122, 5, 37, 'How many times must I obtain all of the fruit?', 1498153710),
	(123, 1, 17, 'How many times must I obtain some of the pidgeons?', 1515105142),
	(124, 2, 40, 'Where do I find some of the magic beans?', 1415465039),
	(125, 2, 28, 'When can I find all of the magic beans?', 1429109164),
	(126, 4, 41, 'How many times must I defeat all of the goblins?', 1469213662),
	(127, 2, 46, 'With who do I betray most of the insects?', 1530956959),
	(128, 1, 46, 'With who do I betray some of the elementals?', 1530162246),
	(129, 4, 5, 'Where do I plot against some of the imps?', 1402440262),
	(130, 2, 4, 'With who do I revive all of the magic beans?', 1454595983),
	(131, 2, 23, 'How many times must I betray most of the insects?', 1407426657),
	(132, 5, 7, 'How many times must I check most of the imps?', 1466344372),
	(133, 4, 49, 'How do I revive some of the zombies?', 1442288409),
	(134, 3, 3, 'When can I obtain the vampires?', 1408621752),
	(135, 2, 10, 'When can I betray some of the magic beans?', 1444144764),
	(136, 4, 49, 'When can I revive some of the demons?', 1530258964),
	(137, 4, 9, 'Where do I plot against all of the dragons?', 1427509476),
	(138, 2, 22, 'Where do I revive most of the Demon Lords?', 1525697896),
	(139, 4, 4, 'With who do I obtain most of the magic beans?', 1414613174),
	(140, 5, 42, 'How many times must I find the dragons?', 1454154324),
	(141, 1, 14, 'With who do I defeat the orcs?', 1484926575),
	(142, 5, 35, 'How do I find some of the Demon Lords?', 1434775391),
	(143, 2, 5, 'When can I check all of the Demon Lords?', 1431797507),
	(144, 5, 28, 'Where do I defeat some of the dragons?', 1459036910),
	(145, 2, 33, 'Where do I plot against the magic beans?', 1526854857),
	(146, 4, 35, 'When can I obtain most of the fruit?', 1445352126),
	(147, 1, 27, 'Where do I revive most of the imps?', 1466170712),
	(148, 4, 4, 'Where do I check the imps?', 1412784075),
	(149, 1, 11, 'How many times must I defeat the pidgeons?', 1483272416),
	(150, 5, 22, 'How do I plot against most of the orcs?', 1461002405),
	(151, 2, 16, 'When can I find the Holy Swords?', 1422892111),
	(152, 4, 40, 'Where do I betray all of the elementals?', 1451022793),
	(153, 1, 25, 'With who do I check some of the fruit?', 1503346302),
	(154, 4, 36, 'With who do I plot against some of the orcs?', 1398220682),
	(155, 4, 47, 'How many times must I discover most of the Holy Swords?', 1438191041),
	(156, 1, 50, 'Where do I betray most of the demons?', 1464855883),
	(157, 2, 23, 'How do I check the Holy Swords?', 1501543042),
	(158, 1, 28, 'When can I obtain the elementals?', 1412572666),
	(159, 4, 3, 'When can I defeat all of the pidgeons?', 1478377520),
	(160, 5, 49, 'How do I plot against some of the magic beans?', 1457830886),
	(161, 2, 33, 'With who do I revive most of the zombies?', 1446165502),
	(162, 5, 45, 'How do I discover most of the orcs?', 1443280503),
	(163, 4, 38, 'How do I revive some of the elementals?', 1478404090),
	(164, 2, 30, 'How do I discover most of the orcs?', 1388786308),
	(165, 1, 31, 'When can I obtain some of the magic beans?', 1391967161),
	(166, 5, 16, 'How many times must I check the Holy Swords?', 1492860322),
	(167, 4, 2, 'With who do I check the fruit?', 1459456665),
	(168, 1, 41, 'When can I defeat some of the orcs?', 1436172332),
	(169, 5, 36, 'How do I revive most of the dragons?', 1433504204),
	(170, 5, 10, 'How many times must I revive the pidgeons?', 1480320400),
	(171, 4, 23, 'Where do I find some of the insects?', 1404438533),
	(172, 5, 42, 'Where do I betray all of the orcs?', 1441103173),
	(173, 2, 46, 'When can I plot against some of the demons?', 1462324517),
	(174, 3, 47, 'How do I check some of the demons?', 1419676934),
	(175, 1, 34, 'When can I check all of the imps?', 1433464405);
/*!40000 ALTER TABLE `thread` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
