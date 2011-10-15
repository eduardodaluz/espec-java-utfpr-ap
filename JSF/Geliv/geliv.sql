CREATE DATABASE IF NOT EXISTS livraria;
CREATE TABLE `livro` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`autor` varchar(255) DEFAULT NULL,
	`avaliacao` int(11) NOT NULL,
	`editora` varchar(255) DEFAULT NULL,
	`isbn` varchar(255) DEFAULT NULL,
	`paginas` int(11) NOT NULL,
	`titulo` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARSET=latin1;
