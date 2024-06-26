-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2024 at 08:51 AM
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
(3002, 'entac3002', 'Jhon Leo Welliam', 'Entac', 0, '2024-05-02', '09215119877', 'jdsajdoiahsdi@gmail.com', NULL, '', 'Active'),
(30001, 'welliam30001', 'Jhon Leo', 'Welliam', 22, '2002-05-12', '09096262852', 'gfdgdfg@gmail.com', 0.00, 'src/imported_img/PEOPLES PARK.png', 'Inactive');

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
(40002, '87654321', 'SAMPLE', 50.00, 'Fixed Amount', 20, 'Redeem on Transaction', 'Active'),
(40003, '154154', 'GRAND GAISANO SALE', 50.00, 'Percent', 20, 'Redeem on Product', 'Archived');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `l_datetime` datetime(6) NOT NULL DEFAULT current_timestamp(6),
  `l_staff` int(20) NOT NULL,
  `l_action` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`l_datetime`, `l_staff`, `l_action`) VALUES
('2024-06-14 05:16:20.540744', 10006, 'Joshua Teves (10006) added Joshua Espanillo (10007) as Cashier'),
('2024-06-14 05:17:03.468899', 10006, 'Joshua Teves (10006) updated Joshua Espanillo (10007) information'),
('2024-06-14 05:17:19.828638', 10006, 'Joshua Teves (10006) updated Joshua Espanillo (10007) information'),
('2024-06-14 05:17:39.660696', 10006, 'Joshua Teves (10006) updated Joshua Espanillo (10007) information'),
('2024-06-14 05:17:51.683860', 10006, 'Joshua Teves (10006) archived 10007 from users'),
('2024-06-14 05:22:02.909549', 10006, 'Joshua Teves (10006) added customer Jhon Leo Welliam (30001)'),
('2024-06-14 05:24:50.420083', 10006, 'Joshua Teves (10006) archived 30001 from customers'),
('2024-06-14 05:26:28.156487', 10006, 'Joshua Teves (10006) added discount GRAND GAISANO SALE (154154)'),
('2024-06-14 05:27:56.733432', 10006, 'Joshua Teves (10006) archived 40003 from discounts'),
('2024-06-14 05:32:34.421064', 10006, 'Joshua Teves (10006) added product dasasdas (45243543453)'),
('2024-06-14 05:34:12.877619', 10006, 'Joshua Teves (10006) archived 20008 from products');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `o_id` int(20) NOT NULL,
  `o_product` int(20) NOT NULL,
  `o_supplier` int(20) NOT NULL,
  `o_qty` int(20) NOT NULL,
  `o_total` double(20,2) NOT NULL,
  `o_orderedon` date NOT NULL DEFAULT current_timestamp(),
  `o_recieveon` date NOT NULL,
  `o_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`o_id`, `o_product`, `o_supplier`, `o_qty`, `o_total`, `o_orderedon`, `o_recieveon`, `o_status`) VALUES
(70001, 20004, 6001, 50, 2500.00, '2024-06-26', '2024-06-29', 'Recieved'),
(70003, 20005, 6001, 2, 60.00, '2024-06-26', '2024-06-26', 'Cancelled');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `p_id` int(20) NOT NULL,
  `p_supplier` int(20) NOT NULL,
  `p_mprice` double(20,2) NOT NULL,
  `p_ws` tinyint(1) NOT NULL DEFAULT 0,
  `p_wsprice` double(20,2) DEFAULT NULL,
  `p_wsitem` int(20) DEFAULT NULL,
  `p_barcode` varchar(50) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `p_qty` int(20) NOT NULL,
  `p_price` double(20,2) NOT NULL,
  `p_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`p_id`, `p_supplier`, `p_mprice`, `p_ws`, `p_wsprice`, `p_wsitem`, `p_barcode`, `p_name`, `p_qty`, `p_price`, `p_status`) VALUES
