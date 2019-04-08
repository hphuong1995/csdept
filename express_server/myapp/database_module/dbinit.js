CREATE SCHEMA `csdept` ;


CREATE TABLE `csdept`.`User` (
  `uid` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `type` INT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE INDEX `uid_UNIQUE` (`uid` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

ALTER TABLE `csdept`.`User`
ADD COLUMN `fullName` VARCHAR(45) NULL AFTER `type`;


CREATE TABLE `csdept`.`Course` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(45) NULL,
  `uid` INT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE INDEX `cid_UNIQUE` (`cid` ASC) VISIBLE,
  INDEX `uid_idx` (`uid` ASC) VISIBLE,
  CONSTRAINT `uid`
    FOREIGN KEY (`uid`)
    REFERENCES `csdept`.`User` (`uid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `csdept`.`Topic` (
  `tid` INT NOT NULL AUTO_INCREMENT,
  `tname` VARCHAR(45) NULL,
  PRIMARY KEY (`tid`),
  UNIQUE INDEX `tid_UNIQUE` (`tid` ASC) VISIBLE);

CREATE TABLE `csdept`.`Question` (
  `qid` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(10000) NULL,
  `tid` INT NULL,
  PRIMARY KEY (`qid`),
  INDEX `tid_idx` (`tid` ASC) VISIBLE,
  UNIQUE INDEX `qid_UNIQUE` (`qid` ASC) VISIBLE,
  CONSTRAINT `tid`
    FOREIGN KEY (`tid`)
    REFERENCES `csdept`.`Topic` (`tid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `csdept`.`Question`
ADD COLUMN `cid` INT NULL AFTER `tid`,
ADD INDEX `cid_idx` (`cid` ASC) VISIBLE;
;
ALTER TABLE `csdept`.`Question`
ADD CONSTRAINT `cid`
  FOREIGN KEY (`cid`)
  REFERENCES `csdept`.`Course` (`cid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  CREATE TABLE `csdept`.`Option` (
    `qid` INT NOT NULL,
    `opt` VARCHAR(150) NOT NULL,
    INDEX `pid_idx` (`qid` ASC) VISIBLE,
    CONSTRAINT `pid`
      FOREIGN KEY (`qid`)
      REFERENCES `csdept`.`Question` (`qid`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);





INSERT INTO `csdept`.`User` (`uid`, `username`, `password`, `type`, `fullName`) VALUES ('1', 'phuongnguyen', '12345', '0', 'Phuong Nguyen');
INSERT INTO `csdept`.`User` (`uid`, `username`, `password`, `type`, `fullName`) VALUES ('2', 'kennyhunt', '12345', '0', 'Kenny Hunt');
INSERT INTO `csdept`.`User` (`uid`, `username`, `password`, `type`, `fullName`) VALUES ('3', 'eliotforbes', '12345', '0', 'Eliot Forbes');


INSERT INTO `csdept`.`Course` (`cid`, `cname`, `uid`) VALUES ('1', 'CS120', '2');
INSERT INTO `csdept`.`Course` (`cid`, `cname`, `uid`) VALUES ('2', 'CS340', '2');
INSERT INTO `csdept`.`Course` (`cid`, `cname`, `uid`) VALUES ('3', 'CS220', '3');

INSERT INTO `csdept`.`Topic` (`tid`, `tname`) VALUES ('1', 'shor');
INSERT INTO `csdept`.`Topic` (`tid`, `tname`) VALUES ('2', 'mult');
INSERT INTO `csdept`.`Topic` (`tid`, `tname`) VALUES ('3', 'code');

INSERT INTO `csdept`.`Question` (`qid`, `content`, `tid`) VALUES ('1', 'Specify output of this code\\nString test = \"Hello World\";\\nSystem.out.println(test.substring(4));<key>o', '1');
INSERT INTO `csdept`.`Question` (`qid`, `content`, `tid`) VALUES ('2', 'Specify output of this code\\nString test = \"Test String\";\\nSystem.out.println(test.substring(2,5));<key>st S', '1');

UPDATE `csdept`.`Question` SET `cid` = '1' WHERE (`qid` = '1');
UPDATE `csdept`.`Question` SET `cid` = '1' WHERE (`qid` = '2');
