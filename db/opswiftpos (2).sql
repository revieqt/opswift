-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 06:59 AM
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
-- Database: `opswiftpos`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `com_logo` varchar(150) NOT NULL,
  `com_name` varchar(100) NOT NULL,
  `com_address` varchar(150) NOT NULL,
  `com_tin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `c_id` int(20) NOT NULL,
  `c_code` varchar(50) NOT NULL,
  `c_fname` varchar(50) NOT NULL,
  `c_lname` varchar(50) NOT NULL,
  `c_age` int(20) NOT NULL,
  `c_bdate` date NOT NULL,
  `c_num` varchar(20) NOT NULL,
  `c_email` varchar(50) NOT NULL,
  `c_points` double(20,2) DEFAULT 0.00,
  `c_img` varchar(200) NOT NULL,
  `c_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`c_id`, `c_code`, `c_fname`, `c_lname`, `c_age`, `c_bdate`, `c_num`, `c_email`, `c_points`, `c_img`, `c_status`) VALUES
(3001, '', 'Guest', 'Guest', 0, '2024-04-22', '0', 'N/A', 0.00, 'src/imported_img/mastery.PNG', 'Active'),
(3002, 'entac3002', 'Jhon Leo Welliam', 'Entac', 0, '2024-05-02', '09215119877', 'jdsajdoiahsdi@gmail.com', NULL, '', 'Archived'),
(3003, 'welliam3003', 'Jhon', 'Welliam', 0, '2024-05-12', '09215119875', 'dsadsd@gmail.com', 0.00, '', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `discounts`
--

CREATE TABLE `discounts` (
  `d_id` int(20) NOT NULL,
  `d_code` varchar(50) NOT NULL,
  `d_name` varchar(50) NOT NULL,
  `d_amount` double(20,2) NOT NULL,
  `d_type` varchar(20) NOT NULL,
  `d_redeemable` int(20) NOT NULL,
  `d_redeemabletype` varchar(50) NOT NULL,
  `d_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `discounts`
--

INSERT INTO `discounts` (`d_id`, `d_code`, `d_name`, `d_amount`, `d_type`, `d_redeemable`, `d_redeemabletype`, `d_status`) VALUES
(40001, '123456789', 'SUPERMEAL DISOUNT', 50.00, 'Percent', 20, 'Redeem on Product', 'Active'),
(40002, '87654321', 'SAMPLE', 50.00, 'Fixed Amount', 20, 'Redeem on Transaction', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `l_datetime` datetime(6) NOT NULL DEFAULT current_timestamp(6),
  `l_staff` int(20) NOT NULL,
  `l_action` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `p_id` int(20) NOT NULL,
  `p_barcode` varchar(50) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `p_qty` int(20) NOT NULL,
  `p_price` double(20,2) NOT NULL,
  `p_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`p_id`, `p_barcode`, `p_name`, `p_qty`, `p_price`, `p_status`) VALUES
(2003, '4806515162709', 'ALCO PLUS ISOPROPYL ALCOHOL', 40, 151.75, 'Available'),
(2004, '4806530454483', 'DONT BE SALTY', 45, 300.25, 'Available'),
(2006, '4803748115526', 'PERSONAL COLLECTION FOR MEN ACTIVE', 47, 200.99, 'Available'),
(2007, '4809012371001', 'MITSUKA BRAND THUMB TACKS', 24, 15.00, 'Available'),
(2008, '4800361413480', 'MILO SACHET DRINK', 49, 15.00, 'Available'),
(2009, '4894532462773', 'WATSONS SMOOTHING TREATMENT SHAMPOO', 46, 149.99, 'Archived'),
(2010, '4806018403378', 'Lemon Square Signatue Cupcakes', 10, 1000.00, 'Available'),
(2011, '1561651561', 'Tumbler', 50, 50.00, 'Archived'),
(2012, 'entac10006', 'LEO WELLIAM ', 50, 50.00, 'Available'),
(2013, 'binauro10007', 'JOSWA', 49, 50.00, 'Available'),
(2014, 'dsadasdasds', 'JOSHUIAd', 50, 50.00, 'Available'),
(2015, 'gfdgdfgdf', 'bgfdgdfsgdf', 50, 50.00, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `t_id` int(20) NOT NULL,
  `t_staff` int(20) NOT NULL,
  `t_customer` int(20) DEFAULT NULL,
  `t_total` double(20,2) NOT NULL,
  `t_datetime` datetime(6) NOT NULL DEFAULT current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`t_id`, `t_staff`, `t_customer`, `t_total`, `t_datetime`) VALUES
(40000001, 10005, 3002, 50.00, '2024-05-26 21:09:44.000000');

-- --------------------------------------------------------

--
-- Table structure for table `transactions_items`
--

CREATE TABLE `transactions_items` (
  `ti_id` int(20) NOT NULL,
  `ti_transaction` int(20) NOT NULL,
  `ti_product` int(20) NOT NULL,
  `t_discount` int(20) NOT NULL,
  `ti_price` double(20,2) NOT NULL,
  `ti_qty` int(20) NOT NULL,
  `ti_subtotal` double(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(20) NOT NULL,
  `u_code` varchar(50) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_img` varchar(100) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `u_code`, `u_fname`, `u_lname`, `u_username`, `u_password`, `u_img`, `u_type`, `u_status`) VALUES
(10005, 'opsima10005', 'Joshua', 'Opsima', 'shuamesina', 'opsima10005', 'src/imported_img/bb.jpg', 'Administrator', 'Active'),
(10006, 'entac10006', 'Jhon Leo Welliam', 'Entac', 'entwakkkk', 'entac10006', 'src/imported_img/mastery.PNG', 'Administrator', 'Archived'),
(10007, 'binauro10007', 'Joshua', 'Binauro', 'ohahahahhahaha', 'binauro10007', 'src/imported_img/bb.jpg', 'Cashier', 'Active'),
(10008, 'opsima10008', 'Monalisa', 'Opsima', 'jouiemona', 'opsima10008', 'src/imported_img/test.png', 'Administrator', 'Active'),
(10009, 'mesina10009', 'Joshua', 'Mesina', '60sdasdasd', 'mesina10009', '', 'Accountant', 'Active'),
(10010, 'anisem10010', 'JOHUSA', 'ANISEM', 'OSHAHHAHAH', 'anisem10010', '', 'Administrator', 'Archived'),
(10011, 'dsadasdasd10011', 'Auduhsajoida', 'DSADASDASD', 'DSADASDASDAS', 'dsadasdasd10011', '', 'Accountant', 'Active'),
(10012, 'dsdasdsa10012', 'SCSADFSADAS', 'DSDASDSA', 'DSADSADSADA', 'dsdasdsa10012', 'src/imported_img/Untitled.png', 'Cashier', 'Active'),
(10013, 'fdsgfdsgfds10013', '6gfdgfdsg', 'Fdsgfdsgfds', 'gdfgdfsgfdsgdf', 'fdsgfdsgfds10013', 'src/imported_img/Untitled.png', 'Accountant', 'Active'),
(10014, 'dasdsdsdas10014', 'Dsadasdsadasd', 'Dasdsdsdas', 'dfdsfsdfsd', 'dasdsdsdas10014', '', 'Administrator', 'Active'),
(10015, 'sadsadsadsa10015', 'Dsadsadsad', 'Sadsadsadsa', 'dasdsadsadasdsadsa', 'sadsadsadsa10015', 'src/imported_img/mastery.PNG', 'Administrator', 'Active'),
(10016, 'hfgdhfdghfdg10016', 'Htrghftghfdghfgd', 'Hfgdhfdghfdg', 'hfdghfdghfgdhfdgh', 'hfgdhfdghfdg10016', '', 'Administrator', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `discounts`
--
ALTER TABLE `discounts`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD KEY `fk_stafflogs` (`l_staff`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `fk_staff` (`t_staff`),
  ADD KEY `fk_customer` (`t_customer`);

--
-- Indexes for table `transactions_items`
--
ALTER TABLE `transactions_items`
  ADD PRIMARY KEY (`ti_id`),
  ADD KEY `fk_transaction` (`ti_transaction`),
  ADD KEY `fk_product` (`ti_product`),
  ADD KEY `fk_discount` (`t_discount`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `c_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3004;

--
-- AUTO_INCREMENT for table `discounts`
--
ALTER TABLE `discounts`
  MODIFY `d_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40003;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `p_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2016;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `t_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40000020;

--
-- AUTO_INCREMENT for table `transactions_items`
--
ALTER TABLE `transactions_items`
  MODIFY `ti_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10017;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_stafflogs` FOREIGN KEY (`l_staff`) REFERENCES `users` (`u_id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `fk_customer` FOREIGN KEY (`t_customer`) REFERENCES `customers` (`c_id`),
  ADD CONSTRAINT `fk_staff` FOREIGN KEY (`t_staff`) REFERENCES `users` (`u_id`);

--
-- Constraints for table `transactions_items`
--
ALTER TABLE `transactions_items`
  ADD CONSTRAINT `fk_discount` FOREIGN KEY (`t_discount`) REFERENCES `discounts` (`d_id`),
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`ti_product`) REFERENCES `products` (`p_id`),
  ADD CONSTRAINT `fk_transaction` FOREIGN KEY (`ti_transaction`) REFERENCES `transactions` (`t_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
