SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `TestTask` ;
CREATE SCHEMA IF NOT EXISTS `TestTask` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `TestTask` ;

-- -----------------------------------------------------
-- Table `mydb`.`Table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TestTask`.`Table` ;

CREATE TABLE IF NOT EXISTS `TestTask`.`Table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(31) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


LOCK TABLES `Table` WRITE;
/*!40000 ALTER TABLE `Table` DISABLE KEYS */;
INSERT INTO `Table` VALUES (1, 'Name_1', 'desc_1'),(2, 'Name_2', 'desc_2'),(3, 'Name_3', 'desc_3'),(4, 'Name_4', 'desc_4'),(5, 'Name_5', 'desc_5'),(6, 'Name_6', 'desc_6');
/*!40000 ALTER TABLE `Table` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
