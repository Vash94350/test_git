-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Sam 24 Juin 2017 à 10:25
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `mumusique`
--

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

CREATE TABLE IF NOT EXISTS `musique` (
  `idMusique` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `durée` varchar(45) NOT NULL,
  `chanteur` varchar(45) NOT NULL,
  `vue` int(11) DEFAULT '0',
  `chemin` varchar(150) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `pays` varchar(45) NOT NULL,
  `populaire` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idMusique`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`idMusique`, `nom`, `description`, `durée`, `chanteur`, `vue`, `chemin`, `genre`, `pays`, `populaire`) VALUES
(1, 'Emmenez moi', 'test1', '3m31', 'Charles Aznavour', 4, 'musiquebdd\\Charles Aznavour-Emmenez-Moi.mp3', 'chanson Française', 'France', 1),
(2, 'Numb', 'test2', '3m06', 'Linkin park', 8, '', 'Rock', 'Angleterre', 1),
(3, 'What a wonderful world', 'test3', '2m30', 'Louis Armstrong', 12, '', 'Jazz', 'Etat-Unis', 1),
(4, 'Non, je ne regrette rien', 'test4', '2m20', 'Edith Piaf', 4, '', 'Chanson Française', 'France', 1),
(5, 'Get lucky', 'test5', '4m07', 'Daft Punk', 1, '', 'Chanson française', 'France', 1),
(6, 'Bouge de la ', 'test6', '3m10', 'MC Solaar', 3, '', 'Rap', 'France', 1),
(7, 'Wati house', 'test7', '4m36', 'Wabit B', 0, '', 'Rap', 'France', 1),
(8, 'Hello', 'test8', '6m06', 'Adele', 1, '', 'pop', 'Angleterre', 1),
(9, 'Ne me quitte pas', 'test9', '3m38', 'Jaque Brel', 6, '', 'Chanson française', 'Belgique', 1),
(10, 'Fruit de la passion', 'test10', '3m59', 'Francky Vincent', 7, '', 'Chanson Française', 'France', 1),
(11, 'Roar', 'test 11', '4m29', 'Katy Perry', 14, '', 'pop', 'Etat-unis', 1),
(12, 'This is how we do', 'test 12', '3m29', 'Katy Perry', 4, '', 'pop', 'Etat-unis', 1),
(13, 'Qui a le droit', 'test12', '3m28', 'Patrick Bruel', 7, '', 'chanson Française', 'France', 1),
(14, 'Lequel de nous', 'test13', '4m42', 'Patrick Bruel', 8, '', 'chanson Française', 'France', 1),
(15, 'Pour que tu m''aimes encore', 'test 14', '4m08', 'Celine Dion', 1, '', 'Chanson française', 'Canda', 1),
(16, 'Parler à mon père', 'test16', '3m10', 'Celine Dion', 11, '', 'Chanson française', 'Canada', 1),
(17, 'C''est la vie', 'test17', '3m56', 'Khaled', 0, '', 'rai', 'Algérie', 1),
(18, 'Aicha', 'test18', '4m18', 'Khaled', 2, '', 'rai', 'Algérie', 1),
(19, 'Waka wakka ', 'test19', '3m30', 'Shakira', 17, '', 'pop', 'Colombie', 1),
(20, 'Me enamoré', 'test20', '3m51', 'Shakira', 13, '', 'pop', 'Colombie', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
