CREATE DATABASE  IF NOT EXISTS `livraria2`;
USE `livraria2`;

DROP TABLE IF EXISTS `editora`;

CREATE TABLE `editora` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `editora` VALUES (1,'Atica'),(2,'Elsevier'),(3,'ABC Letras'),(4,'Springer Link');

DROP TABLE IF EXISTS `livro`;
CREATE TABLE `livro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `avaliacao` int(11) NOT NULL,
  `editora_id` bigint(20) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `paginas` int(11) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `livro_fk_editora` (`editora_id`),
  CONSTRAINT `livro_fk_editora` FOREIGN KEY (`editora_id`) REFERENCES `editora` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;