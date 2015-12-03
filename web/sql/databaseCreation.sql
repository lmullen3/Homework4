/* Copyright (c) 2015 Maddie Chili and Lawrence Mullen */

USE app02lawrence;
CREATE DATABASE IF NOT EXISTS app02lawrence;
CREATE TABLE `User` (
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `BookTitle` varchar(50) NOT NULL DEFAULT '',
  `DueDate` varchar(45) DEFAULT NULL,
  `Overdue` varchar(45) NOT NULL,
  PRIMARY KEY (`BookTitle`)
); 
