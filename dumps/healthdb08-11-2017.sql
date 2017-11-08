-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: healthdb
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
  `target` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pb9w0k7mnu98amv0bfgq6lvf8` (`state_id`),
  CONSTRAINT `FK_pb9w0k7mnu98amv0bfgq6lvf8` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'','',1,'Take an immediate action',1),(2,'','',2,'Take an immediate action',1),(3,'','',3,'Take an immediate action',1),(4,'','',4,'Take an immediate action',1),(5,'\0','',5,'Examine the patient',1),(6,'\0','',5,'\"Point of care\" ultrasound',1),(7,'\0','',6,'Diagnose',1),(8,'\0','',5,'Examine the patient',2),(9,'\0','',5,'\"Point of care\" ultrasound',2),(10,'\0','',6,'Diagnose',2),(11,'\0','',5,'Examine the patient',3),(12,'\0','',5,'\"Point of care\" ultrasound',3),(13,'\0','',6,'Diagnose',3),(14,'\0','',5,'Examine the patient',4),(15,'\0','',5,'\"Point of care\" ultrasound',4),(16,'\0','',6,'Diagnose',4),(17,'','',4,'Take an immediate action',4),(18,'','',7,'Examine the patient',5),(19,'','',8,'Examine the patient',5),(20,'','',9,'Examine the patient',5),(21,'\0','',10,'\"Point of care\" ultrasound',5),(22,'\0','',6,'Diagnose',5),(23,'\0','',11,'Diagnose',7),(24,'','',12,'Diagnose',7),(25,'\0','',13,'Diagnose',7),(26,'\0','',14,'Diagnose',7),(27,'','',10,'\"Point of care\" ultrasound',8),(28,'\0','',6,'Diagnose',8),(29,'','',10,'\"Point of care\" ultrasound',9),(30,'\0','',6,'Diagnose',9),(31,'','',10,'\"Point of care\" ultrasound',10),(32,'\0','',6,'Diagnose',10),(33,'\0','',7,'Examine the patient',11),(34,'\0','',8,'Examine the patient',11),(35,'\0','',9,'Examine the patient',11),(36,'','',6,'Diagnose',11),(37,'','',15,'Treat',13),(38,'','',16,'Treat',13),(39,'\0','',17,'Treat',13);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalcase`
--

LOCK TABLES `medicalcase` WRITE;
/*!40000 ALTER TABLE `medicalcase` DISABLE KEYS */;
INSERT INTO `medicalcase` VALUES (1,'','Game over: you lost! :(','Respiratory Failure','',10,'Congratulations, you won!');
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
INSERT INTO `medicalcase_state` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18);
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
  `feedback` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `medicalCase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ey16dhxdgae7yku7anqbk19w9` (`medicalCase_id`),
  CONSTRAINT `FK_ey16dhxdgae7yku7anqbk19w9` FOREIGN KEY (`medicalCase_id`) REFERENCES `medicalcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Female patient, 54 years old, with shortness of breath in the last 5 hours','','Start',1),(2,'Provide an oxygen catheter','The patient is still with shortness of breath','State 2',1),(3,'Provide mechanical ventilation','Your supervisor entered in the room and told you that an oxygen mask is enough','State 3',1),(4,'Immediate assessment','Patient conscious; regular abdominal movements; breathing by mouth','State 4',1),(5,'Provide oxygen by a mask','The patient feels better','Oxygen mask',1),(6,'Wrong decision','Your patient does not have conditions to be examined','Fail',1),(7,'Diagnose','If your consider that you have all the elements to emit a final diagnosis, please select one of the options:','Diagnose',1),(8,'Physical Exam','No cough, sputum, chest pain or fever','Physical',1),(9,'History Exam','History of arterial hypertension, with irregular treatment','History',1),(10,'Take vital signs','BP= 224x122mmHg; HR= 108/min; RR= 30/min; O2Sat= 93%','Vital signs',1),(11,'Ultrasound','Pulmonary US shows diffuse B lines. Cardiac US is normal','Ultrasound',1),(12,'Pneumothorax','This is a wrong diagnosis','Pneumothorax',1),(13,'Cardiogenic pulmonary edema','This is the right diagnosis','Edema',1),(14,'Pulmonary hypertension','This is a wrong diagnosis','Hypertension',1),(15,'Left side heart failure','This is a wrong diagnosis','Heart failure',1),(16,'Provide non invasive ventilation','This is a right procedure','Treatment 1',1),(17,'Administrate bolus morphine and sodium nitruprusside in continuous infusion','This is a right procedure','Treatment 2',1),(18,'Needle or chest tube insertion','This is a wrong procedure','Treatment 3',1);
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
INSERT INTO `state_action` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(2,8),(2,9),(2,10),(3,11),(3,12),(3,13),(4,14),(4,15),(4,16),(4,17),(5,18),(5,19),(5,20),(5,21),(5,22),(7,23),(7,24),(7,25),(7,26),(8,27),(8,28),(9,29),(9,30),(10,31),(10,32),(11,33),(11,34),(11,35),(11,36),(13,37),(13,38),(13,39);
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

-- Dump completed on 2017-11-08 14:18:12
