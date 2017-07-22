-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Sam 22 Juillet 2017 à 18:16
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
-- Structure de la table `ami`
--

CREATE TABLE IF NOT EXISTS `ami` (
  `idAmi` int(11) NOT NULL AUTO_INCREMENT,
  `idCompte1` int(11) NOT NULL,
  `idCompte2` int(11) NOT NULL,
  `demande` int(11) NOT NULL,
  PRIMARY KEY (`idAmi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`idcompte`, `login`, `mdp`, `prenom`, `nom`, `email`, `niveau`) VALUES
(1, 'gerant', 'gerant', 'projet', 'annuel', 'gerant@gerant.com', '1'),
(2, 'Alain03', 'azerty', 'Alain', 'Simon', 'Alain.Simon@Laposte.fr', '0'),
(3, 'GDumans', 'aqwzsx', 'Georges', 'Dumans', 'GDumans@orange.com', '0'),
(11, 'Pat56', 'Anvers', 'Patrick', 'Dupont', 'Patrick.Dupont@gmail.com', '0'),
(12, 'MichelSa', 'SalarMi', 'Michel', 'Salar', 'MSalar@free.com', '0'),
(13, 'Jeannot43', 'Sabariri', 'Jean', 'Sabari', 'Jean06@orange.fr', '0');

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
  `description` varchar(200) DEFAULT NULL,
  `duree` varchar(45) NOT NULL,
  `chanteur` varchar(45) NOT NULL,
  `vue` int(11) DEFAULT '0',
  `chemin` varchar(200) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `pays` varchar(45) NOT NULL,
  `date` int(4) NOT NULL,
  PRIMARY KEY (`idMusique`),
  KEY `vue` (`vue`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`idMusique`, `nom`, `description`, `duree`, `chanteur`, `vue`, `chemin`, `genre`, `pays`, `date`) VALUES
(1, 'Emmenez moi', 'Chanson sur le desir nostalgique de voyager ', '3m34', 'Charles Aznavour', 4, 'Charles_Aznavour_Emmenez_moi', 'Chanson Francaise', 'France', 1967),
(2, 'Numb', '13eme et derniere chanson de l''album Meteora', '3m07', 'Linkin park', 8, 'Linkin_Park_Numb', 'Rock', 'Angleterre', 2003),
(3, 'What a wonderful world', 'Musique populaire l''annee de sa sortie puis 20 plus tard avec le film Good morning Vietnam', '2m17', 'Louis Armstrong', 12, 'Louis_ Armstrong_What_a_Wonderful_World', 'Jazz', 'Etat-Unis', 1967),
(4, 'Non, je ne regrette rien', 'Chason favorite d''Edith Piaf, "C''est moi, c''est ma vie!"', '2m23', 'Edith Piaf', 4, 'Edith_Piaf_Non_Je_Ne_Regrette_Rien', 'Chanson Francaise', 'France', 1960),
(5, 'Get lucky', 'succes francais, numero un mondial dans de nombreux pays du monde', '4m07', 'Daft Punk', 1, 'Daft_Punk_Get_lucky', 'Chanson Francaise', 'France', 2013),
(6, 'Bouge de la ', 'Considere comme le premeier grand tube de rap', '3m06', 'MC Solaar', 3, 'MC_Solaar_Bouge_De_La', 'Rap', 'France', 1991),
(7, 'Wati house', 'Numero 4 hit-parades en France et Belgique', '4m17', 'Wabit B', 0, 'Sexion_Dassaut_Wati_House', 'Rap', 'France', 2012),
(8, 'Hello', 'Marque le retour de la chanteuse apres 4 ans ', '4m55', 'Adele', 1, 'Adele_Hello', 'Pop', 'Angleterre', 2015),
(9, 'Ne me quitte pas', 'Chanson ecrite par Jacque Brel apres une rupture amoureuse', '4m09', 'Jaque Brel', 6, 'Brel_Ne_Me_Quitte Pas', 'Chanson Francaise', 'Belgique', 1959),
(10, 'Fruit de la passion', 'Connait un immense succes aux Antilles avant de le connaitre dans l''hexagone trois ans plus tard', '4m00', 'Francky Vincent', 7, 'Francky_Vincent_Fruit_De_La_Passion', 'Chanson Francaise', 'France', 1991),
(11, 'Roar', 'Le second plus grand succès de la chanteuse, ', '3m42', 'Katy Perry', 14, 'Katy_Perry_Roar', 'Pop', 'Etat-unis', 2013),
(12, 'This is how we do', 'Cinquieme single du troisieme album de la chanteuse', '3m29', 'Katy Perry', 4, 'Katy_Perry_This_Is_How_We_Do', 'Pop', 'Etat-unis', 2013),
(13, 'Qui a le droit', 'Disque d''or, numero un pendant 7 semaines', '4m04', 'Patrick Bruel', 7, 'Patrick_Bruel_Qui_a_le_droit', 'Chanson Francaise', 'France', 1991),
(14, 'Casser la voix', 'Tube qui lancera la BruelMania', '4m37', 'Patrick Bruel', 8, 'Patrick_Bruel_Casser_la_voix', 'Chanson Francaise', 'France', 1989),
(15, 'Pour que tu m''aimes encore', 'succes fulgurant, elle reste 12 semaines numero un', '4m12', 'Celine Dion', 1, 'Celine_Dion_Pour_que_tu_maimes_encore', 'Chanson Francaise', 'Canda', 1995),
(16, 'Parler a mon pere', 'Chason ecrite par Jacques Veneruso', '2m55', 'Celine Dion', 11, 'Celine_Dion_Parler_A_Mon_Pere', 'Chanson Francaise', 'Canada', 2012),
(17, 'C''est la vie', 'Chanson produite par RedOne', '3m50', 'Khaled', 0, 'Khaled_Cest_la_vie', 'Rai', 'Algerie', 2012),
(18, 'Aicha', 'Compose par Goldman', '4m23', 'Khaled', 2, 'khaled_Aicha', 'Rai', 'Algerie', 1996),
(19, 'Waka wakka ', 'Chanson de la coupe du monde 2010 en Afrique ', '3m21', 'Shakira', 17, 'Shakira_Waka_Waka', 'Pop', 'Colombie', 2010),
(20, 'Me enamore', 'chante et compose par Shakira', '3m45', 'Shakira', 13, 'Shakira_Me_enamore', 'Pop', 'Colombie', 2017);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `plugins`
--

INSERT INTO `plugins` (`idPlugins`, `description`, `nom`) VALUES
(1, 'Possibilite de voir les playlists de ses amis', 'SocialNetwork');

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
