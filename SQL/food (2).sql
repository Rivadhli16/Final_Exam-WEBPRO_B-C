-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2020 at 06:09 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food`
--

-- --------------------------------------------------------

--
-- Table structure for table `drinks`
--

CREATE TABLE `drinks` (
  `id` int(4) NOT NULL,
  `drinkname` varchar(100) NOT NULL,
  `releasedate` varchar(12) NOT NULL,
  `category` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` int(4) NOT NULL,
  `foodname` varchar(100) NOT NULL,
  `releasedate` varchar(12) NOT NULL,
  `category` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `foodname`, `releasedate`, `category`, `description`) VALUES
(10, 'chicken Soto', '12-02-2000', 'Main Course', 'This yellow chicken soup tastes fresh. The filling of shredded chicken and vegetables makes this soup filling to be enjoyed with warm rice. Sluurp, delicious!'),
(11, 'Goat satay', '30-03-2020', 'Main Course', 'Goat satay is a kind of satay food made from mutton. The mutton meat is satay (skewered with bamboo shaped like a rather large stick) and seasoned with spices and herbs, then grilled. The presentation is served with thinly sliced ââcabbage, tomato and shallots then topped with soy sauce and a sprinkling of pepper.'),
(12, 'Meatball', '20-04-2020', 'Lunch', ' Bakso or baso is a type of meatball commonly found in Indonesian cuisine. Meatballs are generally made from a mixture of ground beef and tapioca flour, but there are also meatballs made from chicken, fish, or shrimp and even buffalo meat. In its presentation, meatballs are generally served hot with clear beef broth, mixed with noodles, vermicelli, bean sprouts, tofu, sometimes eggs and sprinkled with fried onions and celery.'),
(13, 'Coto makassar', '29-05-2020', 'Lunch', 'Coto makassar or coto mangkasara is a traditional food from Makassar, South Sulawesi. This food is made from beef offal that has been boiled for a long time. This beef offal stew is then sliced ââand then seasoned with specially formulated spices. Coto is served in a bowl and enjoyed with ketupat and buras, which is a type of diamond wrapped in banana leaves.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drinks`
--
ALTER TABLE `drinks`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
