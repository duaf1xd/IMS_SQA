CREATE DATABASE ims_sqa;
USE ims_sqa;
CREATE TABLE account (
  `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password` VARCHAR(50) NOT NULL UNIQUE,
  `role` ENUM('Admin', 'InventoryManager', 'Salesperson') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO account (`id`, `username`, `password`, `role`) VALUES ('1', 'admin', 'admin', 'Admin');
INSERT INTO account (`id`, `username`, `password`, `role`) VALUES ('2', 'inventorymanager', 'inventorymanager', 'InventoryManager');
INSERT INTO account (`id`, `username`, `password`, `role`) VALUES ('3', 'salesperson', 'salesperson', 'Salesperson');

