DROP SCHEMA IF EXISTS 'KALANJIAM'

CREATE SCHEMA 'KALANJIAM'


DROP TABLE IF EXISTS 'KALANJIAM.users' ;
CREATE TABLE users (
  user_id int NOT NULL AUTO_INCREMENT,
  user_name  varchar(20) NOT NULL,
  password varchar(64) NOT NULL,
  email varchar(45) NOT NULL,
  mobile_no varchar(10) NOT NULL,
  alt_mobile_no varchar(10) ,
  full_name varchar(45) NOT NULL,
  enabled tinyint DEFAULT 1,
  PRIMARY KEY (user_id),
  UNIQUE KEY user_name_UNIQUE (user_name)
);
/*
ALTER TABLE `KALANJIAM`.`users` 
CHANGE COLUMN `mobile_no` `mobile_no` VARCHAR(10) NOT NULL ,
CHANGE COLUMN `alt_mobile_no` `alt_mobile_no` VARCHAR(10) NULL DEFAULT NULL ;*/

DROP TABLE IF EXISTS 'KALANJIAM.roles' ; 
CREATE TABLE roles (
  role_id int NOT NULL AUTO_INCREMENT,
  role_name varchar(45) NOT NULL,
  enabled tinyint DEFAULT 1,
  PRIMARY KEY (role_id)
);

DROP TABLE IF EXISTS 'KALANJIAM.user_roles' ;
CREATE TABLE user_roles (
  USER_role_id int NOT NULL AUTO_INCREMENT,
  user_id int NOT NULL,
  role_id int NOT NULL,
  enabled tinyint DEFAULT 1,
  KEY user_fk_idx (user_id),
  KEY role_fk_idx (role_id),
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE permissions (
    permission_id INT NOT NULL AUTO_INCREMENT,
    permission VARCHAR(45) NOT NULL,
    enabled TINYINT DEFAULT 1,
    PRIMARY KEY (permission_id)
);
  
  
CREATE TABLE ROLE_PERMISSIONS (
    role_permission_id INT NOT NULL AUTO_INCREMENT,
    role_id INT NOT NULL,
    permission_id INT NOT NULL,
    enabled TINYINT DEFAULT 1,
    PRIMARY KEY (role_permission_id),
    KEY role_permission_fk_idx (role_id),
    KEY permission_fk_idx (permission_id),
    CONSTRAINT role_permission_fk FOREIGN KEY (role_id)
        REFERENCES roles (role_id),
    CONSTRAINT permission_fk FOREIGN KEY (permission_id)
        REFERENCES permissions (permission_id)
);




CREATE TABLE `Suvi`.`Reader` (
  `READER_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `BOOK_ID` VARCHAR(20) NOT NULL,
  `START_DATE` DATE NOT NULL,
  `COMPLETED_DATE` DATE NULL,
  `READ_STATUS` VARCHAR(1) NOT NULL DEFAULT 'U' CONSTRAINT `READ_STATUS_CHK CHECK`  CHECK(READ_STATUS IN ('S', 'P', 'C', 'H', 'U')),
  `COMMENTS` NCHAR(200) NULL,
  `READ_COUNT` INT NULL,
  `PROGRESSED_PAGES` INT NULL,
  `LAST_MODIFIED_ON` DATETIME NOT NULL,
  PRIMARY KEY (`READER_ID`),
  INDEX `FK_READER_BOOK_ID_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `FK_READER_BOOK_ID_idx1` (`BOOK_ID` ASC) VISIBLE,
  CONSTRAINT `FK_READER_USER_ID`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `Suvi`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_READER_BOOK_ID`
    FOREIGN KEY (`BOOK_ID`)
    REFERENCES `Suvi`.`books` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
