CREATE DATABASE  IF NOT EXISTS `keywordsearchr` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `keywordsearchr`;

--
-- Table structure for table `Datasource`
--

CREATE TABLE `Datasource` (
  `did` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Index`
--

CREATE TABLE `Index` (
  `termId` int(11) NOT NULL AUTO_INCREMENT,
  `dbTerm` varchar(45) DEFAULT NULL,
  `databaseName` varchar(45) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL,
  `columnName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`termId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE USER 'keywordsearchrUser'@'localhost' IDENTIFIED BY 'keywordsearchrUser';
grant all privileges on `keywordsearchr`.* to 'keywordsearchrUser'@'localhost';

CREATE USER 'keywordsearchrUser'@'%' IDENTIFIED BY 'keywordsearchrUser';
grant all privileges on `keywordsearchr`.* to 'keywordsearchrUser'@'%';

FLUSH PRIVILEGES;