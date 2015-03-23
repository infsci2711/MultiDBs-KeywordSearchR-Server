-- phpMyAdmin SQL Dump
-- version 4.2.5
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Mar 23, 2015 at 05:13 PM
-- Server version: 5.5.38
-- PHP Version: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `infsci2711_tutorial`
--
CREATE DATABASE IF NOT EXISTS `infsci2711_tutorial` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `infsci2711_tutorial`;

-- --------------------------------------------------------

--
-- Table structure for table `Index`
--

DROP TABLE IF EXISTS `Index`;
CREATE TABLE `Index` (
`termId` int(11) NOT NULL,
  `dbTerm` varchar(45) DEFAULT NULL,
  `databaseName` varchar(45) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `Index`
--

INSERT INTO `Index` (`termId`, `dbTerm`, `databaseName`, `tableName`) VALUES
(1, 'info', 'info', 'info'),
(2, 'info', 'info', 'info'),
(3, 'info', 'info', 'info'),
(4, 'info', 'info', 'info'),
(5, 'info', 'info', 'info'),
(6, 'info', 'info', 'info'),
(7, 'info', 'info', 'info'),
(8, 'info', 'info', 'info'),
(9, 'INFO', 'INFO', 'INFO'),
(10, 'INF', 'INF', 'INF'),
(11, 'test', 'test', 'test'),
(12, 'web', 'application', 'with'),
(13, 'null', 'is', 'INF'),
(14, 'aa', 'aa', 'aa'),
(15, 'Wen', 'infsci2711_tutorial', 'Person'),
(16, 'a', 'a', 'a'),
(17, 'zhang', 'infsci2711_tutorial', 'Person'),
(18, 'Index', 'Index', 'Index'),
(19, 'Person', 'Person', 'Person');

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person` (
`id` int(11) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`id`, `firstName`, `lastName`) VALUES
(1, 'Wen', 'Zhang'),
(3, 'Can', 'Pan'),
(4, 'Albert', 'Gresham'),
(5, 'Raymond', 'Albert'),
(6, 'Edward', 'Louis'),
(7, 'info', 'info');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Index`
--
ALTER TABLE `Index`
 ADD PRIMARY KEY (`termId`);

--
-- Indexes for table `Person`
--
ALTER TABLE `Person`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Index`
--
ALTER TABLE `Index`
MODIFY `termId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `Person`
--
ALTER TABLE `Person`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
