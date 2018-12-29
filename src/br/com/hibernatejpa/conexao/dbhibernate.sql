-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Dez-2018 às 16:58
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhibernate`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `descricao`) VALUES
(2, 'extra doce222'),
(7, 'ss');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(14);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `tipo`, `categoria_id`) VALUES
(12, 'brinquedo', 'brinquedo56556', NULL),
(13, 'panela', 'cozinha565562828', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKka9jjk42p5jtly14gius2b202` (`categoria_id`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FKka9jjk42p5jtly14gius2b202` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
