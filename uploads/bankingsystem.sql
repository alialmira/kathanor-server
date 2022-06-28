-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2019 at 01:38 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `accholder`
--

CREATE TABLE `accholder` (
  `accid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accholder`
--

INSERT INTO `accholder` (`accid`, `userid`) VALUES
(1, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `telleracc`
--

CREATE TABLE `telleracc` (
  `tellid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `telleracc`
--

INSERT INTO `telleracc` (`tellid`, `userid`) VALUES
(1, 1),
(2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `trans`
--

CREATE TABLE `trans` (
  `transid` int(11) NOT NULL,
  `accid` int(11) DEFAULT NULL,
  `deposit` int(11) DEFAULT NULL,
  `withdraw` int(11) DEFAULT NULL,
  `tellid` int(11) DEFAULT NULL,
  `datecreate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trans`
--

INSERT INTO `trans` (`transid`, `accid`, `deposit`, `withdraw`, `tellid`, `datecreate`, `balance`) VALUES
(19, 1, 0, 400, 1, '2019-12-09 11:40:44', 100),
(20, 1, 500, 0, 1, '2019-12-08 09:23:04', 600),
(22, 1, 0, 500, 2, '2019-12-09 10:07:06', 100),
(23, 1, 500, 0, 1, '2019-12-09 10:08:51', 600),
(24, 1, 0, 100, 1, '2019-12-09 10:09:23', 500),
(25, 1, 0, 400, 1, '2019-12-09 10:09:40', 100),
(26, 1, 500, 0, 1, '2019-12-09 10:09:47', 600);

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

CREATE TABLE `useraccount` (
  `userid` int(11) NOT NULL,
  `username` varchar(220) DEFAULT NULL,
  `userpass` varchar(220) DEFAULT NULL,
  `fullname` varchar(220) DEFAULT NULL,
  `email` varchar(220) DEFAULT NULL,
  `address` varchar(220) NOT NULL DEFAULT 'NULL',
  `contact` varchar(220) NOT NULL DEFAULT 'NULL',
  `ustatus` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useraccount`
--

INSERT INTO `useraccount` (`userid`, `username`, `userpass`, `fullname`, `email`, `address`, `contact`, `ustatus`) VALUES
(1, 'hanna', 'amer', 'hanna marohomsalic', 'hanna.marohomsalic@gmail.com', 'MSU marawi city', '09488092423', 'Active'),
(2, 'amer', 'hanna', 'Amer Sarangani', 'amer.sarangani@gmail.com', 'Bangon Marawi City', '09482030472', 'Active'),
(3, 'dwayne', 'johnson', 'Dwayne Johnson', 'the.rocks@gmail.com', 'California, USA', '09482903002', 'Active'),
(4, 'maria', 'hill', 'maria hill', 'maria.hill@gmail.com', 'New York City', '09192030041', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accholder`
--
ALTER TABLE `accholder`
  ADD PRIMARY KEY (`accid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `telleracc`
--
ALTER TABLE `telleracc`
  ADD PRIMARY KEY (`tellid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `trans`
--
ALTER TABLE `trans`
  ADD PRIMARY KEY (`transid`),
  ADD KEY `accid` (`accid`),
  ADD KEY `tellid` (`tellid`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accholder`
--
ALTER TABLE `accholder`
  MODIFY `accid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `telleracc`
--
ALTER TABLE `telleracc`
  MODIFY `tellid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trans`
--
ALTER TABLE `trans`
  MODIFY `transid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `useraccount`
--
ALTER TABLE `useraccount`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accholder`
--
ALTER TABLE `accholder`
  ADD CONSTRAINT `accholder_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `useraccount` (`userid`);

--
-- Constraints for table `telleracc`
--
ALTER TABLE `telleracc`
  ADD CONSTRAINT `telleracc_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `useraccount` (`userid`);

--
-- Constraints for table `trans`
--
ALTER TABLE `trans`
  ADD CONSTRAINT `trans_ibfk_1` FOREIGN KEY (`accid`) REFERENCES `accholder` (`accid`),
  ADD CONSTRAINT `trans_ibfk_2` FOREIGN KEY (`tellid`) REFERENCES `telleracc` (`tellid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
