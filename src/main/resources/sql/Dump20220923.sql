CREATE DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_id` int NOT NULL AUTO_INCREMENT,
  `playlist_name` varchar(45) DEFAULT NULL,
  `song_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`playlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'jaswanth','5,1,2,4'),(2,'tony','2'),(3,'win','1,2,4,5'),(14,'jin','1,2,4,5'),(15,'love','1,2,4,7');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_id` int NOT NULL,
  `song_name` varchar(50) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `artist` varchar(45) DEFAULT NULL,
  `album` varchar(45) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `song_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'akatsuki','bass','yasuharu','shinjuuka','02:02','src/main/resources/songs/akatsuki.wav'),(2,'faded','dance','alan walker','different world','03:31','src/main/resources/songs/faded.wav'),(3,'alone','dance','alan walker','different world','02:40','src/main/resources/songs/faded.wav'),(4,'happier','pop','marshmellow','fortnite set','03:38','src/main/resources/songs/happier.wav'),(5,'baby','pop','justin bieber','my world','03:38','src/main/resources/songs/baby.wav'),(6,'despacito','reggaeton','louis fonsi','vida','04:41','src/main/resources/songs/despacito.wav'),(7,'intensions','r&b','justin bieber','haileys fav','03:32','src/main/resources/songs/intensions.wav'),(8,'shapeofyou','pop','ed sheeran','divide','03:55','src/main/resources/songs/shapeofyou.wav'),(9,'finesse','electronic','bruno mars','magic24k','03:37','src/main/resources/songs/finesse.wav'),(10,'godsplan','hip hop','drake','scorpion','03:19','src/main/resources/songs/godsplan.wav'),(11,'shakeitup','pop','salena gomez','shake it up','02:54','src/main/resources/songs/shakeitup.wav'),(12,'titanium','pop','david guetta','nothing but the  beat','04:03','src/main/resources/songs/titanium.wav'),(13,'unstoppable','pop','sia','this is acting','03:37','src/main/resources/songs/unstoppable.wav'),(14,'we dont talk anymore','pop','charlie puth','nine track mind','03:37','src/main/resources/songs/wedonttalkanymore.wav'),(15,'wake me up','house music','avicii','true','04:09','src/main/resources/songs/wakemeup.wav');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-23  8:56:57
