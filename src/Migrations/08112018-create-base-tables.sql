CREATE TABLE auth
(
  `id` INT(8) unsigned NOT NULL AUTO_INCREMENT,
  `email` CHAR(30) NOT NULL PRIMARY KEY,
  `password` CHAR(30)
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
  `userId` INT(8) unsigned NOT NULL,
  `dateBeginFirstStage` DATETIME,
  `dateEndFirstStage` DATETIME,
  `dateBeginSecondStage` DATETIME,
  `dateEndSecondStage` DATETIME,
  FOREIGN KEY (`userId`)
  REFERENCES users(id)
    ON DELETE CASCADE
)DEFAULT CHARSET=utf8 ENGINE=InnoDB;