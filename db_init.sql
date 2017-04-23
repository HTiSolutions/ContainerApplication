CREATE SCHEMA `container_demo` ;
CREATE TABLE `container_demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `forename` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
