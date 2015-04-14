--
-- Table structure for table `Datasource`
--

CREATE TABLE `Datasource` (
  `did` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Index`
--

CREATE TABLE `Index` (
`termId` int(11) NOT NULL,
  `dbTerm` varchar(45) DEFAULT NULL,
  `databaseName` varchar(45) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL,
  `columnName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=949 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Index`
--
ALTER TABLE `Index`
 ADD PRIMARY KEY (`termId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Index`
--
ALTER TABLE `Index`
MODIFY `termId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=949;
