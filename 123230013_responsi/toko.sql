-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2025 at 07:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `datatoko`
--

CREATE TABLE `datatoko` (
  `nama` varchar(77) NOT NULL,
  `barang` varchar(77) NOT NULL,
  `harga` int(22) NOT NULL,
  `cicilan` int(22) NOT NULL,
  `bunga` int(22) NOT NULL,
  `angsuran` int(22) NOT NULL,
  `total` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datatoko`
--

INSERT INTO `datatoko` (`nama`, `barang`, `harga`, `cicilan`, `bunga`, `angsuran`, `total`) VALUES
('Adits', 'Kulkas', 48000000, 6, 72000, 872000, 5232000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datatoko`
--
ALTER TABLE `datatoko`
  ADD PRIMARY KEY (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
