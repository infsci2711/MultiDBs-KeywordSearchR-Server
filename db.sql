CREATE DATABASE  IF NOT EXISTS `keywordsearchr` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `keywordsearchr`;

--
-- Table structure for table `Datasource`
--

CREATE TABLE `Datasource` (
  `did` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Index` (
  `termId` int(11) NOT NULL AUTO_INCREMENT,
  `dbTerm` varchar(45) DEFAULT NULL,
  `databaseName` varchar(45) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL,
  `columnName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`termId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE USER 'searchrUser'@'localhost' IDENTIFIED BY 'searchrUser';
grant all privileges on `keywordsearchr`.* to 'searchrUser'@'localhost';

CREATE USER 'searchrUser'@'%' IDENTIFIED BY 'searchrUser';
grant all privileges on `keywordsearchr`.* to 'searchrUser'@'%';

FLUSH PRIVILEGES;