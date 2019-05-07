CREATE DATABASE  IF NOT EXISTS `vendingmachine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `vendingmachine`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vendingmachine
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coffeeproduct`
--

DROP TABLE IF EXISTS `coffeeproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coffeeproduct` (
  `id` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `ingredient1` int(11) DEFAULT NULL,
  `ingredient2` int(11) DEFAULT NULL,
  `ingredient3` int(11) DEFAULT NULL,
  `ingredient1amount` int(11) DEFAULT NULL,
  `ingredient2amount` int(11) DEFAULT NULL,
  `ingredient3amount` int(11) DEFAULT NULL,
  `wateramountingredient1` int(11) DEFAULT NULL,
  `wateramountingredient2` int(11) DEFAULT NULL,
  `wateramountingredient3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coffeeproduct`
--

LOCK TABLES `coffeeproduct` WRITE;
/*!40000 ALTER TABLE `coffeeproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `coffeeproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error`
--

DROP TABLE IF EXISTS `error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `error` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `solved` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `error`
--

LOCK TABLES `error` WRITE;
/*!40000 ALTER TABLE `error` DISABLE KEYS */;
INSERT INTO `error` VALUES (1,'MOTOR_ERROR','2019-05-06 21:02:27',1);
/*!40000 ALTER TABLE `error` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productid` varchar(10) NOT NULL,
  `price` double NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,'A2',40,'2019-05-06 20:54:59');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snackproduct`
--

DROP TABLE IF EXISTS `snackproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `snackproduct` (
  `id` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `availablequantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productId_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snackproduct`
--

LOCK TABLES `snackproduct` WRITE;
/*!40000 ALTER TABLE `snackproduct` DISABLE KEYS */;
INSERT INTO `snackproduct` VALUES ('A1','twix',45,15),('A2','m&ms',40,0),('A3','Go-n-go',40,13),('A4','Coca-Cola 0.5',40,10),('A5','Coca-Cola 0.33',40,10),('A6','snickers',40,10),('A7','mars',40,10),('A8','Water',40,10),('B1','Water',40,10),('B2','Sprite',40,10),('B3','Red bull',100,10),('B4','Nuts',40,10),('B5','Lays',40,10),('B6','Banana',40,10),('B7','Apple',40,10),('B8','Pringles',39,10);
/*!40000 ALTER TABLE `snackproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperaturesettings`
--

DROP TABLE IF EXISTS `temperaturesettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temperaturesettings` (
  `type` varchar(45) NOT NULL,
  `mintemp` int(11) NOT NULL,
  `maxtemp` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperaturesettings`
--

LOCK TABLES `temperaturesettings` WRITE;
/*!40000 ALTER TABLE `temperaturesettings` DISABLE KEYS */;
INSERT INTO `temperaturesettings` VALUES ('FREEZER',2,6),('WATER',93,94);
/*!40000 ALTER TABLE `temperaturesettings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-07 20:37:56
