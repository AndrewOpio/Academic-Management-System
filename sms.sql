-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2021 at 10:11 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new_sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_name`) VALUES
(1, 'P1'),
(2, 'P2'),
(3, 'P3'),
(4, 'P4'),
(5, 'P5'),
(6, 'P6'),
(7, 'P7');

-- --------------------------------------------------------

--
-- Table structure for table `class-subject`
--

CREATE TABLE `class-subject` (
  `class_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class-subject`
--

INSERT INTO `class-subject` (`class_id`, `subject_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(6, 1),
(6, 2),
(6, 3),
(6, 4),
(7, 1),
(7, 2),
(7, 3),
(7, 4),
(1, 5),
(1, 6),
(2, 5),
(2, 6),
(3, 5),
(3, 6),
(4, 7),
(5, 7),
(6, 7),
(7, 7);

-- --------------------------------------------------------

--
-- Table structure for table `mark`
--

CREATE TABLE `mark` (
  `reg_number` varchar(40) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `period` varchar(255) NOT NULL,
  `term` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mark`
--

INSERT INTO `mark` (`reg_number`, `subject_id`, `mark`, `period`, `term`) VALUES
('18/U/23411', 1, 50, 'Beginning Of Term', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `reg_number` varchar(40) NOT NULL,
  `class_id` int(11) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `age` int(2) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`reg_number`, `class_id`, `first_name`, `last_name`, `gender`, `age`, `password`) VALUES
('12/U/23333', 1, 'Juma', 'Ali', 'M', 9, 'pass123'),
('18/U/23411', 2, 'Bronson', 'Bakunga', 'M', 10, 'pass123');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_name`) VALUES
(1, 'Science'),
(2, 'Mathematics'),
(3, 'English'),
(4, 'Social Studies'),
(5, 'Writing'),
(6, 'Music'),
(7, 'Physical Education'),
(8, 'French'),
(9, 'Swahili');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `first_name`, `last_name`, `username`, `password`) VALUES
(1, 'Kevin', 'Mark', 'admin', 'admin123'),
(2, 'Lilian', 'Asimwe', 'asimwe', 'admin123'),
(3, 'John', 'Opio', 'opio', 'admin123'),
(4, 'Frank', 'Mutuya', 'frank', 'admin123'),
(5, 'Jack', 'Jonz', 'jack', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `teacher-class`
--

CREATE TABLE `teacher-class` (
  `teacher_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher-class`
--

INSERT INTO `teacher-class` (`teacher_id`, `class_id`) VALUES
(1, 2),
(1, 3),
(1, 4),
(2, 3),
(3, 1),
(3, 2),
(2, 4),
(4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `teacher-subject`
--

CREATE TABLE `teacher-subject` (
  `teacher_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher-subject`
--

INSERT INTO `teacher-subject` (`teacher_id`, `subject_id`) VALUES
(1, 1),
(2, 1),
(2, 2),
(2, 5),
(3, 4),
(4, 5),
(4, 2),
(3, 6),
(1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE `timetable` (
  `timetable_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `first_period` varchar(255) NOT NULL,
  `second_period` varchar(255) NOT NULL,
  `third_period` varchar(255) NOT NULL,
  `fourth_period` varchar(255) NOT NULL,
  `fifth_period` varchar(255) NOT NULL,
  `sixth_period` varchar(255) NOT NULL,
  `first_period_teacher` varchar(255) NOT NULL,
  `second_period_teacher` varchar(255) NOT NULL,
  `third_period_teacher` varchar(255) NOT NULL,
  `fourth_period_teacher` varchar(255) NOT NULL,
  `fifth_period_teacher` varchar(255) NOT NULL,
  `sixth_period_teacher` varchar(255) NOT NULL,
  `term` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `class-subject`
--
ALTER TABLE `class-subject`
  ADD KEY `Class-Subject_fk0` (`class_id`),
  ADD KEY `Class-Subject_fk1` (`subject_id`);

--
-- Indexes for table `mark`
--
ALTER TABLE `mark`
  ADD KEY `Mark_fk0` (`reg_number`),
  ADD KEY `Mark_fk1` (`subject_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`reg_number`),
  ADD KEY `Student_fk0` (`class_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Indexes for table `teacher-class`
--
ALTER TABLE `teacher-class`
  ADD KEY `Teacher-Class_fk0` (`teacher_id`),
  ADD KEY `Teacher-Class_fk1` (`class_id`);

--
-- Indexes for table `teacher-subject`
--
ALTER TABLE `teacher-subject`
  ADD KEY `Teacher-Subject_fk0` (`teacher_id`),
  ADD KEY `Teacher-Subject_fk1` (`subject_id`);

--
-- Indexes for table `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`timetable_id`),
  ADD KEY `Timetable_fk0` (`class_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `timetable`
--
ALTER TABLE `timetable`
  MODIFY `timetable_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class-subject`
--
ALTER TABLE `class-subject`
  ADD CONSTRAINT `Class-Subject_fk0` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `Class-Subject_fk1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `mark`
--
ALTER TABLE `mark`
  ADD CONSTRAINT `Mark_fk0` FOREIGN KEY (`reg_number`) REFERENCES `student` (`reg_number`),
  ADD CONSTRAINT `Mark_fk1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `Student_fk0` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `teacher-class`
--
ALTER TABLE `teacher-class`
  ADD CONSTRAINT `Teacher-Class_fk0` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  ADD CONSTRAINT `Teacher-Class_fk1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `teacher-subject`
--
ALTER TABLE `teacher-subject`
  ADD CONSTRAINT `Teacher-Subject_fk0` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  ADD CONSTRAINT `Teacher-Subject_fk1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `Timetable_fk0` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
