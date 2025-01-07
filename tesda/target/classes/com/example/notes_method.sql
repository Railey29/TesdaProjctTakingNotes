-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2025 at 02:54 AM
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
-- Database: `takingnotes_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `notes_method`
--

CREATE TABLE `notes_method` (
  `id` int(11) NOT NULL,
  `add_notes` text NOT NULL,
  `set_date` varchar(50) NOT NULL,
  `title_notes` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notes_method`
--

INSERT INTO `notes_method` (`id`, `add_notes`, `set_date`, `title_notes`, `created_at`) VALUES
(12, 'NEW ME!', '2025-01-01', 'NEW YEAR', '2025-01-05 17:28:49'),
(13, 'I\'M DEVELOPER NOW!', '2026-02-02', 'NEW YEAR 2026', '2025-01-05 17:48:36');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notes_method`
--
ALTER TABLE `notes_method`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notes_method`
--
ALTER TABLE `notes_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
