-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2024 at 05:24 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springjdbc`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comment`
--

CREATE TABLE `tbl_comment` (
  `commentId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `postId` bigint(20) DEFAULT NULL,
  `comment` text DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `tbl_comment`
--

INSERT INTO `tbl_comment` (`commentId`, `userId`, `postId`, `comment`, `createdAt`) VALUES
(1, 1, 1, 'Great post!', '2024-10-27 09:13:39'),
(2, 2, 1, 'Thanks for sharing!', '2024-10-27 09:13:39'),
(3, 3, 1, 'Interesting perspective.', '2024-10-27 09:13:39'),
(4, 4, 2, 'I learned a lot from this.', '2024-10-27 09:13:39'),
(5, 5, 2, 'Well explained!', '2024-10-27 09:13:39'),
(6, 6, 2, 'Can you elaborate more on this topic?', '2024-10-27 09:13:39'),
(7, 7, 3, 'I completely agree with your point.', '2024-10-27 09:13:39'),
(8, 8, 3, 'This is very helpful, thank you!', '2024-10-27 09:13:39'),
(9, 9, 4, 'Awesome content!', '2024-10-27 09:13:39'),
(10, 10, 4, 'What an insightful article.', '2024-10-27 09:13:39'),
(11, 11, 5, 'I love this!', '2024-10-27 09:13:39'),
(12, 12, 5, 'So much useful information.', '2024-10-27 09:13:39'),
(13, 13, 6, 'Thanks for the tips!', '2024-10-27 09:13:39'),
(14, 14, 6, 'Looking forward to more posts like this.', '2024-10-27 09:13:39'),
(15, 15, 7, 'This changed my perspective.', '2024-10-27 09:13:39'),
(16, 16, 7, 'Fantastic read!', '2024-10-27 09:13:39'),
(17, 17, 8, 'I appreciate your thoughts on this.', '2024-10-27 09:13:39'),
(18, 18, 8, 'Keep up the good work!', '2024-10-27 09:13:39'),
(19, 19, 1, 'Looking forward to your next post!', '2024-10-27 09:13:39'),
(20, 20, 2, 'You always write so well.', '2024-10-27 09:13:39'),
(21, 21, 3, 'Very informative, thanks!', '2024-10-27 09:13:39'),
(22, 22, 4, 'I love your writing style!', '2024-10-27 09:13:39'),
(23, 23, 5, 'This is so relatable.', '2024-10-27 09:13:39'),
(24, 24, 6, 'Well done!', '2024-10-27 09:13:39'),
(25, 25, 7, 'You hit the nail on the head.', '2024-10-27 09:13:39'),
(26, 26, 8, 'Excellent post!', '2024-10-27 09:13:39'),
(27, 27, 1, 'You have a talent for this.', '2024-10-27 09:13:39'),
(28, 28, 2, 'This was a great read!', '2024-10-27 09:13:39'),
(29, 29, 3, 'Very thought-provoking.', '2024-10-27 09:13:39'),
(30, 30, 4, 'I’m sharing this with my friends!', '2024-10-27 09:13:39'),
(31, 31, 5, 'Can’t wait to read more!', '2024-10-27 09:13:39'),
(32, 32, 6, 'Very well written.', '2024-10-27 09:13:39'),
(33, 33, 7, 'Your insights are always appreciated.', '2024-10-27 09:13:39'),
(34, 34, 8, 'Great to see your work again!', '2024-10-27 09:13:39'),
(35, 35, 1, 'A breath of fresh air.', '2024-10-27 09:13:39'),
(36, 36, 2, 'I love how you write!', '2024-10-27 09:13:39'),
(37, 37, 3, 'This is just what I needed to read.', '2024-10-27 09:13:39'),
(38, 38, 4, 'Thank you for sharing your thoughts.', '2024-10-27 09:13:39'),
(39, 39, 5, 'You make this topic so interesting.', '2024-10-27 09:13:39'),
(40, 40, 6, 'Fantastic insights!', '2024-10-27 09:13:39'),
(41, 41, 7, 'This post was a delight to read.', '2024-10-27 09:13:39'),
(42, 42, 8, 'Your passion shines through your writing.', '2024-10-27 09:13:39'),
(43, 43, 1, 'You inspire me to think differently.', '2024-10-27 09:13:39'),
(44, 44, 2, 'I can’t agree more!', '2024-10-27 09:13:39'),
(45, 45, 3, 'Such a wonderful post!', '2024-10-27 09:13:39'),
(46, 46, 4, 'I learned something new today.', '2024-10-27 09:13:39'),
(47, 47, 5, 'This is why I follow you.', '2024-10-27 09:13:39'),
(48, 48, 6, 'You have a gift!', '2024-10-27 09:13:39'),
(49, 49, 7, 'Great job!', '2024-10-27 09:13:39'),
(50, 50, 8, 'Your work is always worth reading.', '2024-10-27 09:13:39'),
(51, 51, 7, 'Hi, long time no see', '2024-10-27 15:26:54'),
(58, 17, 7, 'test2', '2024-10-27 14:11:36'),
(59, 44, 7, 'This is fantastic', '2024-10-27 14:13:14'),
(60, 44, 7, 'This is fantastic!!!!!', '2024-10-27 14:14:46');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE `tbl_employee` (
  `id` bigint(20) NOT NULL,
  `firstName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post`
--

CREATE TABLE `tbl_post` (
  `postId` bigint(20) NOT NULL,
  `title` text DEFAULT NULL,
  `content` text DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `tbl_post`
--

INSERT INTO `tbl_post` (`postId`, `title`, `content`, `createdAt`, `status`) VALUES
(1, 'First Post', 'This is the content of the first post', '2024-10-24 08:00:22', 1),
(2, 'Second Post', 'This is the content of the second post', '2024-10-24 08:00:22', 1),
(3, 'Third Post', 'This is the content of the third post', '2024-10-24 08:00:22', 1),
(4, 'Fourth Post', 'This is the content of the fourth post', '2024-10-24 08:00:22', 1),
(5, 'Fifth Post', 'This is the content of the fifth post', '2024-10-24 08:00:22', 1),
(6, 'Sixth Post', 'This is the content of the sixth post', '2024-10-24 08:00:22', 1),
(7, 'Seventh Post', 'This is the content of the seventh post', '2024-10-25 03:10:42', 1),
(8, 'Eighth Post', 'This is the content of the eighth post', '2024-10-24 08:00:22', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `userId` bigint(20) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `name` text DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`userId`, `username`, `name`, `status`) VALUES
(1, 'user1', 'John Doe', 1),
(2, 'user2', 'Jane Smith', 1),
(3, 'user3', 'Emily Johnson', 1),
(4, 'user4', 'Michael Brown', 1),
(5, 'user5', 'Chris Davis', 1),
(6, 'user6', 'Sarah Miller', 1),
(7, 'user7', 'James Wilson', 1),
(8, 'user8', 'Anna Moore', 1),
(9, 'user9', 'David Clark', 1),
(10, 'user10', 'Laura Rodriguez', 1),
(11, 'user11', 'Robert Lewis', 1),
(12, 'user12', 'Jessica Walker', 1),
(13, 'user13', 'Daniel Hall', 1),
(14, 'user14', 'Maria Allen', 1),
(15, 'user15', 'Mark Young', 1),
(16, 'user16', 'Lisa Hernandez', 1),
(17, 'user17', 'Kevin King', 1),
(18, 'user18', 'Nancy Wright', 1),
(19, 'user19', 'Richard Lopez', 1),
(20, 'user20', 'Megan Hill', 1),
(21, 'user21', 'Charles Scott', 1),
(22, 'user22', 'Katherine Green', 1),
(23, 'user23', 'Paul Adams', 1),
(24, 'user24', 'Linda Baker', 1),
(25, 'user25', 'Peter Nelson', 1),
(26, 'user26', 'Kimberly Carter', 1),
(27, 'user27', 'Joseph Mitchell', 1),
(28, 'user28', 'Barbara Perez', 1),
(29, 'user29', 'Edward Roberts', 1),
(30, 'user30', 'Margaret Turner', 1),
(31, 'user31', 'Brian Phillips', 1),
(32, 'user32', 'Deborah Campbell', 1),
(33, 'user33', 'Eric Parker', 1),
(34, 'user34', 'Samantha Evans', 1),
(35, 'user35', 'George Edwards', 1),
(36, 'user36', 'Amanda Collins', 1),
(37, 'user37', 'Frank Stewart', 1),
(38, 'user38', 'Carol Sanchez', 1),
(39, 'user39', 'Harry Morris', 1),
(40, 'user40', 'Rebecca Murphy', 1),
(41, 'user41', 'Jerry Peterson', 1),
(42, 'user42', 'Stephanie Cook', 1),
(43, 'user43', 'Arthur Rogers', 1),
(44, 'user44', 'Diana Reed', 1),
(45, 'user45', 'Patrick Morgan', 1),
(46, 'user46', 'Chloe Bell', 1),
(47, 'user47', 'Lawrence Cox', 1),
(48, 'user48', 'Rachel Martinez', 1),
(49, 'user49', 'Benjamin Wood', 1),
(50, 'user50', 'Sophia Cooper', 1),
(51, 'user51', 'test user', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_comment`
--
ALTER TABLE `tbl_comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `postId` (`postId`),
  ADD KEY `constraint_name` (`userId`);

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_post`
--
ALTER TABLE `tbl_post`
  ADD PRIMARY KEY (`postId`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_comment`
--
ALTER TABLE `tbl_comment`
  MODIFY `commentId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_post`
--
ALTER TABLE `tbl_post`
  MODIFY `postId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `userId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_comment`
--
ALTER TABLE `tbl_comment`
  ADD CONSTRAINT `constraint_name` FOREIGN KEY (`userId`) REFERENCES `tbl_user` (`userId`),
  ADD CONSTRAINT `tbl_comment_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `tbl_post` (`postId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
