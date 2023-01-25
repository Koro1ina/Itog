



DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `FIO` varchar(200) NOT NULL,
  `Passport` varchar(55) NOT NULL,
  `DateBD` DATE DEFAULT NULL,
  `Login` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  PRIMARY KEY (`idClients`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;


INSERT INTO `client` VALUES (1,'Сметанин Павел Андреевич','4232 214521','2002-11-28','1','12');



DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `idBook` int NOT NULL AUTO_INCREMENT,
  `NameBook` varchar(100) NOT NULL,
  `Autor` varchar(100) NOT NULL,
  `Bookcol` varchar(20) NOT NULL,
  `Cell` varchar(50) NOT NULL,
  `Image` varchar(45) DEFAULT NULL,  
  PRIMARY KEY (`idBook`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

INSERT INTO `book` VALUES (1,'Древний: Вторжение','Андрей Тармашев','5','500'),(2,'Колобок','Автор','50','400');


DROP TABLE IF EXISTS `dolg`;

CREATE TABLE `dolg` (
  `idDolg` int NOT NULL AUTO_INCREMENT,
  `NameDolg` varchar(100) DEFAULT NULL,
  `Cash` varchar(100)DEFAULT NULL,
  PRIMARY KEY (`idolg`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


INSERT INTO `dolg` VALUES (1,'Администратор','80000'),(2,'Библиотекарь','40000'),(3,'Продавец','50000');

DROP TABLE IF EXISTS `sotrudnik`;
CREATE TABLE `sotrudnik` (
  `idSotrudnik` int NOT NULL AUTO_INCREMENT,
  `Dolg_idDolg` int NOT NULL,
  `FIO` VARCHAR(100) NOT NULL,
  `Login` varchar(100) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Image` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`idSotrudnik`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;


INSERT INTO `sotrudnik` VALUES (1,3,'Одлоывап','3','3');

DROP TABLE IF EXISTS `zakaz`;

CREATE TABLE `zakaz` (
  `idZakaz` int NOT NULL AUTO_INCREMENT,
  `Client_idClient` int NOT NULL,
  `Sotrudnik_idSotrudnik` int NOT NULL,
  `DateCreate` DATE NOT NULL,
  `TimeCreate` VARCHAR(45) NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `DateClose` DATE DEFAULT NULL,
  `Cell` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZakaz`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;


INSERT INTO `Staff` VALUES (1,1,1,'2022-12-13','9:00','Доставка',,'1500');