(20001, 6001, 35.00, 0, 0.00, 0, '213', 'AUDREY', 1, 50.00, 'Available'),
(20002, 6001, 35.00, 0, 0.00, 0, '214', 'ENTAC', 1, 50.00, 'Available'),
(20003, 6001, 50.00, 0, 0.00, 0, '215', 'WELLIAM', 50, 50.00, 'Available'),
(20004, 6001, 50.00, 1, 50.00, 3, '56564', 'AUDING', 50, 50.00, 'Available'),
(20005, 6001, 30.00, 0, 0.00, 0, '1561564', 'OHA', 50, 50.00, 'Available'),
(20006, 6001, 10.00, 0, 0.00, 0, '1541', 'fdf', 14, 15.00, 'Available'),
(20007, 6001, 9.00, 0, 0.00, 0, '21524', 'dsads', 10, 10.00, 'Available'),
(20008, 6001, 30.00, 0, 0.00, 0, '45243543453', 'dasasdas', 50, 50.00, 'Archived'),
(20009, 60001, 8.00, 0, 0.00, 0, '4806018605307', 'MYRA LOTION', 50, 10.00, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `s_id` int(20) NOT NULL,
  `s_name` varchar(100) NOT NULL,
  `s_address` varchar(100) NOT NULL,
  `s_contact` varchar(20) NOT NULL,
  `s_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`s_id`, `s_name`, `s_address`, `s_contact`, `s_status`) VALUES
(6001, 'ADM MANUFACTURING INC', 'Calajoan, Minglanilla, Cebu', '2158465468', 'Active'),
(60001, 'PEPSI COLA INC', 'Tulay, Minglanilla, Cebu', '09215119877', 'Archived');

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
(40000001, 10005, 3002, 50.00, '2024-05-26 21:09:44.000000'),
(40000021, 10005, NULL, 600.00, '2024-06-03 22:14:38.000000');

-- --------------------------------------------------------

--
-- Table structure for table `transactions_items`
--

CREATE TABLE `transactions_items` (
  `ti_id` int(20) NOT NULL,
  `ti_transaction` int(20) NOT NULL,
  `ti_product` int(20) NOT NULL,
  `ti_discount` int(20) DEFAULT NULL,
  `ti_price` double(20,2) NOT NULL,
  `ti_qty` int(20) NOT NULL,
  `ti_subtotal` double(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions_items`
--

INSERT INTO `transactions_items` (`ti_id`, `ti_transaction`, `ti_product`, `ti_discount`, `ti_price`, `ti_qty`, `ti_subtotal`) VALUES
(50000001, 40000001, 20001, 40002, 50.00, 1, 50.00),
(50000002, 40000001, 20001, NULL, 0.00, 1, 0.00),
(50000003, 40000001, 20001, NULL, 0.00, 1, 0.00),
(50000004, 40000001, 20003, NULL, 0.00, 1, 0.00);

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
(10005, 'opsima10005', 'Joshua', 'Opsima', 'shuamesina', 'opsima10005', 'src/imported_img/clge28k6b000gla08y5lan5l2_1.jpg', 'Administrator', 'Active'),
(10006, 'teves10006', 'Joshua', 'Teves', 'iloveyouvirus', 'Cw47lIZDE8W1U17HzYr+HK6FHYw4XkaOng8k1u1uv6M=', '', 'Administrator', 'Active'),
(10007, 'espanillo10007', 'Joshua', 'Espanillo', 'aljunohaha', 'aMmv4hNnORYbZrm6onbs2t7TDGxUcZs9hXaxivYfsec=', 'src/imported_img/express.jpg', 'Cashier', 'Archived');

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
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`o_id`),
  ADD KEY `fk_orderproduct` (`o_product`),
  ADD KEY `fk_ordersupplier` (`o_supplier`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `fk_supplier` (`p_supplier`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`s_id`);

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
  ADD KEY `fk_discount` (`ti_discount`);

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
  MODIFY `c_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30002;

--
-- AUTO_INCREMENT for table `discounts`
--
ALTER TABLE `discounts`
  MODIFY `d_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40004;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `o_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70004;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `p_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20010;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60002;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `t_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40000022;

--
-- AUTO_INCREMENT for table `transactions_items`
--
ALTER TABLE `transactions_items`
  MODIFY `ti_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50000005;

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
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orderproduct` FOREIGN KEY (`o_product`) REFERENCES `products` (`p_id`),
  ADD CONSTRAINT `fk_ordersupplier` FOREIGN KEY (`o_supplier`) REFERENCES `suppliers` (`s_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_supplier` FOREIGN KEY (`p_supplier`) REFERENCES `suppliers` (`s_id`);

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
  ADD CONSTRAINT `fk_discount` FOREIGN KEY (`ti_discount`) REFERENCES `discounts` (`d_id`),
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`ti_product`) REFERENCES `products` (`p_id`),
  ADD CONSTRAINT `fk_transaction` FOREIGN KEY (`ti_transaction`) REFERENCES `transactions` (`t_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
