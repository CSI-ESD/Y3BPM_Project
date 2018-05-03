DROP DATABASE  IF EXISTS `authentification_service`;

CREATE DATABASE  IF NOT EXISTS `authentification_service`;
USE `authentification_service`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('admin','$2a$04$E5LuN.cgVpgUq95NHqPqDeHhQ5TOBQNda0pcIf4VDWYP/oI3aQ41K','Admin','Admin','admin@admin.com',1),
('alex','$2a$04$1mgpuoCUZG3SAGTes0DvROuORP5Ntr8fMY8KEIoMkGSUZTuVUWTPi','Alexandru','Constantin','alex@alex.com',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('admin','ROLE_ADMINISTRATOR'),
('admin','ROLE_USER'),
('alex','ROLE_USER');


