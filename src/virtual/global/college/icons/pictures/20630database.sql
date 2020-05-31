-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: college1
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `attendance_student`
--

DROP TABLE IF EXISTS `attendance_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance_student` (
  `id_student` int NOT NULL,
  `Date` varchar(50) DEFAULT NULL,
  `first` varchar(10) DEFAULT NULL,
  `second` varchar(10) DEFAULT NULL,
  `attendece_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`attendece_id`),
  KEY `student_id_idx` (`id_student`),
  CONSTRAINT `fkid_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_student`
--

LOCK TABLES `attendance_student` WRITE;
/*!40000 ALTER TABLE `attendance_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id_course` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_course`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Computer Science');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee` (
  `id_student` int DEFAULT NULL,
  `course` int DEFAULT NULL,
  `subject` int DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  `fee_paid` varchar(15) DEFAULT NULL,
  `id_fee` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_fee`),
  KEY `f_k_id_student_idx` (`id_student`),
  KEY `fk_id_course_idx` (`course`),
  KEY `fk-id_subject_idx` (`subject`),
  CONSTRAINT `f_k_id_couse` FOREIGN KEY (`course`) REFERENCES `course` (`id_course`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_k_id_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_k_id_subject` FOREIGN KEY (`subject`) REFERENCES `subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `id_grade` int NOT NULL,
  `id_student` int DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  `grade` float DEFAULT NULL,
  PRIMARY KEY (`id_grade`),
  KEY `id_student_idx` (`id_student`),
  KEY `id_subject_idx` (`id_subject`),
  CONSTRAINT `id_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`),
  CONSTRAINT `id_subject` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,4,1,12.6);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `id_login` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `id_login_UNIQUE` (`id_login`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin',1),('admin','admin',2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `name` varchar(20) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `id_student` int NOT NULL AUTO_INCREMENT,
  `id_course` int DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  `id_login` int DEFAULT NULL,
  PRIMARY KEY (`id_student`),
  UNIQUE KEY `id_student_UNIQUE` (`id_student`),
  KEY `fk_course_idx` (`id_course`),
  KEY `fk_login_idx` (`id_login`),
  KEY `fk_subject_idx` (`id_subject`),
  CONSTRAINT `course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fsubject` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('dani','1987-09-09','dasfas','g45364','sfgsfgak',4,1,1,1),('karol','1986-09-09','gfrkj','47646889','karol@vgc.com',5,1,1,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id_subject` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_subject`),
  UNIQUE KEY `id_subject_UNIQUE` (`id_subject`),
  CONSTRAINT `Id_subject_sub` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Front-End'),(2,'Networking'),(3,'Mobile Aplicattions'),(4,NULL);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `name` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `id_teacher` int NOT NULL AUTO_INCREMENT,
  `id_course` int DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  `id_login` int DEFAULT NULL,
  PRIMARY KEY (`id_teacher`),
  UNIQUE KEY `id_teacher_UNIQUE` (`id_teacher`),
  KEY `fk_login_idx` (`id_login`),
  KEY `fk_subject_idx` (`id_subject`),
  KEY `fk_course_idx` (`id_course`),
  CONSTRAINT `fk_course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_login` FOREIGN KEY (`id_login`) REFERENCES `login` (`id_login`),
  CONSTRAINT `fk_subject` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-31 13:43:50
