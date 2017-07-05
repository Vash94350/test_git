-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Mer 05 Juillet 2017 à 16:04
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
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `idcompte` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `niveau` varchar(45) NOT NULL,
  PRIMARY KEY (`idcompte`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`idcompte`, `login`, `mdp`, `prenom`, `nom`, `email`, `niveau`) VALUES
(1, 'gerant', 'gerant', 'projet', 'annuel', 'gerant@gerant.com', '1'),
(2, 'test01', 'test01', 'alain', 'alain', 'test01@test01.com', '0'),
(3, 'test03', 'test03', 'simon', 'simon', 'test03@test03.com', '0'),
(11, 'test04', 'test04', 'patrick', 'dupont', 'test04@test04.com', '0');

-- --------------------------------------------------------

--
-- Structure de la table `favori`
--

CREATE TABLE IF NOT EXISTS `favori` (
  `idfavori` int(11) NOT NULL,
  `compte_idcompte` int(11) NOT NULL,
  `Musique_idMusique` int(11) NOT NULL,
  PRIMARY KEY (`idfavori`),
  KEY `fk_favori_compte_idx` (`compte_idcompte`),
  KEY `fk_favori_Musique1_idx` (`Musique_idMusique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `date` date NOT NULL,
  PRIMARY KEY (`idMusique`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`idMusique`, `nom`, `description`, `durée`, `chanteur`, `vue`, `chemin`, `genre`, `pays`, `populaire`, `date`) VALUES
(1, 'Emmenez moi', 'test1', '3m31', 'Charles Aznavour', 4, 'musiquebdd\\Charles Aznavour-Emmenez-Moi.mp3', 'chanson Française', 'France', 1, '2016-06-01'),
(2, 'Numb', 'test2', '3m06', 'Linkin park', 8, '', 'Rock', 'Angleterre', 1, '2017-07-05'),
(3, 'What a wonderful world', 'test3', '2m30', 'Louis Armstrong', 12, '', 'Jazz', 'Etat-Unis', 1, '2015-08-24'),
(4, 'Non, je ne regrette rien', 'test4', '2m20', 'Edith Piaf', 4, '', 'Chanson Française', 'France', 1, '2013-05-05'),
(5, 'Get lucky', 'test5', '4m07', 'Daft Punk', 1, '', 'Chanson française', 'France', 1, '2017-07-05'),
(6, 'Bouge de la ', 'test6', '3m10', 'MC Solaar', 3, '', 'Rap', 'France', 1, '2015-08-02'),
(7, 'Wati house', 'test7', '4m36', 'Wabit B', 0, '', 'Rap', 'France', 1, '2013-11-18'),
(8, 'Hello', 'test8', '6m06', 'Adele', 1, '', 'pop', 'Angleterre', 1, '2017-04-02'),
(9, 'Ne me quitte pas', 'test9', '3m38', 'Jaque Brel', 6, '', 'Chanson française', 'Belgique', 1, '2015-05-18'),
(10, 'Fruit de la passion', 'test10', '3m59', 'Francky Vincent', 7, '', 'Chanson Française', 'France', 1, '2015-09-28'),
(11, 'Roar', 'test 11', '4m29', 'Katy Perry', 14, '', 'pop', 'Etat-unis', 1, '2017-05-07'),
(12, 'This is how we do', 'test 12', '3m29', 'Katy Perry', 4, '', 'pop', 'Etat-unis', 1, '2016-12-15'),
(13, 'Qui a le droit', 'test12', '3m28', 'Patrick Bruel', 7, '', 'chanson Française', 'France', 1, '2015-09-27'),
(14, 'Lequel de nous', 'test13', '4m42', 'Patrick Bruel', 8, '', 'chanson Française', 'France', 1, '2015-07-09'),
(15, 'Pour que tu m''aimes encore', 'test 14', '4m08', 'Celine Dion', 1, '', 'Chanson française', 'Canda', 1, '2016-12-08'),
(16, 'Parler à mon père', 'test16', '3m10', 'Celine Dion', 11, '', 'Chanson française', 'Canada', 1, '2017-06-07'),
(17, 'C''est la vie', 'test17', '3m56', 'Khaled', 0, '', 'rai', 'Algérie', 1, '2017-07-05'),
(18, 'Aicha', 'test18', '4m18', 'Khaled', 2, '', 'rai', 'Algérie', 1, '2016-12-31'),
(19, 'Waka wakka ', 'test19', '3m30', 'Shakira', 17, '', 'pop', 'Colombie', 1, '2016-07-06'),
(20, 'Me enamoré', 'test20', '3m51', 'Shakira', 13, '', 'pop', 'Colombie', 1, '2015-07-08');

-- --------------------------------------------------------

--
-- Structure de la table `playlist`
--

CREATE TABLE IF NOT EXISTS `playlist` (
  `idplaylist` int(11) NOT NULL AUTO_INCREMENT,
  `Musique_idMusique` int(11) NOT NULL,
  `compte_idcompte` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idplaylist`),
  KEY `fk_playlist_Musique1_idx` (`Musique_idMusique`),
  KEY `fk_playlist_compte1_idx` (`compte_idcompte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `plugins`
--

CREATE TABLE IF NOT EXISTS `plugins` (
  `idPlugins` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(45) NOT NULL,
  PRIMARY KEY (`idPlugins`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `pluginscompte`
--

CREATE TABLE IF NOT EXISTS `pluginscompte` (
  `idPluginsCompte` int(11) NOT NULL AUTO_INCREMENT,
  `compte_idcompte` int(11) NOT NULL,
  `Plugins_idPlugins` int(11) NOT NULL,
  PRIMARY KEY (`idPluginsCompte`),
  KEY `fk_compte_has_Plugins_Plugins1_idx` (`Plugins_idPlugins`),
  KEY `fk_compte_has_Plugins_compte1_idx` (`compte_idcompte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `favori`
--
ALTER TABLE `favori`
  ADD CONSTRAINT `fk_favori_compte` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_favori_Musique1` FOREIGN KEY (`Musique_idMusique`) REFERENCES `musique` (`idMusique`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `fk_playlist_compte1` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_playlist_Musique1` FOREIGN KEY (`Musique_idMusique`) REFERENCES `musique` (`idMusique`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `pluginscompte`
--
ALTER TABLE `pluginscompte`
  ADD CONSTRAINT `fk_compte_has_Plugins_compte1` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_compte_has_Plugins_Plugins1` FOREIGN KEY (`Plugins_idPlugins`) REFERENCES `plugins` (`idPlugins`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
