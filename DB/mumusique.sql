-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 14 Juin 2017 à 20:46
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mumusique`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `idcompte` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `niveau` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `favori` (
  `idfavori` int(11) NOT NULL,
  `compte_idcompte` int(11) NOT NULL,
  `Musique_idMusique` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

CREATE TABLE `musique` (
  `idMusique` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `durée` varchar(45) NOT NULL,
  `chanteur` varchar(45) NOT NULL,
  `vue` int(11) DEFAULT '0',
  `type` varchar(45) NOT NULL,
  `chemin` varchar(150) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `pays` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`idMusique`, `nom`, `description`, `durée`, `chanteur`, `vue`, `type`, `chemin`, `genre`, `pays`) VALUES
(1, 'Emmenez moi', NULL, '3m31', 'Charles Aznavour', 0, 'chanson française', 'musiquebdd\\Charles Aznavour-Emmenez-Moi.mp3', 'chanson populaire', 'France'),
(2, 'Linkin park', NULL, '', '', 0, '', 'Instrumental', 'Rock', 'Angleterre'),
(3, 'Louis Amstrong', NULL, '', '', 0, '', 'Annee80', 'Jazz', 'Etat-Unis'),
(4, '', NULL, '', 'Edith Piaf', 0, 'Annee80', '', 'Chanson Française', 'France'),
(5, '', NULL, '', 'Daft Punk', 0, 'Instrumental', '', 'Chanson française', 'France'),
(6, '', NULL, '', 'MC Solaar', 0, 'Populaire', '', 'Rap', 'France'),
(7, '', NULL, '', 'Wabit B', 0, 'Populaire', '', 'Rap', 'France'),
(8, '', NULL, '', 'Adele', 0, 'Recent', '', 'pop', 'Angleterre'),
(9, '', NULL, '', 'Jaque Brel', 0, 'Annee80', '', 'Chanson française', 'Belgique'),
(10, '', NULL, '', 'Francky Vincent', 0, 'Populaire', '', 'Chanson Française', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `playlist`
--

CREATE TABLE `playlist` (
  `idplaylist` int(11) NOT NULL,
  `Musique_idMusique` int(11) NOT NULL,
  `compte_idcompte` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `plugins`
--

CREATE TABLE `plugins` (
  `idPlugins` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `pluginscompte`
--

CREATE TABLE `pluginscompte` (
  `idPluginsCompte` int(11) NOT NULL,
  `compte_idcompte` int(11) NOT NULL,
  `Plugins_idPlugins` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`idcompte`);

--
-- Index pour la table `favori`
--
ALTER TABLE `favori`
  ADD PRIMARY KEY (`idfavori`),
  ADD KEY `fk_favori_compte_idx` (`compte_idcompte`),
  ADD KEY `fk_favori_Musique1_idx` (`Musique_idMusique`);

--
-- Index pour la table `musique`
--
ALTER TABLE `musique`
  ADD PRIMARY KEY (`idMusique`);

--
-- Index pour la table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idplaylist`),
  ADD KEY `fk_playlist_Musique1_idx` (`Musique_idMusique`),
  ADD KEY `fk_playlist_compte1_idx` (`compte_idcompte`);

--
-- Index pour la table `plugins`
--
ALTER TABLE `plugins`
  ADD PRIMARY KEY (`idPlugins`);

--
-- Index pour la table `pluginscompte`
--
ALTER TABLE `pluginscompte`
  ADD PRIMARY KEY (`idPluginsCompte`),
  ADD KEY `fk_compte_has_Plugins_Plugins1_idx` (`Plugins_idPlugins`),
  ADD KEY `fk_compte_has_Plugins_compte1_idx` (`compte_idcompte`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `idcompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `musique`
--
ALTER TABLE `musique`
  MODIFY `idMusique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `idplaylist` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `plugins`
--
ALTER TABLE `plugins`
  MODIFY `idPlugins` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `pluginscompte`
--
ALTER TABLE `pluginscompte`
  MODIFY `idPluginsCompte` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `favori`
--
ALTER TABLE `favori`
  ADD CONSTRAINT `fk_favori_Musique1` FOREIGN KEY (`Musique_idMusique`) REFERENCES `musique` (`idMusique`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_favori_compte` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `fk_playlist_Musique1` FOREIGN KEY (`Musique_idMusique`) REFERENCES `musique` (`idMusique`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_playlist_compte1` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `pluginscompte`
--
ALTER TABLE `pluginscompte`
  ADD CONSTRAINT `fk_compte_has_Plugins_Plugins1` FOREIGN KEY (`Plugins_idPlugins`) REFERENCES `plugins` (`idPlugins`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_compte_has_Plugins_compte1` FOREIGN KEY (`compte_idcompte`) REFERENCES `compte` (`idcompte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
