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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correctness` int(11) NOT NULL,
  `feedback_text` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eix9du6u2r4wxwu415wq8yb99` (`question_id`),
  CONSTRAINT `FK_eix9du6u2r4wxwu415wq8yb99` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,2,'Alright. Let us see what you can do','Take an immediate action',1),(2,0,'Your patient does not have conditions to be examined','Examine the patient',1),(3,0,'Your patient does not have conditions to be examined','Point of care ultrasound',1),(4,0,'Better saving the patient than diagnosing the disease now','Diagnose',1),(5,2,'The patient feels better','Provide oxygen by a mask',2),(6,1,'Patient conscious. Regular abdominal movements. Breathing by mouth','Immediate assessment',2),(7,0,'An oxygen mask is enough','Provide mechanical ventilation',2),(8,0,'The patient is still with shortness of breath','Provide an oxygen catheter',2),(9,0,'Again?','Take an immediate action',3),(10,2,'Alright. Let us see what you can do','Examine the patient',3),(11,0,'Your patient does not have conditions to be examined','Point of care ultrasound',3),(12,0,'Better saving the patient than diagnosing the disease now','Diagnose',3),(13,2,'No cough, sputum, chest pain or fever','Physical exam',4),(14,2,'History of arterial hypertension with irregular treatment','History exam',4),(15,2,'BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%','Vital signs exam',4),(16,0,'Really? Why did you think that?','Diabetes exam',4),(17,2,'No cough, sputum, chest pain or fever','Physical exam',5),(18,2,'History of arterial hypertension with irregular treatment','History exam',5),(19,2,'BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%','Vital signs exam',5),(20,0,'Really? Why did you think that?','Guthrie exam',5),(21,2,'No cough, sputum, chest pain or fever','Physical exam',6),(22,2,'History of arterial hypertension with irregular treatment','History exam',6),(23,2,'BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%','Vital signs exam',6),(24,0,'Really? Why did you think that?','Urine exam',6),(25,0,'Again?','Take an immediate action',7),(26,0,'Once more?','Examine the patient',7),(27,2,'Alright. Let us see what you can do','Point of care ultrasound',7),(28,0,'Better saving the patient than diagnosing the disease now','Diagnose',7),(29,2,'Pulmonary US shows diffuse B lines. Cardiac US is normal','Pulmonary + cardiac?',8),(30,0,'Nope. Do not do it with yourself','Cardiac + foot?',8),(31,0,'Nope. Do not do it with yourself','Head + foot?',8),(32,0,'Nope. Do not do it with yourself','Brain + hand?',8),(33,2,'Nice! Go ahead','Cardiogenic pulmonary edema',9),(34,0,'You are so wrong, child!','Left side heart failure',9),(35,0,'You are so wrong, child!','Pulmonary hipertension',9),(36,0,'You are so wrong, child!','Pneumothorax',9),(37,2,'Correct! That is my boy','Administrate bolus morphine and sodium nitruprusside in continuous infusion',10),(38,1,'Great! Anything else?','Provide non invasive ventilation',10),(39,0,'Jes! Please, be smarter!','Needle or chest tube insertion',10),(40,0,'Jes! Please, be smarter!','Let the time run and the patient die',10),(41,2,'asdasd','asdasd',11);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
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
  `conclusion_lost_text` varchar(255) DEFAULT NULL,
  `conclusion_won_text` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `randomize_answer_order` bit(1) NOT NULL,
  `randomize_question_order` bit(1) NOT NULL,
  `timeout` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalcase`
--

LOCK TABLES `medicalcase` WRITE;
/*!40000 ALTER TABLE `medicalcase` DISABLE KEYS */;
INSERT INTO `medicalcase` VALUES (1,'','GAME OVER: YOU LOST! :P','CONGRATULATIONS: YOU WON! :)','Respiratory Failure','','\0',10),(2,'','Game over: you lost! :(','Congratulations, you won!','Testezão','','\0',10);
/*!40000 ALTER TABLE `medicalcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicalcase_question`
--

DROP TABLE IF EXISTS `medicalcase_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicalcase_question` (
  `medicalcase_id` int(11) NOT NULL,
  `questions_id` int(11) NOT NULL,
  UNIQUE KEY `UK_rd86opbhcns9buh5atyk8c5ip` (`questions_id`),
  KEY `FK_d44xjv14gkfhayimdv0kbjgk8` (`medicalcase_id`),
  CONSTRAINT `FK_d44xjv14gkfhayimdv0kbjgk8` FOREIGN KEY (`medicalcase_id`) REFERENCES `medicalcase` (`id`),
  CONSTRAINT `FK_rd86opbhcns9buh5atyk8c5ip` FOREIGN KEY (`questions_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalcase_question`
--

LOCK TABLES `medicalcase_question` WRITE;
/*!40000 ALTER TABLE `medicalcase_question` DISABLE KEYS */;
INSERT INTO `medicalcase_question` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(2,11);
/*!40000 ALTER TABLE `medicalcase_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correct_feedback_text` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `incorrect_feedback_text` varchar(255) DEFAULT NULL,
  `right_score` int(11) NOT NULL,
  `semi_right_score` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `wrong_score` int(11) NOT NULL,
  `medicalCase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2c76ayxqu9sv2gog0t893dwn4` (`medicalCase_id`),
  CONSTRAINT `FK_2c76ayxqu9sv2gog0t893dwn4` FOREIGN KEY (`medicalCase_id`) REFERENCES `medicalcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'<h1>This is correct</h1> Correct feedback text here..','Female patient, 54 years old, with shortness of breath in the last 5 hours.','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(2,'<h1>This is correct</h1> Correct feedback text here..','Which action are you going to take?','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(3,'<h1>This is correct</h1> Correct feedback text here..','What now? *-*','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(4,'<h1>This is correct</h1> Correct feedback text here..','What kind of exam?','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(5,'<h1>This is correct</h1> Correct feedback text here..','Investigate more','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(6,'<h1>This is correct</h1> Correct feedback text here..','Investigate even more','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(7,'<h1>This is correct</h1> Correct feedback text here..','What now? *-*','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(8,'<h1>This is correct</h1> Correct feedback text here..','Which US combination do you want to see?','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(9,'<h1>This is correct</h1> Correct feedback text here..','Which one is the correct diagnosis?','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(10,'<h1>This is correct</h1> Correct feedback text here..','Which one(s) is/are the correct treatment(s)?','<h1>That is incorrect</h1> Incorrect feedback text here...',10,5,'','default',-5,1),(11,'This is correct','Blablabla','That is incorrect',10,5,'Start','default',-5,2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_answer`
--

DROP TABLE IF EXISTS `question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_answer` (
  `question_id` int(11) NOT NULL,
  `answers_id` int(11) NOT NULL,
  UNIQUE KEY `UK_6tuoorxfb87x2hhysoh7rlrgl` (`answers_id`),
  KEY `FK_1i8u28d6ugyv29hh66rsx2s99` (`question_id`),
  CONSTRAINT `FK_1i8u28d6ugyv29hh66rsx2s99` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FK_6tuoorxfb87x2hhysoh7rlrgl` FOREIGN KEY (`answers_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_answer`
--

LOCK TABLES `question_answer` WRITE;
/*!40000 ALTER TABLE `question_answer` DISABLE KEYS */;
INSERT INTO `question_answer` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7),(2,8),(3,9),(3,10),(3,11),(3,12),(4,13),(4,14),(4,15),(4,16),(5,17),(5,18),(5,19),(5,20),(6,21),(6,22),(6,23),(6,24),(7,25),(7,26),(7,27),(7,28),(8,29),(8,30),(8,31),(8,32),(9,33),(9,34),(9,35),(9,36),(10,37),(10,38),(10,39),(10,40),(11,41);
/*!40000 ALTER TABLE `question_answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-31 21:40:16
