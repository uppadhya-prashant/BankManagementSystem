-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bms
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `accclosure`
--

DROP TABLE IF EXISTS `accclosure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accclosure` (
  `accclosereqid` varchar(10) NOT NULL,
  `accnum` varchar(10) DEFAULT NULL,
  `totalbal` double DEFAULT NULL,
  `pendingdues` double DEFAULT NULL,
  `finalamt` double DEFAULT NULL,
  `reqdate` date DEFAULT NULL,
  `reason` varchar(200) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'PENDING',
  `apprdate` date DEFAULT NULL,
  PRIMARY KEY (`accclosereqid`),
  UNIQUE KEY `unk1` (`accnum`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accclosure`
--

LOCK TABLES `accclosure` WRITE;
/*!40000 ALTER TABLE `accclosure` DISABLE KEYS */;
INSERT INTO `accclosure` VALUES ('106025184','261413554',369600,369600,0,'2022-11-15','','USER_CANCL_REQ','2022-11-15'),('213684901','39237768',57116,48000,9116,'2022-11-15','PLS','USER_CANCL_REQ','2022-11-15'),('338517844','281754829',11424,2400,9024,'2022-11-15','LOL','APPROVED','2022-11-15'),('397729517','107966489',48000,48000,0,'2022-11-14','','APPROVED','2022-11-14'),('464937668','107966489',48000,48000,0,'2022-11-14','testing','USER_CANCL_REQ','2022-11-14'),('523270273','488521480',12769,1200,11569,'2022-11-14','THANKS','USER_CANCL_REQ','2022-11-14'),('652536035','488521480',12769,1200,11569,'2022-11-14','PLS','APPROVED','2022-11-14'),('720233072','227916089',517720,517320,400,'2022-11-14','pls','APPROVED','2022-11-14'),('725542677','39237768',57116,48000,9116,'2022-11-15','pls close','APPROVED','2022-11-15'),('79297109','747833094',6054,3600,2454,'2022-11-14','CLOSE','APPROVED','2022-11-14'),('849405278','747833094',6054,3600,2454,'2022-11-14','no reason','USER_CANCL_REQ','2022-11-14'),('883460761','734745215',1669.8,214,1455.8,'2022-11-14','','APPROVED','2022-11-14'),('894168864','700960728',6815.200000000001,120,6695.200000000001,'2022-11-15','hi we are checking','USER_CANCL_REQ','2022-11-15'),('89734663','734745215',1669.8,214,1455.8,'2022-11-14','pls','USER_CANCL_REQ','2022-11-14');
/*!40000 ALTER TABLE `accclosure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `accnumbalancelinkview`
--

DROP TABLE IF EXISTS `accnumbalancelinkview`;
/*!50001 DROP VIEW IF EXISTS `accnumbalancelinkview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `accnumbalancelinkview` AS SELECT 
 1 AS `accnum`,
 1 AS `name`,
 1 AS `bal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `accwithnameview`
--

DROP TABLE IF EXISTS `accwithnameview`;
/*!50001 DROP VIEW IF EXISTS `accwithnameview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `accwithnameview` AS SELECT 
 1 AS `accnum`,
 1 AS `name`,
 1 AS `bal`,
 1 AS `status`,
 1 AS `opendate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `activeaccunpaidloandues`
--

DROP TABLE IF EXISTS `activeaccunpaidloandues`;
/*!50001 DROP VIEW IF EXISTS `activeaccunpaidloandues`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `activeaccunpaidloandues` AS SELECT 
 1 AS `accnum`,
 1 AS `totalunpaidloan`,
 1 AS `noofunpaidloans`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `user_id` int NOT NULL,
  `pass` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (123,'bank'),(456,'pratyush');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `balance` (
  `accNum` int NOT NULL,
  `bal` double DEFAULT NULL,
  PRIMARY KEY (`accNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES (14680650,10291),(19878772,7158),(39237768,-1),(107966489,-1),(143727254,10007.3),(171261237,10050),(227916089,-1),(261413554,280000),(281754829,-1),(324804399,13562.5),(488521480,-1),(527880378,63637.5),(549939802,100),(626881857,10802),(700960728,4031.2000000000007),(712938379,10000),(734745215,-1),(747833094,-1),(835112867,10000),(838717474,1210.5),(848652407,68531.5),(893716579,447907.12);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankstats`
--

DROP TABLE IF EXISTS `bankstats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankstats` (
  `status` varchar(15) DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankstats`
--

LOCK TABLES `bankstats` WRITE;
/*!40000 ALTER TABLE `bankstats` DISABLE KEYS */;
INSERT INTO `bankstats` VALUES ('active');
/*!40000 ALTER TABLE `bankstats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fd`
--

DROP TABLE IF EXISTS `fd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fd` (
  `fdid` varchar(10) NOT NULL,
  `accnum` varchar(20) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `breakDate` date DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `finalamt` double DEFAULT NULL,
  `status` varchar(20) DEFAULT 'active',
  PRIMARY KEY (`fdid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fd`
--

LOCK TABLES `fd` WRITE;
/*!40000 ALTER TABLE `fd` DISABLE KEYS */;
INSERT INTO `fd` VALUES ('124066552','893716579','2022-11-13','2022-11-13',300,336,'CLOSED'),('278176219','700960728','2022-11-15',NULL,3000,3480,'active'),('295902275','747833094','2022-11-14',NULL,3000,4200,'active'),('324036123','488521480','2022-11-14','2022-11-14',900,1008,'CLOSED'),('328953028','893716579','2022-11-13','2022-11-13',540,846.72,'CLOSED'),('329588740','227916089','2022-11-13','2022-11-14',1000,1120,'CLOSED'),('333135977','143727254','2022-11-13','2022-11-13',100,92.8,'CLOSED'),('342768967','893716579','2022-11-13','2022-11-13',100,86.4,'CLOSED'),('358869998','893716579','2022-11-13','2022-11-13',12000,13440,'CLOSED'),('381032484','281754829','2022-11-14','2022-11-14',8000,11520,'CLOSED'),('386489554','893716579','2022-11-13','2022-11-13',1200,1344,'CLOSED'),('462165654','893716579','2022-11-13','2022-11-13',5000,5600,'CLOSED'),('515423011','700960728','2022-11-15',NULL,3000,3480,'active'),('539338602','734745215','2022-11-13',NULL,100,116,'active'),('568929841','700960728','2022-11-15','2022-11-15',200,211.2,'CLOSED'),('592390978','281754829','2022-11-14',NULL,6000,6480,'active'),('612968704','747833094','2022-11-14','2022-11-14',2000,1984,'CLOSED'),('634241941','107966489','2022-11-14','2022-11-14',20000,22400,'CLOSED'),('697984231','227916089','2022-11-13','2022-11-13',100,92.8,'CLOSED'),('712712371','261413554','2022-11-15','2022-11-15',30000,33600,'CLOSED'),('7203946','734745215','2022-11-13','2022-11-13',600,556.8,'CLOSED'),('720565734','39237768','2022-11-15','2022-11-15',6000,5568,'CLOSED'),('735029520','39237768','2022-11-15',NULL,7000,7560,'active'),('750706887','893716579','2022-11-13','2022-11-13',13000,18720,'CLOSED'),('760796221','893716579','2022-11-13',NULL,10000,14000,'active'),('860923207','107966489','2022-11-14',NULL,20000,23200,'active'),('879619381','261413554','2022-11-15',NULL,80000,112000,'active'),('94704698','838717474','2022-11-13',NULL,300,420,'active');
/*!40000 ALTER TABLE `fd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `freeze`
--

DROP TABLE IF EXISTS `freeze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `freeze` (
  `accnum` varchar(10) DEFAULT NULL,
  `freezedate` date DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `unfreezedate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `freeze`
--

LOCK TABLES `freeze` WRITE;
/*!40000 ALTER TABLE `freeze` DISABLE KEYS */;
INSERT INTO `freeze` VALUES ('14680650','2022-11-15','too much loan',NULL),('14680650','2022-11-15','lol',NULL),('527880378','2022-11-15','suspicious',NULL),('626881857','2022-11-15','lol',NULL),('848652407','2022-11-15','null',NULL);
/*!40000 ALTER TABLE `freeze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `loanbalrelation`
--

DROP TABLE IF EXISTS `loanbalrelation`;
/*!50001 DROP VIEW IF EXISTS `loanbalrelation`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `loanbalrelation` AS SELECT 
 1 AS `reqloanid`,
 1 AS `dur`,
 1 AS `reason`,
 1 AS `reqdate`,
 1 AS `amt`,
 1 AS `bal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `loanrequests`
--

DROP TABLE IF EXISTS `loanrequests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loanrequests` (
  `reqLoanID` int NOT NULL,
  `accNum` int DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `dur` int DEFAULT NULL,
  `reason` varchar(30) DEFAULT NULL,
  `persStatus` varchar(20) DEFAULT (_cp850'UNPAID'),
  `apprStatus` varchar(20) DEFAULT (_cp850'PENDING'),
  `finalamt` double DEFAULT NULL,
  `reqdate` date DEFAULT NULL,
  `apprdate` date DEFAULT NULL,
  `type` varchar(20) DEFAULT (_cp850'APPR_LOAN'),
  PRIMARY KEY (`reqLoanID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanrequests`
--

LOCK TABLES `loanrequests` WRITE;
/*!40000 ALTER TABLE `loanrequests` DISABLE KEYS */;
INSERT INTO `loanrequests` VALUES (22277842,281754829,10000,5,'MEDICAL','PAID','INST_APPROVED',12000,'2022-11-14','2022-11-14','INST_LOAN'),(24870804,107966489,10000,2,'MEDICAL','PAID','INST_APPROVED',12000,'2022-11-14','2022-11-14','INST_LOAN'),(30123038,734745215,300,2,'Prats--test','PAID_ON_CLOSE','REJECTED',321,'2022-11-13','2022-11-13','APPR_LOAN'),(51942726,893716579,150000,10,'lol','UNPAID','APPROVED',160500,'2022-11-12','2022-11-12','APPR_LOAN'),(63706949,893716579,1000,6,'lol','UNPAID','APPROVED',1070,'2022-11-12','2022-11-12','APPR_LOAN'),(69462037,747833094,3000,3,'MEDICAL','PAID','INST_APPROVED',3600,'2022-11-14','2022-11-14','INST_LOAN'),(70019089,227916089,10000,5,'pls','PAID','INST_APPROVED',12000,'2022-11-13','2022-11-13','INST_LOAN'),(74484658,893716579,1,1,'1','UNPAID','APPROVED',1.07,'2022-11-13','2022-11-13','APPR_LOAN'),(83393833,893716579,786,10,'dsd','UNPAID','REJECTED',841.02,'2022-11-12','2022-11-12','APPR_LOAN'),(88150281,324804399,199,9,'lol1','UNPAID','REJECTED',212.93,'2022-11-13','2022-11-13','APPR_LOAN'),(106028311,893716579,30000,5,'need','UNPAID','INST_APPROVED',36000,'2022-11-13','2022-11-13','INST_LOAN'),(106362670,281754829,10000,5,'MEDICAL','PAID_ON_CLOSE','APPROVED',10700,'2022-11-14','2022-11-15','APPR_LOAN'),(128920917,488521480,1000,4,'FD','PAID_ON_CLOSE','INST_APPROVED',1200,'2022-11-14','2022-11-14','INST_LOAN'),(130991515,527880378,19000,15,'Pratyush','UNPAID','APPROVED',20330,'2022-11-12','2022-11-12','APPR_LOAN'),(132759521,838717474,100,5,'prats_final','UNPAID','APPROVED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(133917822,893716579,100,10,'lol','UNPAID','REJECTED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(136193013,39237768,40000,5,'pls','PAID_ON_CLOSE','INST_APPROVED',48000,'2022-11-15','2022-11-15','INST_LOAN'),(148566289,14680650,7982,1,'inst_test','UNPAID','INST_APPROVED',9578.4,'2022-11-13','2022-11-13','INST_LOAN'),(148834092,227916089,2000,5,'pls','PAID','INST_APPROVED',2400,'2022-11-13','2022-11-13','INST_LOAN'),(156815430,261413554,8000,1,'MEDICAL','UNPAID','INST_APPROVED',9600,'2022-11-15','2022-11-15','INST_LOAN'),(174778510,893716579,1,1,'1','UNPAID','REJECTED',1.07,'2022-11-13','2022-11-13','APPR_LOAN'),(190199987,747833094,10000,4,'EDUCATION','PAID_ON_CLOSE','APPROVED',10700,'2022-11-14','2022-11-14','APPR_LOAN'),(193525658,527880378,100,5,'4','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(199274594,893716579,11000,5,'pls','UNPAID','INST_APPROVED',13200,'2022-11-13','2022-11-13','INST_LOAN'),(204692484,893716579,1,1,'1','UNPAID','INST_APPROVED',1.2,'2022-11-13','2022-11-13','INST_LOAN'),(232428492,893716579,100,5,'gt','UNPAID','APPROVED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(233641554,734745215,1000,2,'prats--test','PAID','INST_APPROVED',1200,'2022-11-13','2022-11-13','INST_LOAN'),(240254257,893716579,100,5,'PLS','UNPAID','APPROVED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(282409777,324804399,1900,5,'lol','UNPAID','APPROVED',2033,'2022-11-13','2022-11-13','APPR_LOAN'),(284198837,143727254,100,4,'pls','UNPAID','REJECTED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(294392320,39237768,3000,2,'health','PAID','INST_APPROVED',3600,'2022-11-15','2022-11-15','INST_LOAN'),(300412223,838717474,100,5,'Instant_chck','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(308044048,227916089,100,2,'PLO','PAID_ON_CLOSE','INST_APPROVED',120,'2022-11-14','2022-11-14','INST_LOAN'),(308084155,893716579,10000,5,'lol','UNPAID','INST_APPROVED',12000,'2022-11-13','2022-11-13','INST_LOAN'),(325430895,14680650,120,3,'prats/pal-test','UNPAID','APPROVED',128.4,'2022-11-13','2022-11-13','APPR_LOAN'),(332548267,227916089,1000,2,'PLO','PAID_ON_CLOSE','INST_APPROVED',1200,'2022-11-14','2022-11-14','INST_LOAN'),(341217811,734745215,100,2,'pls','PAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(346870358,527880378,1,1,'today','PAID','REJECTED',1.07,'2022-11-12','2022-11-12','APPR_LOAN'),(353953442,893716579,100,1,'PLS','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(355636176,107966489,20000,1,'ELECTRONICS','PAID_ON_CLOSE','APPROVED',21400,'2022-11-14','2022-11-14','APPR_LOAN'),(366378335,488521480,500,10,'please','PAID_ON_CLOSE','APPROVED',535,'2022-11-14','2022-11-14','APPR_LOAN'),(369669493,893716579,100,2,'pls','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(383488012,893716579,100,1,'check','UNPAID','REJECTED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(392825246,893716579,100,1,'lol','UNPAID','APPROVED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(399529062,39237768,300,2,'FINAL TEST','PAID_ON_CLOSE','APPROVED',321,'2022-11-15','2022-11-15','APPR_LOAN'),(404313429,227916089,100,4,'pls','PAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(420702579,14680650,5000,1,'SEX','UNPAID','APPROVED',5350,'2022-11-12','2022-11-12','APPR_LOAN'),(426565386,893716579,100,2,'plspls','UNPAID','APPROVED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(439008664,893716579,120,19,'lmaof','UNPAID','REJECTED',128.4,'2022-11-12','2022-11-12','APPR_LOAN'),(465445525,893716579,1,1,'1','UNPAID','REJECTED',1.07,'2022-11-13','2022-11-13','APPR_LOAN'),(476102554,848652407,123,10,'Priyanshu','UNPAID','APPROVED',131.61,'2022-11-12','2022-11-12','APPR_LOAN'),(476634978,14680650,1000,1,'education','UNPAID','REJECTED',1070,'2022-11-12','2022-11-12','APPR_LOAN'),(486623357,893716579,1000,4,'lolplease','UNPAID','APPROVED',1070,'2022-11-12','2022-11-12','APPR_LOAN'),(502271232,893716579,9876,10,'test','UNPAID','REJECTED',10567.32,'2022-11-12','2022-11-12','APPR_LOAN'),(513073233,734745215,200,2,'pls','PAID_ON_CLOSE','APPROVED',214,'2022-11-13','2022-11-13','APPR_LOAN'),(516697892,848652407,100,9,'Priyanshu','UNPAID','APPROVED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(518444630,700960728,100,3,'pls','UNPAID','INST_APPROVED',120,'2022-11-15','2022-11-15','INST_LOAN'),(531516232,848652407,20000,15000,'Priyanshu','UNPAID','APPROVED',21400,'2022-11-12','2022-11-12','APPR_LOAN'),(533614695,123456789,100,5,'test','UNPAID','PENDING',107,'2022-11-12',NULL,'APPR_LOAN'),(541161050,747833094,3000,1,'GROCERY','PAID_ON_CLOSE','INST_APPROVED',3600,'2022-11-14','2022-11-14','INST_LOAN'),(549089752,261413554,8600,5,'home','UNPAID','PENDING',9202,'2022-11-15',NULL,'APPR_LOAN'),(561759500,734745215,200,5,'prats-test','PAID','INST_APPROVED',240,'2022-11-13','2022-11-13','INST_LOAN'),(563045809,227916089,30000,5,'pls','PAID_ON_CLOSE','INST_APPROVED',36000,'2022-11-13','2022-11-13','INST_LOAN'),(565602218,261413554,300000,7,'MEDICAL','UNPAID','INST_APPROVED',360000,'2022-11-15','2022-11-15','INST_LOAN'),(573085367,488521480,1000,1,'PRATYUSH','PAID','INST_APPROVED',1200,'2022-11-14','2022-11-14','INST_LOAN'),(576579645,171261237,100,6,'lol','UNPAID','REJECTED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(590470734,848652407,5000,10,'Priyanshu','UNPAID','APPROVED',5350,'2022-11-12','2022-11-12','APPR_LOAN'),(600600294,848652407,50000,10,'Priyanshu','UNPAID','APPROVED',53500,'2022-11-12','2022-11-12','APPR_LOAN'),(602059469,893716579,1,1,'1','UNPAID','INST_APPROVED',1.2,'2022-11-13','2022-11-13','INST_LOAN'),(629164186,893716579,1,1,'1','UNPAID','APPROVED',1.07,'2022-11-13','2022-11-13','APPR_LOAN'),(632852795,838717474,140,2,'prats_final','UNPAID','REJECTED',149.8,'2022-11-13','2022-11-13','APPR_LOAN'),(639159710,893716579,900,2,'pls','UNPAID','INST_APPROVED',1080,'2022-11-13','2022-11-13','INST_LOAN'),(654920698,227916089,400000,4,'green leaf','PAID_ON_CLOSE','INST_APPROVED',480000,'2022-11-13','2022-11-13','INST_LOAN'),(667966334,893716579,100,1,'1','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(679046928,14680650,120,8,'pal1','UNPAID','APPROVED',128.4,'2022-11-13','2022-11-13','APPR_LOAN'),(698127553,893716579,100,5,'lol','UNPAID','INST_APPROVED',120,'2022-11-13','2022-11-13','INST_LOAN'),(705590444,527880378,1000,10,'please','UNPAID','APPROVED',1070,'2022-11-12','2022-11-12','APPR_LOAN'),(712175605,227916089,100,5,'pls','PAID','APPROVED',107,'2022-11-13','2022-11-13','APPR_LOAN'),(712378995,527880378,150,1,'lmaoplease','PAID','REJECTED',160.5,'2022-11-12','2022-11-12','APPR_LOAN'),(715666962,281754829,300,2,'pls','PAID_ON_CLOSE','APPROVED',321,'2022-11-15','2022-11-15','APPR_LOAN'),(743866479,747833094,400,5,'EDU','PAID_ON_CLOSE','REJECTED',428,'2022-11-14','2022-11-14','APPR_LOAN'),(767007386,893716579,100,1,'lmfao','UNPAID','REJECTED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(798783650,626881857,8990,7,'hsjhd','UNPAID','INST_APPROVED',10788,'2022-11-14','2022-11-14','INST_LOAN'),(803507112,700960728,300,3,'pls','UNPAID','REJECTED',321,'2022-11-15','2022-11-15','APPR_LOAN'),(805443069,893716579,100,5,'lol','UNPAID','APPROVED',107,'2022-11-12','2022-11-12','APPR_LOAN'),(811880099,107966489,40000,3,'test','PAID_ON_CLOSE','INST_APPROVED',48000,'2022-11-14','2022-11-14','INST_LOAN'),(812761368,143727254,120,5,'check','UNPAID','INST_APPROVED',144,'2022-11-13','2022-11-13','INST_LOAN'),(823243259,893716579,3000,3,'lol','UNPAID','INST_APPROVED',3600,'2022-11-13','2022-11-13','INST_LOAN'),(834833913,281754829,2000,3,'pls','PAID_ON_CLOSE','INST_APPROVED',2400,'2022-11-15','2022-11-15','INST_LOAN'),(858877005,893716579,15000,5,'test','PAID','REJECTED',16050,'2022-11-12','2022-11-12','APPR_LOAN'),(863225517,527880378,1,1,'today','PAID','REJECTED',1.07,'2022-11-12','2022-11-12','APPR_LOAN'),(897649276,626881857,7890,4,'home','UNPAID','REJECTED',8442.3,'2022-11-14','2022-11-14','APPR_LOAN');
/*!40000 ALTER TABLE `loanrequests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `readstatus` varchar(10) DEFAULT (_cp850'NOT READ'),
  `reciever` varchar(30) DEFAULT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `message` varchar(300) DEFAULT NULL,
  `date` date DEFAULT (curdate()),
  `messageid` varchar(30) NOT NULL,
  PRIMARY KEY (`messageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES ('READ','488521480','BANK FIX_DEP DEPT','Your FD with id: 324036123 is now CLOSED as per your request','2022-11-14','105266368'),('READ','527880378','BANK LOAN DEPT','Loan Request id: 712378995 REJECTED due to foul words','2022-11-12','107226700'),('READ','227916089','734745215','hi','2022-11-13','121814024'),('NOT READ','863225517','893716579','hi','2022-11-13','130909184'),('READ','BANK','838717474','hi bank--prats test','2022-11-13','132050469'),('READ','893716579','143727254','Hi harsha!','2022-11-13','143587960'),('NOT READ','107966489','BANK LOAN DEPT','Your Loan Request with id: 355636176 is APPROVED','2022-11-14','143875937'),('NOT READ','893716579','BANK LOAN DEPT','Your Loan Request with id: 465445525 REJECTED due to check123','2022-11-13','167224409'),('READ','BANK','39237768','IH','2022-11-15','169681081'),('NOT READ','','261413554','hi','2022-11-15','172479877'),('READ','BANK','488521480','hi pratyush here!','2022-11-14','192879618'),('READ','227916089','848652407','hi','2022-11-13','196318984'),('NOT READ','BANK','281754829','hi bank this is test running','2022-11-14','203623553'),('NOT READ','734745215','BANK FIX_DEP DEPT','Your FD with id: 7203946 is now CLOSED as per your request','2022-11-13','234960863'),('NOT READ','893716579','BANK FIX_DEP DEPT','Your FD with id: 342768967 is now CLOSED as per your request','2022-11-13','247485377'),('READ','227916089','BANK LOAN DEPT','Your Loan Request with id: 712175605 is APPROVED','2022-11-13','248214124'),('NOT READ','747833094','BANK LOAN DEPT','Your Loan Request with id: 743866479 REJECTED due to DUPLICATE REQUEST','2022-11-14','249476115'),('NOT READ','39237768','BANK LOAN DEPT','Your Loan Request with id: 399529062 is APPROVED','2022-11-15','249772672'),('READ','893716579','BANK LOAN DEPT','Loan Request id: 858877005 REJECTED due to lmao','2022-11-12','251012351'),('NOT READ','227916089','BANK FIX_DEP DEPT','Your FD with id: 329588740 is now CLOSED as per your request','2022-11-14','267251496'),('READ','893716579','BANK LOAN DEPT','Loan Request id: 83393833 REJECTED due to duplicate requests','2022-11-12','299417622'),('READ','848652407','527880378','hi lmao','2022-11-12','29981750'),('READ','848652407','527880378','hi bengali!','2022-11-12','304580816'),('NOT READ','281754829','BANK LOAN DEPT','Your Loan Request with id: 715666962 is APPROVED','2022-11-15','316750361'),('READ','14680650','324804399','hi pal!','2022-11-13','325249741'),('NOT READ','893716579','BANK FIX_DEP DEPT','Your FD with id: 462165654 is now CLOSED as per your request','2022-11-13','351586381'),('NOT READ','700960728','BANK FIX_DEP DEPT','Your FD with id: 568929841 is now CLOSED as per your request','2022-11-15','366415002'),('READ','BANK','123456789','hi bank!','2022-11-13','375445318'),('READ','BANK','893716579','hi bank','2022-11-13','384394405'),('READ','14680650','838717474','hi pal--prats test','2022-11-13','390192117'),('READ','BANK','848652407','hi bubu','2022-11-13','39055024'),('NOT READ','700960728','BANK LOAN DEPT','Your Loan Request with id: 803507112 REJECTED due to no reason provided','2022-11-15','39103935'),('READ','BANK','747833094','this message is for bank administrator, ye test hai','2022-11-14','395531252'),('NOT READ','626881857','BANK LOAN DEPT','Your Loan Request with id: 897649276 REJECTED due to low balance','2022-11-14','428528017'),('READ','143727254','BANK FIX_DEP DEPT','Your FD with id: 333135977 is now CLOSED as per your request','2022-11-13','438175072'),('READ','BANK','734745215','hi bank this is test..','2022-11-13','448372067'),('NOT READ','893716579','BANK LOAN DEPT','Your Loan Request with id: 240254257 is APPROVED','2022-11-13','450219541'),('NOT READ','747833094','BANK LOAN DEPT','Your Loan Request with id: 190199987 is APPROVED','2022-11-14','481885812'),('READ','BANK','527880378','hi bank!','2022-11-12','489985661'),('READ','893716579','BANK LOAN DEPT','Loan Request id: 383488012 REJECTED due to check lol','2022-11-13','517260745'),('READ','19878772','488521480','hi pratyush here!','2022-11-14','534627082'),('READ','14680650','324804399','hi pal!','2022-11-13','535214052'),('READ','39237768','BANK FIX_DEP DEPT','Your FD with id: 720565734 is now CLOSED as per your request','2022-11-15','563821832'),('READ','BANK','123456789','hi bank!','2022-11-13','57977924'),('NOT READ','893716579','BANK LOAN DEPT','Loan Request id: 174778510 REJECTED due to lol','2022-11-13','607086465'),('READ','BANK','107966489','HI BANK I AM RUNNING TEST','2022-11-14','635083050'),('READ','227916089','123456789','hi man','2022-11-13','637696014'),('READ','BANK','39237768','IH','2022-11-15','637769382'),('READ','747833094','BANK FIX_DEP DEPT','Your FD with id: 612968704 is now CLOSED as per your request','2022-11-14','640172494'),('NOT READ','893716578','143727254','Hi harsh!','2022-11-13','64119701'),('READ','261413554','BANK FIX_DEP DEPT','Your FD with id: 712712371 is now CLOSED as per your request','2022-11-15','670572409'),('NOT READ','281754829','BANK LOAN DEPT','Your Loan Request with id: 106362670 is APPROVED','2022-11-15','679947929'),('NOT READ','143727254','BANK LOAN DEPT','Your Loan Request with id: 284198837 REJECTED due to lol','2022-11-13','683914607'),('NOT READ','848652407','281754829','hi person!','2022-11-14','688521939'),('READ','227916089','BANK FIX_DEP DEPT','Your FD with id: 697984231 is now CLOSED as per your request','2022-11-13','690009167'),('READ','527880378','747833094','ye ek bank management system hai','2022-11-14','696810210'),('READ','893716579','BANK LOAN DEPT','Loan Request id: 439008664 REJECTED due to lol','2022-11-12','706220340'),('NOT READ','BANK','324804399','hi bank!','2022-11-13','713237786'),('NOT READ','734745215','BANK LOAN DEPT','Your Loan Request with id: 513073233 is APPROVED','2022-11-13','733290865'),('NOT READ','BANK','227916089','hi bank test','2022-11-13','738354249'),('READ','838717474','BANK LOAN DEPT','Loan Request id: 632852795 REJECTED due to check','2022-11-13','74650506'),('NOT READ','848652407','227916089','hi priyanshu','2022-11-13','757517062'),('NOT READ','BANK','143727254','Hi bank!','2022-11-13','767670687'),('NOT READ','488521480','BANK LOAN DEPT','Your Loan Request with id: 366378335 is APPROVED','2022-11-14','787806120'),('READ','281754829','BANK FIX_DEP DEPT','Your FD with id: 381032484 is now CLOSED as per your request','2022-11-14','799206474'),('NOT READ','747833094','107966489','HI PERSON I AM RUNNING TEST','2022-11-14','805725217'),('NOT READ','BANK','261413554','hi','2022-11-15','832743165'),('READ','324804399','BANK LOAN DEPT','Loan Request id: 88150281 REJECTED due to invalid reason','2022-11-13','860254949'),('NOT READ','527880378','39237768','HI PRATYush','2022-11-15','886723805'),('NOT READ','734745215','BANK LOAN DEPT','Your Loan Request with id: 30123038 REJECTED due to low balance, nice name btw','2022-11-13','89226419'),('READ','107966489','BANK FIX_DEP DEPT','Your FD with id: 634241941 is now CLOSED as per your request','2022-11-14','98637000');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `nameaccnumlinkview`
--

DROP TABLE IF EXISTS `nameaccnumlinkview`;
/*!50001 DROP VIEW IF EXISTS `nameaccnumlinkview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nameaccnumlinkview` AS SELECT 
 1 AS `formno`,
 1 AS `accnum`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `paidloandues`
--

DROP TABLE IF EXISTS `paidloandues`;
/*!50001 DROP VIEW IF EXISTS `paidloandues`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `paidloandues` AS SELECT 
 1 AS `accnum`,
 1 AS `totalpaidloan`,
 1 AS `noofPAIDloans`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `readmessages`
--

DROP TABLE IF EXISTS `readmessages`;
/*!50001 DROP VIEW IF EXISTS `readmessages`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `readmessages` AS SELECT 
 1 AS `reciever`,
 1 AS `sender`,
 1 AS `message`,
 1 AS `date`,
 1 AS `messageid`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `formno` varchar(10) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `dob` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `marital` varchar(30) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `pincode` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('3418','Pratyush','fasd','09-Nov-2022','Male','fsa','Married','fasd','afsd','fsdaf','fsda'),('5488','Priyanshu','fdsa','10-Nov-2022','Male','sfa','Married','fasd','fdsa','dasf','ds'),('693','Harsh','afsd','01-Nov-2022','Male','fsdfd','Unmarried','asfsfa','dfs','321','af'),('5151','utk','ris','18-Nov-2022','Female','palutkarsh1901@gmail.com','Married','23 lko','lko','226028','up'),('8198','Final Test','lol','01-Nov-2022','Male','@gmail.com','Unmarried','abc','def','768123','ghi'),('3625','kjgu','u6rf','08-Nov-2022','Male','jy','Married','uyfyf','jkgh','hjvbh','jhv'),('1572','lol','lol','09-Nov-2022','Male','lol','Married','lol','lol','lol','lol'),('2676','Pratyush','Ravikant','23-Sep-2003','Male','pratyush12345786@gmail.com','Unmarried','SASTRA','Thanjavur','613401','Tamil Nadu'),('3209','lmao','pl','01-Nov-2022','Male','lol@gmail.com','Unmarried','l','i','3','v'),('8732','Himanshu Shekhar','sdfgh','04-Oct-2022','Male','guasugbajdb@','Unmarried','asdfg','darbhanga','847105','bihar'),('6295','Pratyush','Ravi Kant Deepak','23-Sep-2003','Male','prats@exmple.com','Unmarried','lol','lol','123456','tn'),('8427','prats','mbk','jb','Male','kjb','Married','jh','kjvhu','ku','kjg'),('2049','prats','jh','10-Nov-2022','Male','n ','Married','jvh','hvj','8765','jvbh'),('8160','Hardik Goyal','Senior Goyal','15-Nov-2003','Male','hardik@gmail.com','Unmarried','BVM','Ghaziabad','263006','UP'),('2927','Avinash Raghuvansshi','shailendra pratap singh','25-Jul-2004','Male','ainabshfggf@kfjh','Married','bghgv','sultanpur','228001','up'),('6287','Pankaj Tripathi','Akhanda Tripathi','08-Sep-1975','Male','aktripathi@gmail.com','Married','Lok kalyan Marg','Mirzapur','123987','UP'),('5696','Manoj Bajpayee','Senior Bajpayee','15-Aug-1984','Male','mbajpayee123@gmail.com','Married','Ludhiana Park','Mumbai','123456','Maharashtra'),('8184','Pratyush','lol','01-Nov-2022','Male','nanu87675','Unmarried','fdrwqr','terwywe','232562','tn'),('7927','afefrfwq','fwqe','02-Nov-2022','Male','fwq','Unmarried','few','qwfwqe','fqrq','wqf'),('2615','fder','weg','08-Nov-2022','Male','weg43@','Married','wreq','rwee','263001','2133324'),('2633','iukj','bhjiu','05-Nov-2022','Female','kjkbj','Unmarried','kjnj iu','jihbuj','8787','iij');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup2`
--

DROP TABLE IF EXISTS `signup2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup2` (
  `formno` varchar(10) DEFAULT NULL,
  `religion` varchar(30) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `income` varchar(30) DEFAULT NULL,
  `education` varchar(30) DEFAULT NULL,
  `occupation` varchar(30) DEFAULT NULL,
  `pan` varchar(30) DEFAULT NULL,
  `aadhar` varchar(40) DEFAULT NULL,
  `seniorCitizen` varchar(30) DEFAULT NULL,
  `existingAccount` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup2`
--

LOCK TABLES `signup2` WRITE;
/*!40000 ALTER TABLE `signup2` DISABLE KEYS */;
INSERT INTO `signup2` VALUES ('3418','HINDU','GENERAL','>100000 and <250000','Undergraduate','Doctor','fdsa','dfsa','No','No'),('5488','MUSLIM','GENERAL','<100000','Undergraduate','Teacher','dsfa324','23443','No','No'),('693','HINDU','GENERAL','<100000','Undergraduate','Student','aDG324','432345432','No','No'),('5151','OTHERS','OBC','>800000','No education','Engineer','123456','1234567','No','No'),('8198','HINDU','GENERAL','<100000','Undergraduate','Doctor','BCJDN19283A','126372936323','No','Yes'),('3625','HINDU','GENERAL','<100000','Undergraduate','Doctor','nb b','mmnvjh','No','No'),('1572','HINDU','GENERAL','<100000','Undergraduate','Doctor','lol','lol','Yes','Yes'),('2676','HINDU','GENERAL','<100000','Undergraduate','Student','ABCD1234E','123456789012','No','Yes'),('3209','HINDU','GENERAL','<100000','Undergraduate','Student','nmlop9876a','123456789','No','No'),('8732','HINDU','GENERAL','<100000','Undergraduate','Student','werte545h','423794451759','No','No'),('6295','HINDU','GENERAL','<100000','Undergraduate','Student','mhgi2346','157326785324','No','No'),('8427','HINDU','GENERAL','<100000','Undergraduate','Teacher','kjbb','8','No','No'),('2049','HINDU','GENERAL','<100000','Undergraduate','Doctor','hjbh76','8675434567','No','Yes'),('8160','HINDU','GENERAL','>800000','Student','Student','GIAP9087A','123456789012','No','No'),('2927','HINDU','GENERAL','<100000','Undergraduate','Student','hfdty','7958945787','No','No'),('6287','HINDU','GENERAL','>800000','No education','Self-Employed','LNMIT1234J','123456789012','No','No'),('5696','HINDU','GENERAL',' >500000 and <800000','Postgraduate','Teacher','ABCD1234E','123456789012','No','No'),('8184','HINDU','GENERAL','<100000','Undergraduate','Student','23145dsff','21345663456','No','No'),('7927','HINDU','GENERAL','<100000','Undergraduate','Student','qfw23213','13222532443','No','No'),('2615','HINDU','GENERAL','<100000','Undergraduate','Doctor','1234wedfg','12345678987','No','No'),('2633','HINDU','GENERAL','<100000','Undergraduate','Student','jnhg897','098765432123','No','No');
/*!40000 ALTER TABLE `signup2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup3`
--

DROP TABLE IF EXISTS `signup3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup3` (
  `formno` varchar(10) DEFAULT NULL,
  `accNum` int NOT NULL,
  `pin` int DEFAULT NULL,
  `status` varchar(20) DEFAULT (_cp850'ACTIVE'),
  `opendate` date DEFAULT (curdate()),
  PRIMARY KEY (`accNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup3`
--

LOCK TABLES `signup3` WRITE;
/*!40000 ALTER TABLE `signup3` DISABLE KEYS */;
INSERT INTO `signup3` VALUES ('5151',14680650,760,'FREEZED',NULL),('8427',19878772,81,'ACTIVE',NULL),('7927',39237768,4022,'CLOSED','2022-11-15'),('6287',107966489,2448,'CLOSED',NULL),('3209',143727254,1567,'ACTIVE',NULL),('3625',171261237,5904,'ACTIVE',NULL),('8732',227916089,5136,'CLOSED',NULL),('2633',261413554,115,'ACTIVE','2022-11-15'),('5696',281754829,4166,'CLOSED',NULL),('1572',324804399,8570,'ACTIVE',NULL),('2049',488521480,6641,'CLOSED',NULL),('3418',527880378,1287,'FREEZED',NULL),('2927',626881857,2339,'FREEZED',NULL),('8184',700960728,4842,'ACTIVE','2022-11-15'),('2615',712938379,6705,'ACTIVE','2022-11-15'),('6295',734745215,2373,'CLOSED',NULL),('8160',747833094,7567,'CLOSED',NULL),('2676',838717474,7361,'ACTIVE',NULL),('5488',848652407,8740,'FREEZED',NULL);
/*!40000 ALTER TABLE `signup3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `totalamtinfd`
--

DROP TABLE IF EXISTS `totalamtinfd`;
/*!50001 DROP VIEW IF EXISTS `totalamtinfd`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `totalamtinfd` AS SELECT 
 1 AS `accnum`,
 1 AS `amtDeposited`,
 1 AS `finalAmt`,
 1 AS `noOfActiveFD`,
 1 AS `bal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `accNum` int DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `bal` double DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (527880378,600.5,5600.5,'Deposit','2022-11-12'),(527880378,5600,0.5,'Withdraw','2022-11-12'),(527880378,7000,7000.5,'Deposit','2022-11-12'),(527880378,1500,5500.5,'Withdraw','2022-11-12'),(527880378,300,5200.5,'Withdraw','2022-11-12'),(848652407,300,5300,'Deposit','2022-11-12'),(527880378,140,5060.5,'Withdraw','2022-11-12'),(848652407,140,5440,'Deposit','2022-11-12'),(848652407,5438.5,1.5,'Withdraw','2022-11-12'),(848652407,500,501.5,'Deposit','2022-11-12'),(848652407,15,486.5,'Withdraw','2022-11-12'),(527880378,15,5075.5,'Deposit','2022-11-12'),(848652407,25,461.5,'Withdraw','2022-11-12'),(527880378,25,5100.5,'Deposit','2022-11-12'),(527880378,100,5000.5,'Withdraw','2022-11-12'),(848652407,100,561.5,'Deposit','2022-11-12'),(848652407,5000,5561.5,'DEPOSIT(LOAN)','2022-11-12'),(848652407,100,5661.5,'DEPOSIT(LOAN)','2022-11-12'),(527880378,19000,29100.5,'DEPOSIT(LOAN)','2022-11-12'),(848652407,123,24784.5,'DEPOSIT(LOAN)','2022-11-12'),(848652407,20000,44784.5,'DEPOSIT(LOAN)','2022-11-12'),(848652407,11000,3784.5,'Withdraw(TRAN)','2022-11-12'),(527880378,11000,70100.5,'Deposit(TRAN)','2022-11-12'),(848652407,50000,53784.5,'DEPOSIT(LOAN)','2022-11-12'),(893716579,10.5,15010.5,'Deposit','2022-11-12'),(893716579,5678.4,9332.1,'Withdraw','2022-11-12'),(893716579,500,8832.1,'Withdraw(TRAN)','2022-11-12'),(848652407,500,54284.5,'Deposit(TRAN)','2022-11-12'),(893716579,150000,158832.1,'DEPOSIT(LOAN)','2022-11-12'),(893716579,100,158932.1,'DEPOSIT(LOAN)','2022-11-12'),(14680650,2356,102356,'Deposit','2022-11-12'),(14680650,6999,95357,'Withdraw','2022-11-12'),(14680650,3247,92110,'Withdraw(TRAN)','2022-11-12'),(848652407,3247,57531.5,'Deposit(TRAN)','2022-11-12'),(14680650,5000,97110,'DEPOSIT(LOAN)','2022-11-12'),(893716579,15890,143042.1,'Withdraw','2022-11-12'),(893716579,143042,0.10000000000582077,'Withdraw','2022-11-12'),(893716579,100,100.10000000000582,'DEPOSIT(LOAN)','2022-11-12'),(14680650,97110,0,'Withdraw','2022-11-12'),(171261237,100,10100,'Deposit','2022-11-12'),(171261237,50,10050,'Withdraw','2022-11-12'),(893716579,1000,1100.1000000000058,'DEPOSIT(LOAN)','2022-11-12'),(893716579,1000,2100.100000000006,'DEPOSIT(LOAN)','2022-11-12'),(893716579,100,2200.100000000006,'DEPOSIT(LOAN)','2022-11-12'),(893716579,900,1300.1000000000058,'Withdraw(TRAN)','2022-11-12'),(527880378,900,71000.5,'Deposit(TRAN)','2022-11-12'),(527880378,10000,61000.5,'Withdraw(TRAN)','2022-11-12'),(848652407,10000,67531.5,'Deposit(TRAN)','2022-11-12'),(527880378,1000,62000.5,'DEPOSIT(LOAN)','2022-11-12'),(324804399,100,13100,'Deposit','2022-11-13'),(324804399,69,13031,'Withdraw','2022-11-13'),(324804399,98.5,12932.5,'Withdraw','2022-11-13'),(324804399,500,12432.5,'Withdraw(TRAN)','2022-11-13'),(14680650,500,500,'Deposit(TRAN)','2022-11-13'),(324804399,900,11532.5,'Withdraw(TRAN)','2022-11-13'),(14680650,900,1400,'Deposit(TRAN)','2022-11-13'),(14680650,199,1599,'Deposit','2022-11-13'),(14680650,100,1499,'Withdraw','2022-11-13'),(14680650,130,1369,'Withdraw(TRAN)','2022-11-13'),(324804399,130,11662.5,'Deposit(TRAN)','2022-11-13'),(14680650,120,1489,'DEPOSIT(LOAN)','2022-11-13'),(324804399,1900,13562.5,'DEPOSIT(LOAN)','2022-11-13'),(893716579,300,1000.1000000000058,'Withdraw(FD)','2022-11-13'),(893716579,100,900.1000000000058,'Withdraw(FD)','2022-11-13'),(893716579,100,1000.1000000000058,'DEP(INST_LOAN)','2022-11-13'),(893716579,0.1000000000058,1000,'Withdraw','2022-11-13'),(893716579,30000,31000,'DEP(INST_LOAN)','2022-11-13'),(893716579,100,31100,'DEP(INST_LOAN)','2022-11-13'),(893716579,100,31200,'DEPOSIT(LOAN)','2022-11-13'),(893716579,1200,30000,'Withdraw(FD)','2022-11-13'),(893716579,100,30100,'DEP(INST_LOAN)','2022-11-13'),(838717474,100.5,2100.5,'Deposit','2022-11-13'),(838717474,90,2010.5,'Withdraw','2022-11-13'),(838717474,500,1510.5,'Withdraw(TRAN)','2022-11-13'),(14680650,500,1989,'Deposit(TRAN)','2022-11-13'),(838717474,200,1310.5,'Withdraw(TRAN)','2022-11-13'),(14680650,200,2189,'Deposit(TRAN)','2022-11-13'),(838717474,300,1010.5,'Withdraw(FD)','2022-11-13'),(838717474,100,1110.5,'DEP(INST_LOAN)','2022-11-13'),(14680650,7982,10171,'DEP(INST_LOAN)','2022-11-13'),(838717474,100,1210.5,'DEPOSIT(LOAN)','2022-11-13'),(14680650,120,10291,'DEPOSIT(LOAN)','2022-11-13'),(893716579,1,30101,'DEP(INST_LOAN)','2022-11-13'),(893716579,1,30102,'DEP(INST_LOAN)','2022-11-13'),(893716579,1,30103,'DEPOSIT(LOAN)','2022-11-13'),(893716579,1,30104,'DEPOSIT(LOAN)','2022-11-13'),(893716579,12000,18104,'Withdraw(FD)','2022-11-13'),(893716579,336,18440,'DEPOSIT(FD)','2022-11-13'),(893716579,18440,0,'Withdraw','2022-11-13'),(893716579,13440,13440,'DEPOSIT(FD)','2022-11-13'),(893716579,100,13540,'DEP(INST_LOAN)','2022-11-13'),(893716579,13000,540,'Withdraw(FD)','2022-11-13'),(893716579,540,0,'Withdraw(FD)','2022-11-13'),(893716579,18720,18720,'DEPOSIT(FD)','2022-11-13'),(893716579,100,18820,'DEPOSIT(LOAN)','2022-11-13'),(893716579,846.72,19666.72,'DEPOSIT(FD)','2022-11-13'),(893716579,1344,21010.72,'DEPOSIT(FD)','2022-11-13'),(893716579,5000,16010.720000000001,'Withdraw(FD)','2022-11-13'),(893716579,86.4,16097.12,'DEPOSIT(FD)','2022-11-13'),(893716579,5600,21697.120000000003,'DEPOSIT(FD)','2022-11-13'),(143727254,100,10100,'Deposit','2022-11-13'),(143727254,85.5,10014.5,'Withdraw','2022-11-13'),(143727254,120,9894.5,'Withdraw(TRAN)','2022-11-13'),(893716579,120,21817.120000000003,'Deposit(TRAN)','2022-11-13'),(143727254,100,9794.5,'Withdraw(FD)','2022-11-13'),(143727254,92.8,9887.3,'DEPOSIT(FD)','2022-11-13'),(143727254,120,10007.3,'DEP(INST_LOAN)','2022-11-13'),(893716579,10000,11817.120000000003,'Withdraw(FD)','2022-11-13'),(227916089,100,600,'Deposit','2022-11-13'),(227916089,600,0,'Withdraw','2022-11-13'),(227916089,400000,400000,'DEP(INST_LOAN)','2022-11-13'),(227916089,400000,0,'Withdraw','2022-11-13'),(893716579,160000,171817.12,'Deposit','2022-11-13'),(893716579,30000,201817.12,'Deposit','2022-11-13'),(893716579,3000,204817.12,'DEP(INST_LOAN)','2022-11-13'),(893716579,900,205717.12,'DEP(INST_LOAN)','2022-11-13'),(893716579,11000,216717.12,'DEP(INST_LOAN)','2022-11-13'),(893716579,210000,426717.12,'Deposit','2022-11-13'),(893716579,10000,436717.12,'DEP(INST_LOAN)','2022-11-13'),(893716579,220000,656717.12,'Deposit','2022-11-13'),(893716579,100000,556717.12,'Withdraw','2022-11-13'),(893716579,556000,717.1199999999953,'Withdraw','2022-11-13'),(893716579,447190,447907.12,'Deposit','2022-11-13'),(227916089,100,100,'DEP(INST_LOAN)','2022-11-13'),(227916089,100,0,'Withdraw(TRAN)','2022-11-13'),(527880378,100,62100.5,'Deposit(TRAN)','2022-11-13'),(227916089,2000,2000,'Deposit','2022-11-13'),(227916089,100,1900,'Withdraw(FD)','2022-11-13'),(227916089,92.8,1992.8,'DEPOSIT(FD)','2022-11-13'),(227916089,1000,992.8,'Withdraw(FD)','2022-11-13'),(227916089,2000,2992.8,'DEP(INST_LOAN)','2022-11-13'),(227916089,10000,12992.8,'DEP(INST_LOAN)','2022-11-13'),(227916089,30000,42992.8,'DEP(INST_LOAN)','2022-11-13'),(227916089,100,43092.8,'DEPOSIT(LOAN)','2022-11-13'),(527880378,100,62200.5,'DEP(INST_LOAN)','2022-11-13'),(527880378,1.07,62198.93,'WITH_LOAN(REP)','2022-11-13'),(527880378,160.5,62037.5,'WITH_LOAN(REP)','2022-11-13'),(734745215,100.5,2100.5,'Deposit','2022-11-13'),(734745215,200,1900.5,'Withdraw','2022-11-13'),(734745215,120,1780.5,'Withdraw(TRAN)','2022-11-13'),(227916089,120,43212.8,'Deposit(TRAN)','2022-11-13'),(734745215,600,1180.5,'Withdraw(FD)','2022-11-13'),(734745215,556.8,1737.3,'DEPOSIT(FD)','2022-11-13'),(734745215,1000,2737.3,'DEP(INST_LOAN)','2022-11-13'),(734745215,1200,1537,'WITH_LOAN(REP)','2022-11-13'),(734745215,100,1437,'Withdraw(FD)','2022-11-13'),(734745215,200,1637,'DEP(INST_LOAN)','2022-11-13'),(734745215,240,1397,'WITH_LOAN(REP)','2022-11-13'),(734745215,100,1497,'DEP(INST_LOAN)','2022-11-13'),(734745215,120,1377,'WITH_LOAN(REP)','2022-11-13'),(734745215,200,1577,'DEPOSIT(LOAN)','2022-11-13'),(734745215,1455.8,1455.8,'ACC_CLOS_SETLMT','2022-11-14'),(19878772,80,7080,'Deposit','2022-11-14'),(488521480,59,12059,'Deposit','2022-11-14'),(488521480,120,11939,'Withdraw','2022-11-14'),(488521480,78,11861,'Withdraw(TRAN)','2022-11-14'),(19878772,78,7158,'Deposit(TRAN)','2022-11-14'),(488521480,900,10961,'Withdraw(FD)','2022-11-14'),(488521480,1008,11969,'DEPOSIT(FD)','2022-11-14'),(488521480,1000,12969,'DEP(INST_LOAN)','2022-11-14'),(488521480,1200,11769,'WITH_LOAN(REP)','2022-11-14'),(488521480,1000,12769,'DEP(INST_LOAN)','2022-11-14'),(488521480,500,13269,'DEPOSIT(LOAN)','2022-11-14'),(488521480,11569,11569,'ACC_CLOS_SETLMT','2022-11-14'),(747833094,100,4100,'Deposit','2022-11-14'),(747833094,90,4010,'Withdraw','2022-11-14'),(747833094,700,3310,'Withdraw(TRAN)','2022-11-14'),(527880378,700,62737.5,'Deposit(TRAN)','2022-11-14'),(747833094,2000,1310,'Withdraw(FD)','2022-11-14'),(747833094,1984,3294,'DEPOSIT(FD)','2022-11-14'),(747833094,3000,6294,'DEP(INST_LOAN)','2022-11-14'),(747833094,3000,9294,'DEP(INST_LOAN)','2022-11-14'),(747833094,3600,5694,'WITH_LOAN(REP)','2022-11-14'),(747833094,3000,2694,'Withdraw(FD)','2022-11-14'),(747833094,10000,12694,'DEPOSIT(LOAN)','2022-11-14'),(747833094,2454,2454,'ACC_CLOS_SETLMT','2022-11-14'),(227916089,107,43105,'WITH_LOAN(REP)','2022-11-14'),(227916089,120,42985,'WITH_LOAN(REP)','2022-11-14'),(227916089,12000,30985,'WITH_LOAN(REP)','2022-11-14'),(227916089,2400,28585,'WITH_LOAN(REP)','2022-11-14'),(227916089,1120,29705,'DEPOSIT(FD)','2022-11-14'),(227916089,100,29805,'DEP(INST_LOAN)','2022-11-14'),(227916089,1000,30805,'DEP(INST_LOAN)','2022-11-14'),(227916089,486915,517720,'Deposit','2022-11-14'),(626881857,890,1590,'Deposit','2022-11-14'),(626881857,78,1512,'Withdraw','2022-11-14'),(626881857,8990,10502,'DEP(INST_LOAN)','2022-11-14'),(227916089,400,400,'ACC_CLOS_SETLMT','2022-11-14'),(107966489,2000,32000,'Deposit','2022-11-14'),(107966489,300,31700,'Withdraw','2022-11-14'),(107966489,10000,41700,'DEP(INST_LOAN)','2022-11-14'),(107966489,12000,29700,'WITH_LOAN(REP)','2022-11-14'),(107966489,20000,9700,'Withdraw(FD)','2022-11-14'),(107966489,22400,32100,'DEPOSIT(FD)','2022-11-14'),(107966489,300,31800,'Withdraw(TRAN)','2022-11-14'),(626881857,300,10802,'Deposit(TRAN)','2022-11-14'),(107966489,20000,11800,'Withdraw(FD)','2022-11-14'),(107966489,40000,51800,'DEP(INST_LOAN)','2022-11-14'),(107966489,50000,1800,'Withdraw','2022-11-14'),(107966489,27640,29440,'Deposit','2022-11-14'),(107966489,20000,49440,'DEPOSIT(LOAN)','2022-11-14'),(107966489,0,0,'ACC_CLOS_SETLMT','2022-11-14'),(281754829,120,10120,'Deposit','2022-11-14'),(281754829,400,9720,'Withdraw','2022-11-14'),(281754829,1000,8720,'Withdraw(TRAN)','2022-11-14'),(848652407,1000,68531.5,'Deposit(TRAN)','2022-11-14'),(281754829,8000,720,'Withdraw(FD)','2022-11-14'),(281754829,11520,12240,'DEPOSIT(FD)','2022-11-14'),(281754829,10000,22240,'DEP(INST_LOAN)','2022-11-14'),(281754829,12000,10240,'WITH_LOAN(REP)','2022-11-14'),(281754829,6000,4240,'Withdraw(FD)','2022-11-14'),(281754829,2000,6240,'DEP(INST_LOAN)','2022-11-15'),(700960728,100,10100,'Deposit','2022-11-15'),(700960728,80,10020,'Withdraw','2022-11-15'),(700960728,100,10120,'DEP(INST_LOAN)','2022-11-15'),(700960728,200,9920,'Withdraw(FD)','2022-11-15'),(700960728,211.2,10131.2,'DEPOSIT(FD)','2022-11-15'),(700960728,3000,7131.200000000001,'Withdraw(FD)','2022-11-15'),(700960728,100,7031.200000000001,'Withdraw(TRAN)','2022-11-15'),(527880378,100,62837.5,'Deposit(TRAN)','2022-11-15'),(700960728,3000,4031.2000000000007,'Withdraw(FD)','2022-11-15'),(281754829,300,6540,'DEPOSIT(LOAN)','2022-11-15'),(281754829,10000,16540,'DEPOSIT(LOAN)','2022-11-15'),(281754829,9024,9024,'ACC_CLOS_SETLMT','2022-11-15'),(39237768,200,20200,'Deposit','2022-11-15'),(39237768,300,19900,'Withdraw','2022-11-15'),(39237768,800,19100,'Withdraw(TRAN)','2022-11-15'),(527880378,800,63637.5,'Deposit(TRAN)','2022-11-15'),(39237768,3000,22100,'DEP(INST_LOAN)','2022-11-15'),(39237768,3600,18500,'WITH_LOAN(REP)','2022-11-15'),(39237768,40000,58500,'DEP(INST_LOAN)','2022-11-15'),(39237768,7000,51500,'Withdraw(FD)','2022-11-15'),(39237768,6000,45500,'Withdraw(FD)','2022-11-15'),(39237768,5568,51068,'DEPOSIT(FD)','2022-11-15'),(39237768,300,51368,'DEPOSIT(LOAN)','2022-11-15'),(39237768,9116,9116,'ACC_CLOS_SETLMT','2022-11-15'),(261413554,800,90800,'Deposit','2022-11-15'),(261413554,5000,85800,'Withdraw','2022-11-15'),(261413554,30000,55800,'Withdraw(FD)','2022-11-15'),(261413554,33600,89400,'DEPOSIT(FD)','2022-11-15'),(261413554,8000,97400,'DEP(INST_LOAN)','2022-11-15'),(261413554,80000,17400,'Withdraw(FD)','2022-11-15'),(261413554,300000,317400,'DEP(INST_LOAN)','2022-11-15'),(261413554,300000,617400,'Deposit','2022-11-15'),(261413554,600000,17400,'Withdraw','2022-11-15'),(261413554,262600,280000,'Deposit','2022-11-15');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `transactionview`
--

DROP TABLE IF EXISTS `transactionview`;
/*!50001 DROP VIEW IF EXISTS `transactionview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `transactionview` AS SELECT 
 1 AS `name`,
 1 AS `bal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `transfers`
--

DROP TABLE IF EXISTS `transfers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfers` (
  `transactionid` int NOT NULL,
  `debitoraccnum` int DEFAULT NULL,
  `benificiaryaccnum` int DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfers`
--

LOCK TABLES `transfers` WRITE;
/*!40000 ALTER TABLE `transfers` DISABLE KEYS */;
INSERT INTO `transfers` VALUES (26434566,527880378,848652407,100,'2022-11-12'),(47556858,39237768,527880378,800,'2022-11-15'),(56780919,848652407,527880378,11000,'2022-11-12'),(143356819,747833094,527880378,700,'2022-11-14'),(208102286,893716579,527880378,900,'2022-11-12'),(242661304,700960728,527880378,100,'2022-11-15'),(295496323,527880378,848652407,10000,'2022-11-12'),(306950087,281754829,848652407,1000,'2022-11-14'),(311043300,527880378,848652407,300,'2022-11-12'),(335297031,848652407,527880378,15,'2022-11-12'),(388777318,143727254,893716579,120,'2022-11-13'),(401273017,227916089,527880378,100,'2022-11-13'),(412914751,893716579,848652407,500,'2022-11-12'),(428884273,734745215,227916089,120,'2022-11-13'),(453496713,107966489,626881857,300,'2022-11-14'),(468930261,324804399,14680650,900,'2022-11-13'),(471617009,488521480,19878772,78,'2022-11-14'),(522510825,324804399,14680650,500,'2022-11-13'),(568614175,848652407,527880378,25,'2022-11-12'),(721341491,14680650,848652407,3247,'2022-11-12'),(724673830,14680650,324804399,130,'2022-11-13'),(737249412,527880378,848652407,140,'2022-11-12'),(764763999,838717474,14680650,200,'2022-11-13'),(766945218,838717474,14680650,500,'2022-11-13');
/*!40000 ALTER TABLE `transfers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `unpaidloandues`
--

DROP TABLE IF EXISTS `unpaidloandues`;
/*!50001 DROP VIEW IF EXISTS `unpaidloandues`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `unpaidloandues` AS SELECT 
 1 AS `accnum`,
 1 AS `totalunpaidloan`,
 1 AS `noofunpaidloans`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `unpaidloans`
--

DROP TABLE IF EXISTS `unpaidloans`;
/*!50001 DROP VIEW IF EXISTS `unpaidloans`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `unpaidloans` AS SELECT 
 1 AS `accnum`,
 1 AS `reqloanid`,
 1 AS `amt`,
 1 AS `dur`,
 1 AS `finalamt`,
 1 AS `reqdate`,
 1 AS `apprdate`,
 1 AS `type`,
 1 AS `bal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `unreadmessages`
--

DROP TABLE IF EXISTS `unreadmessages`;
/*!50001 DROP VIEW IF EXISTS `unreadmessages`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `unreadmessages` AS SELECT 
 1 AS `reciever`,
 1 AS `sender`,
 1 AS `message`,
 1 AS `date`,
 1 AS `messageid`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `accnumbalancelinkview`
--

/*!50001 DROP VIEW IF EXISTS `accnumbalancelinkview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `accnumbalancelinkview` AS select `n`.`accnum` AS `accnum`,`n`.`name` AS `name`,`b`.`bal` AS `bal` from (`nameaccnumlinkview` `n` join `balance` `b`) where (`n`.`accnum` = `b`.`accNum`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `accwithnameview`
--

/*!50001 DROP VIEW IF EXISTS `accwithnameview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `accwithnameview` AS select `n`.`accnum` AS `accnum`,`n`.`name` AS `name`,`a`.`bal` AS `bal`,`s3`.`status` AS `status`,`s3`.`opendate` AS `opendate` from ((`nameaccnumlinkview` `n` join `accnumbalancelinkview` `a`) join `signup3` `s3`) where ((`n`.`accnum` = `s3`.`accNum`) and (`s3`.`accNum` = `a`.`accnum`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `activeaccunpaidloandues`
--

/*!50001 DROP VIEW IF EXISTS `activeaccunpaidloandues`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activeaccunpaidloandues` AS select `l`.`accnum` AS `accnum`,`l`.`totalunpaidloan` AS `totalunpaidloan`,`l`.`noofunpaidloans` AS `noofunpaidloans`,`s3`.`status` AS `status` from (`unpaidloandues` `l` join `signup3` `s3`) where ((`l`.`accnum` = `s3`.`accNum`) and (`s3`.`status` <> 'FREEZED')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `loanbalrelation`
--

/*!50001 DROP VIEW IF EXISTS `loanbalrelation`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `loanbalrelation` AS select `l`.`reqLoanID` AS `reqloanid`,`l`.`dur` AS `dur`,`l`.`reason` AS `reason`,`l`.`reqdate` AS `reqdate`,`l`.`amt` AS `amt`,`b`.`bal` AS `bal` from (`loanrequests` `l` join `balance` `b`) where ((`l`.`accNum` = `b`.`accNum`) and (`l`.`apprStatus` = 'PENDING')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nameaccnumlinkview`
--

/*!50001 DROP VIEW IF EXISTS `nameaccnumlinkview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nameaccnumlinkview` AS select `s3`.`formno` AS `formno`,`s3`.`accNum` AS `accnum`,`s1`.`name` AS `name` from (`signup` `s1` join `signup3` `s3`) where (`s1`.`formno` = `s3`.`formno`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `paidloandues`
--

/*!50001 DROP VIEW IF EXISTS `paidloandues`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `paidloandues` AS select `l`.`accNum` AS `accnum`,sum(`l`.`finalamt`) AS `totalpaidloan`,count(0) AS `noofPAIDloans` from (`signup3` `s3` join `loanrequests` `l`) where ((`l`.`persStatus` = 'PAID') and (`l`.`apprStatus` like '%APPR%') and (`s3`.`status` = 'active') and (`s3`.`accNum` = `l`.`accNum`)) group by `l`.`accNum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `readmessages`
--

/*!50001 DROP VIEW IF EXISTS `readmessages`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `readmessages` AS select `messages`.`reciever` AS `reciever`,`messages`.`sender` AS `sender`,`messages`.`message` AS `message`,`messages`.`date` AS `date`,`messages`.`messageid` AS `messageid` from `messages` where (`messages`.`readstatus` = 'READ') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totalamtinfd`
--

/*!50001 DROP VIEW IF EXISTS `totalamtinfd`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totalamtinfd` AS select `f`.`accnum` AS `accnum`,sum(`f`.`amt`) AS `amtDeposited`,sum(`f`.`finalamt`) AS `finalAmt`,count(0) AS `noOfActiveFD`,`b`.`bal` AS `bal` from ((`fd` `f` join `signup3` `s3`) join `balance` `b`) where ((`s3`.`accNum` = `f`.`accnum`) and (`f`.`accnum` = `b`.`accNum`) and (`f`.`status` = 'active') and (`s3`.`status` = 'active')) group by `f`.`accnum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `transactionview`
--

/*!50001 DROP VIEW IF EXISTS `transactionview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `transactionview` AS select `s1`.`name` AS `name`,`b`.`bal` AS `bal` from ((`signup` `s1` join `signup3` `s3`) join `balance` `b`) where ((`s1`.`formno` = `s3`.`formno`) and (`s3`.`accNum` = `s3`.`accNum`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `unpaidloandues`
--

/*!50001 DROP VIEW IF EXISTS `unpaidloandues`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `unpaidloandues` AS select `loanrequests`.`accNum` AS `accnum`,sum(`loanrequests`.`finalamt`) AS `totalunpaidloan`,count(0) AS `noofunpaidloans` from `loanrequests` where ((`loanrequests`.`persStatus` = 'UNPAID') and (`loanrequests`.`apprStatus` like '%APPR%')) group by `loanrequests`.`accNum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `unpaidloans`
--

/*!50001 DROP VIEW IF EXISTS `unpaidloans`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `unpaidloans` AS select `l`.`accNum` AS `accnum`,`l`.`reqLoanID` AS `reqloanid`,`l`.`amt` AS `amt`,`l`.`dur` AS `dur`,`l`.`finalamt` AS `finalamt`,`l`.`reqdate` AS `reqdate`,`l`.`apprdate` AS `apprdate`,`l`.`type` AS `type`,`b`.`bal` AS `bal` from (`loanrequests` `l` join `balance` `b`) where ((`l`.`accNum` = `b`.`accNum`) and (`l`.`persStatus` = 'UNPAID') and (`l`.`apprStatus` like '%APPR%')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `unreadmessages`
--

/*!50001 DROP VIEW IF EXISTS `unreadmessages`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `unreadmessages` AS select `messages`.`reciever` AS `reciever`,`messages`.`sender` AS `sender`,`messages`.`message` AS `message`,`messages`.`date` AS `date`,`messages`.`messageid` AS `messageid` from `messages` where (`messages`.`readstatus` = 'NOT READ') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15 19:38:03
