-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: healthdb
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correct` bit(1) NOT NULL,
  `proceed` bit(1) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `target_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pb9w0k7mnu98amv0bfgq6lvf8` (`state_id`),
  KEY `FK_8urs4khk0wwbffwco6wxf71cs` (`target_id`),
  CONSTRAINT `FK_8urs4khk0wwbffwco6wxf71cs` FOREIGN KEY (`target_id`) REFERENCES `state` (`id`),
  CONSTRAINT `FK_pb9w0k7mnu98amv0bfgq6lvf8` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'','','Take an immediate action',1,2),(2,'','','Take an immediate action',1,3),(3,'\0','','Take an immediate action',1,4),(4,'\0','','Take an immediate action',1,5),(5,'\0','','Point of care ultrassound',2,6),(6,'','','Examine the patient',2,7),(7,'\0','','Diagnose',2,8);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicalcase`
--

DROP TABLE IF EXISTS `medicalcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicalcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allow_negative_score` bit(1) NOT NULL,
  `lost_text` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `randomize_actions` bit(1) NOT NULL,
  `timeout` int(11) NOT NULL,
  `won_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalcase`
--

LOCK TABLES `medicalcase` WRITE;
/*!40000 ALTER TABLE `medicalcase` DISABLE KEYS */;
INSERT INTO `medicalcase` VALUES (1,'','Game over: you lost! :(','Respiratory Failure','',10,'Congratulations, you won!'),(2,'','Game over: you lost! :(','Teste','',10,'Congratulations, you won!');
/*!40000 ALTER TABLE `medicalcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicalcase_state`
--

DROP TABLE IF EXISTS `medicalcase_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicalcase_state` (
  `medicalcase_id` int(11) NOT NULL,
  `states_id` int(11) NOT NULL,
  UNIQUE KEY `UK_pw9vqjr863dqqs5o04m1thr4h` (`states_id`),
  KEY `FK_2h6n83djrnm3nf6ni4s92q4rg` (`medicalcase_id`),
  CONSTRAINT `FK_2h6n83djrnm3nf6ni4s92q4rg` FOREIGN KEY (`medicalcase_id`) REFERENCES `medicalcase` (`id`),
  CONSTRAINT `FK_pw9vqjr863dqqs5o04m1thr4h` FOREIGN KEY (`states_id`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalcase_state`
--

LOCK TABLES `medicalcase_state` WRITE;
/*!40000 ALTER TABLE `medicalcase_state` DISABLE KEYS */;
INSERT INTO `medicalcase_state` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8);
/*!40000 ALTER TABLE `medicalcase_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `medicalCase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ey16dhxdgae7yku7anqbk19w9` (`medicalCase_id`),
  CONSTRAINT `FK_ey16dhxdgae7yku7anqbk19w9` FOREIGN KEY (`medicalCase_id`) REFERENCES `medicalcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Female patient, 54 years old, with shortness of breath in the last 5 hours.','Start',1),(2,'Provide oxygen by a mask','State 2',1),(3,'Immediate assessment','State 3',1),(4,'Provide mechanical ventilation','State 4',1),(5,'Provide an oxygen catheter','State 5',1),(6,'Pulmonary US shows diffuse B lines. Cardiac US is normal','State 6',1),(7,'Physical exam','State 7',1),(8,'If you consider that you have all the elements to emit a final diagnosis, please select one of the options','State 8',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_action`
--

DROP TABLE IF EXISTS `state_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_action` (
  `state_id` int(11) NOT NULL,
  `actions_id` int(11) NOT NULL,
  UNIQUE KEY `UK_sue2g9yrmy1fqrku8wqf744r3` (`actions_id`),
  KEY `FK_9bqar80gxpljb1ompnoa0py79` (`state_id`),
  CONSTRAINT `FK_9bqar80gxpljb1ompnoa0py79` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`),
  CONSTRAINT `FK_sue2g9yrmy1fqrku8wqf744r3` FOREIGN KEY (`actions_id`) REFERENCES `action` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_action`
--

LOCK TABLES `state_action` WRITE;
/*!40000 ALTER TABLE `state_action` DISABLE KEYS */;
INSERT INTO `state_action` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7);
/*!40000 ALTER TABLE `state_action` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-05 22:30:59
