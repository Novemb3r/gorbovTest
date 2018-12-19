CREATE TABLE auth
(
  `id` INT(8) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `email` CHAR(30) NOT NULL UNIQUE,
  `password` CHAR(32)
)DEFAULT CHARSET=utf8 ENGINE=InnoDB;

CREATE TABLE users
(
  `id` INT(8) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` CHAR(30) NOT NULL,
  `surname` CHAR (30) NOT NULL,
  `patronymic` CHAR (30) DEFAULT null,
  `dateOfBirth` DATE NOT NULL,
  `gender` ENUM('male', 'female', 'empty') DEFAULT 'empty',
  `role` ENUM ('user', 'doctor') DEFAULT 'user'
)DEFAULT CHARSET=utf8 ENGINE=InnoDB;

CREATE TABLE results
(
  `id` INT(8) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `userId` CHAR(30) NOT NULL,
  `dateBeginFirstStage` BIGINT,
  `dateEndFirstStage` BIGINT,
  `dateBeginSecondStage` BIGINT,
  `dateEndSecondStage` BIGINT,
  `errorsOnFirstStage` INT(8) unsigned,
  `errorsOnSecondStage` INT(8) unsigned
)DEFAULT CHARSET=utf8 ENGINE=InnoDB;