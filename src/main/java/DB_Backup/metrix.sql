-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2020 at 04:44 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `metrix`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `logDate` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `uid`, `logDate`) VALUES
(1, 13, '2020-05-06'),
(2, 13, '2020-05-06'),
(3, 13, '2020-05-06'),
(4, 13, '2020-05-06'),
(5, 13, '2020-05-06'),
(6, 13, '2020-05-06'),
(7, 13, '2020-05-07'),
(8, 14, '2020-05-07'),
(9, 13, '2020-05-07'),
(10, 13, '2020-05-07'),
(11, 15, '2020-05-07'),
(12, 14, '2020-05-07'),
(13, 14, '2020-05-07'),
(14, 14, '2020-05-07'),
(15, 14, '2020-05-07'),
(16, 14, '2020-05-07'),
(17, 14, '2020-05-07'),
(18, 14, '2020-05-07'),
(19, 14, '2020-05-07'),
(20, 14, '2020-05-07'),
(21, 14, '2020-05-07'),
(22, 14, '2020-05-07'),
(23, 14, '2020-05-07'),
(24, 14, '2020-05-07'),
(25, 14, '2020-05-07'),
(26, 14, '2020-05-07'),
(27, 14, '2020-05-07'),
(28, 14, '2020-05-07'),
(29, 14, '2020-05-07'),
(30, 14, '2020-05-07'),
(31, 14, '2020-05-07'),
(32, 14, '2020-05-07'),
(33, 14, '2020-05-07'),
(34, 14, '2020-05-07'),
(35, 14, '2020-05-07'),
(36, 14, '2020-05-07'),
(37, 14, '2020-05-07'),
(38, 14, '2020-05-07'),
(39, 14, '2020-05-07'),
(40, 14, '2020-05-07'),
(41, 14, '2020-05-07'),
(42, 14, '2020-05-07'),
(43, 14, '2020-05-07'),
(44, 19, '2020-05-08'),
(45, 19, '2020-05-08'),
(46, 19, '2020-05-08'),
(47, 13, '2020-05-08'),
(48, 19, '2020-05-08'),
(49, 19, '2020-05-08'),
(50, 19, '2020-05-08'),
(51, 19, '2020-05-08'),
(52, 19, '2020-05-08'),
(53, 19, '2020-05-08'),
(54, 19, '2020-05-08'),
(55, 14, '2020-05-08'),
(56, 19, '2020-05-08'),
(57, 19, '2020-05-08'),
(58, 19, '2020-05-08'),
(59, 19, '2020-05-08'),
(60, 19, '2020-05-08'),
(61, 19, '2020-05-08'),
(62, 19, '2020-05-08'),
(63, 19, '2020-05-08'),
(64, 19, '2020-05-08'),
(65, 14, '2020-05-08'),
(66, 19, '2020-05-08'),
(67, 19, '2020-05-08'),
(68, 19, '2020-05-08'),
(69, 19, '2020-05-08'),
(70, 14, '2020-05-08'),
(71, 20, '2020-05-08'),
(72, 14, '2020-05-08'),
(73, 12, '2020-05-08'),
(74, 14, '2020-05-08'),
(75, 19, '2020-05-08'),
(76, 14, '2020-05-08'),
(77, 14, '2020-05-08'),
(78, 14, '2020-05-09'),
(79, 19, '2020-05-09'),
(80, 14, '2020-05-09'),
(81, 19, '2020-05-09'),
(82, 19, '2020-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `fname` varchar(200) COLLATE utf8_bin NOT NULL,
  `mname` varchar(200) COLLATE utf8_bin NOT NULL,
  `lname` varchar(200) COLLATE utf8_bin NOT NULL,
  `address` varchar(200) COLLATE utf8_bin NOT NULL,
  `email` varchar(200) COLLATE utf8_bin NOT NULL,
  `password` varchar(200) COLLATE utf8_bin NOT NULL,
  `joindate` date DEFAULT NULL,
  `lastupdated` date DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1,
  `isadmin` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `fname`, `mname`, `lname`, `address`, `email`, `password`, `joindate`, `lastupdated`, `status`, `isadmin`) VALUES
(11, 'Anil', 'anil', 'anil', 'a', 'a@aaa.c', 'password!!', '2020-05-05', NULL, 1, 0),
(12, 'Ram', 'parsad', 'r', 'r', 'r@r.com', 'password!!', '2020-05-06', NULL, 1, 0),
(13, 'ssss', 'ssss', 'sss', 's', 's@ss.com', 'password!!', '2020-05-06', '2020-05-06', 1, 0),
(14, 'Admin', 'Unknown', 'Admin', 'Kathmandu', 'admin@admin.com', 'admin', '2020-05-06', '2020-05-07', 1, 1),
(15, 'Sameer', 'md', 'khan', 'KTM', 'md@md.com', 'password!!', '2020-05-07', '2020-05-07', 1, 0),
(17, 'test', 'test', 'test', 'test', 't@t.c', 't', '2020-05-07', NULL, 1, 1),
(18, 'Harilal', 'Pd.', 'Bhattrai', 'Kathmandu', 'harilal@gmail.com', '123', '2020-05-07', NULL, 1, 0),
(19, 'Anil', 'Parsad', 'Poudyal', 'Kathmandu', 'anil@anil.com', 'password!!', '2020-05-08', NULL, 1, 0),
(20, 'Anil', 'Parsad', 'Poudyal', 'Checkpost', 'anil@gmail.com', 'password!!', '2020-05-08', NULL, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
