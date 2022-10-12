-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: huntercodexs
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `oauth2_application_client_operator`
--

# LOCK TABLES `oauth2_application_client_operator` WRITE;
DROP TABLE IF EXISTS `oauth2_application_client_operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oauth2_application_client_operator` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `accessCode` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `authorization` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `grantType` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `urlGetToken` varchar(255) DEFAULT NULL,
  `urlCheckToken` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth2_application_client_operator`
--

LOCK TABLES `oauth2_application_client_operator` WRITE;
/*!40000 ALTER TABLE `oauth2_application_client_operator` DISABLE KEYS */;
INSERT INTO `oauth2_application_client_operator` VALUES
(1,'1234567890','OAUTH2-SERVER-DEMO','Y2xpZW50X2lkOmNiZmNjNzRiLTA3Y2QtNGFiYi05MDZiLWFiZGRkOGZhMWJlYw==','OAUTH2DEMO_USER','1234567890','password','client_id','Y2JmY2M3NGItMDdjZC00YWJiLTkwNmItYWJkZGQ4ZmExYmVj','ROLE_USER','user@email.com',1,null,'http://localhost:33000/api/rest/oauth/v1/oauth/token','http://localhost:33000/api/rest/oauth/v1/oauth/check_token');
/*!40000 ALTER TABLE `oauth2_application_client_operator` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18 14:14:47
