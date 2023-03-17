CREATE DATABASE  IF NOT EXISTS `radnikba` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `radnikba`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: radnikba
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `job_description` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Građevinar','Poslovi vezani za građenje'),(9,'Vrtlar','Uređivanje vrtova i prirode'),(25,'Električar','Rad sa električnim instalacijama'),(29,'Vodoinstalater','Popravak vodovodnih instalacija');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worker_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `review_grade` int DEFAULT NULL,
  `review_comment` varchar(2048) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `posted` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (7,37,6,4,'sarajevo','2022-07-21 15:54:01'),(8,37,6,5,'hahahahha','2022-07-21 15:54:01'),(28,37,1,5,'top','2022-07-21 15:54:01'),(29,37,4,5,'betonn','2022-07-21 15:54:01'),(31,38,6,5,'Zna posao','2022-07-21 15:54:01'),(32,37,4,4,'hhhh','2022-07-21 15:58:57'),(36,37,4,4,'bzvz','2022-07-21 16:06:23');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_surname` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(256) COLLATE utf8_bin DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'f271d150278f61fe464bb7949ec8fd5c','Ervin','Vladic','Sarajevo','ervinvladic@hotmail.com','USER'),(4,'81dc9bdb52d04dc20036dbd8313ed055','Harun','Kunovac','Tuzla','harunkunovac@gmail.com','USER'),(6,'b59c67bf196a4758191e42f76670ceba','Admin','','Sarajevo','harun.kunovac@stu.ibu.edu.ba','ADMIN'),(15,'81dc9bdb52d04dc20036dbd8313ed055','hara','kule','Sarajevo','hara@kule.com','USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worker_job_id` int DEFAULT NULL,
  `worker_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `worker_city` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `worker_phone_number` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `worker_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `worker_email` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `worker_job_idx` (`worker_job_id`),
  CONSTRAINT `worker_job` FOREIGN KEY (`worker_job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (37,9,'Harun','Sarajevo','0603442756','bzvz','harun.kunovac@gmail.com'),(38,9,'Kara','Mostar','062343213','Adresa 123','brick.layer@gmail.com');
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-23 16:29:17
