--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `room_number` varchar(5) DEFAULT NULL,
  `max_number` int(100) DEFAULT NULL
);

INSERT INTO `rooms` VALUES ('115',58),('116',38),('117',53),('118',54),('201',140),('214',20),('215',45),('216',45),(24),('315',40),('316',35),('317',20),('318',42);'217',45),('218',40),('301',82),('302',18),('314',