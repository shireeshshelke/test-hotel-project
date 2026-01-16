--
-- Table structure for table `admininfo`
--

DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `NID` varchar(25) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admininfo`
--

LOCK TABLES `admininfo` WRITE;
INSERT INTO `admininfo` VALUES 
('ADM001','Payal Gadmale','admin123'),
('ADM002','Priya Patil','admin456'),
('ADM003','Vikram Jadhav','admin789');
UNLOCK TABLES;

--
-- Table structure for table `checkinoutinfo`
--

DROP TABLE IF EXISTS `checkinoutinfo`;
CREATE TABLE `checkinoutinfo` (
  `SI_NO` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `PHONE` varchar(30) DEFAULT NULL,
  `ADDRESS` varchar(30) DEFAULT NULL,
  `NID` varchar(15) DEFAULT NULL,
  `ROOMNO` varchar(15) DEFAULT NULL,
  `ROOMTYPE` varchar(15) DEFAULT NULL,
  `CAPACITY` varchar(15) DEFAULT NULL,
  `CHECKEDIN` varchar(20) DEFAULT NULL,
  `CHECKEDOUT` varchar(20) DEFAULT NULL,
  `PRICEDAY` varchar(30) DEFAULT NULL,
  `TOTALDAYS` varchar(30) DEFAULT NULL,
  `TOTALPRICE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`SI_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `checkinoutinfo`
--

LOCK TABLES `checkinoutinfo` WRITE;
INSERT INTO `checkinoutinfo` VALUES 
(1,'Payal Gadmale','payal.gadmale@gmail.com','9876543210','Pen, MH 411001','PG001','101','AC','Single','2024-01-15','2024-01-20','2000','5','10000'),
(2,'Priya Patil','priya.patil@gmail.com','9123456789','Mumbai, MH 400001','PP001','102','AC','Double','2024-01-16','2024-01-18','2500','2','5000'),
(3,'Amit Singh','amit.singh@gmail.com','9876123456','Delhi, DL 110001','AS001','103','Non-AC','Single','2024-01-14','2024-01-19','1500','5','7500'),
(4,'Neha Desai','neha.desai@gmail.com','9988776655','Bangalore, KA 560001','ND001','104','AC','Double','2024-01-10','2024-01-25','2200','15','33000'),
(5,'Vikram Jadhav','vikram.jadhav@gmail.com','9765432109','Pune, MH 411004','VJ001','105','Non-AC','Double','2024-01-12','2024-01-22','1800','10','18000'),
(6,'Ananya Reddy','ananya.reddy@gmail.com','9654321098','Hyderabad, TS 500001','AR001','101','AC','Single','2024-01-17','2024-01-20','2000','3','6000'),
(7,'Rohan Gupta','rohan.gupta@gmail.com','9543210987','Pune, MH 411002','RG001','102','AC','Double','2024-01-13','2024-01-23','2500','10','25000'),
(8,'Sneha Iyer','sneha.iyer@gmail.com','9432109876','Bangalore, KA 560002','SI001','103','Non-AC','Single','2024-01-11','2024-01-21','1500','10','15000'),
(9,'Sanjay Sharma','sanjay.sharma@gmail.com','9321098765','Mumbai, MH 400002','SS001','104','AC','Double','2024-01-15','2024-01-17','2200','2','4400'),
(10,'Kavita Nair','kavita.nair@gmail.com','9210987654','Pune, MH 411005','KN001','105','Non-AC','Double','2024-01-16','2024-01-26','1800','10','18000');
UNLOCK TABLES;

--
-- Table structure for table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `NAME` varchar(30) DEFAULT NULL,
  `NID` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `PHONE` varchar(30) DEFAULT NULL,
  `ADDRESS` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customerinfo`
--

LOCK TABLES `customerinfo` WRITE;
INSERT INTO `customerinfo` VALUES 
('Payal Gadmale','PG001','gadmale2024','payal.gadmale@gmail.com','9876543210','Pen, Pen, MH 411001'),
('Priya Patil','PP001','patil2024','priya.patil@gmail.com','9123456789','Apartment 12, Mumbai, MH 400001'),
('Amit Singh','AS001','singh2024','amit.singh@gmail.com','9876123456','House 25, Delhi, DL 110001'),
('Neha Desai','ND001','desai2024','neha.desai@gmail.com','9988776655','Flat 3, Bangalore, KA 560001');
UNLOCK TABLES;

--
-- Table structure for table `employeeinfo`
--

DROP TABLE IF EXISTS `employeeinfo`;
CREATE TABLE `employeeinfo` (
  `NAME` varchar(30) DEFAULT NULL,
  `NID` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `ADDRESS` varchar(40) DEFAULT NULL,
  `PHONE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employeeinfo`
--

LOCK TABLES `employeeinfo` WRITE;
INSERT INTO `employeeinfo` VALUES 
('Payal Gadmale','PG001','pgpass123','payal.gadmale@gmail.com','Pen, Pen, MH 411001','9876543210'),
('Ananya Reddy','AR001','arpass456','ananya.reddy@gmail.com','Flat 5, Hyderabad, TS 500001','9654321098'),
('Rohan Gupta','RG001','rgpass789','rohan.gupta@gmail.com','Apt 8, Pune, MH 411002','9543210987'),
('Sneha Iyer','SI001','sipass101','sneha.iyer@gmail.com','House 15, Bangalore, KA 560002','9432109876'),
('Sanjay Sharma','SS001','sspass202','sanjay.sharma@gmail.com','Flat 7, Mumbai, MH 400002','9321098765'),
('Kavita Nair','KN001','knpass303','kavita.nair@gmail.com','House 20, Pune, MH 411005','9210987654');
UNLOCK TABLES;

--
-- Table structure for table `roominfo`
--

DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `ROOM_NO` varchar(30) NOT NULL,
  `TYPE` varchar(10) DEFAULT NULL,
  `CAPACITY` varchar(10) DEFAULT NULL,
  `PRICE_DAY` varchar(30) DEFAULT NULL,
  `STATUS` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`ROOM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roominfo`
--

LOCK TABLES `roominfo` WRITE;
INSERT INTO `roominfo` VALUES 
('101','AC','Single','2000','Booked'),
('102','AC','Double','2500','Booked'),
('103','Non-AC','Single','1500','Available'),
('104','AC','Double','2200','Booked'),
('105','Non-AC','Double','1800','Available'),
('106','AC','Triple','3000','Available'),
('107','Deluxe AC','Double','3500','Available'),
('108','Non-AC','Single','1200','Available'),
('109','AC','Single','2000','Booked'),
('110','Suite AC','Double','4500','Available');
UNLOCK TABLES;
