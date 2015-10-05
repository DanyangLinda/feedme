-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: foodie.croourx5ijgx.us-west-2.rds.amazonaws.com    Database: foodie
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `complain`
--

LOCK TABLES `complain` WRITE;
/*!40000 ALTER TABLE `complain` DISABLE KEYS */;
/*!40000 ALTER TABLE `complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deliver`
--

LOCK TABLES `deliver` WRITE;
/*!40000 ALTER TABLE `deliver` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (29,2,'Drink','Port Bone Soup',NULL,'1c8183d9-40cb-4731-9b51-7d5791a1465b',NULL,350,NULL,NULL,NULL,NULL),(30,2,'Drinks','Deap Fried Green ',NULL,NULL,NULL,220,NULL,NULL,'',NULL),(31,2,'Others','Port and Ege',NULL,'37e40143-d803-4d6d-8d99-fc5e835ae333',NULL,3400,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `loginLog`
--

LOCK TABLES `loginLog` WRITE;
/*!40000 ALTER TABLE `loginLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `loginLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (2,'Golden Drum','63ad9a75-d266-4b1b-89f6-d6c5f54b31d0','str2','china','0435 446 799','str5@gmail.com','9:00-12:00',''),(3,'China Tea Club','6681efe5-c596-4b4e-bfac-77188aa25117','d1','china','002','email2','',''),(4,'Delhi 6 Authentic Indian Cuisine','9f2e715c-f64d-4be9-98c0-cc8fd4ad37e4','d2','india','003','email3','','');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shopAddress`
--

LOCK TABLES `shopAddress` WRITE;
/*!40000 ALTER TABLE `shopAddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shopCart`
--

LOCK TABLES `shopCart` WRITE;
/*!40000 ALTER TABLE `shopCart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopCart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (11,'Dan','Li',NULL,'4297f44b13955235245b2497399d7a93',NULL,NULL,NULL,'123123','1269@qq.com','Miss',NULL,NULL,'English');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `userPrefer`
--

LOCK TABLES `userPrefer` WRITE;
/*!40000 ALTER TABLE `userPrefer` DISABLE KEYS */;
/*!40000 ALTER TABLE `userPrefer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-05 11:40:23
