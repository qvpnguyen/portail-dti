CREATE DATABASE  IF NOT EXISTS `portaildb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `portaildb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: portaildb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrateur` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Prénom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Role` varchar(255) NOT NULL,
  `Active` boolean NOT NULL,
  `NomUtilisateur` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `NomUtilisateur` (`NomUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrateur`
--

LOCK TABLES `administrateur` WRITE;
/*!40000 ALTER TABLE `administrateur` DISABLE KEYS */;
INSERT INTO `administrateur` VALUES (1,'Julie','Gagnon','julie.gagnon@mail.com','Administrateur',true,'jgagnon','motdepasse');
/*!40000 ALTER TABLE `administrateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visiteur` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Prénom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Role` varchar(255) NOT NULL,
  `Active` boolean NOT NULL,
  `NomUtilisateur` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `NomUtilisateur` (`NomUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visiteur`
--

LOCK TABLES `visiteur` WRITE;
/*!40000 ALTER TABLE `visiteur` DISABLE KEYS */;
INSERT INTO `visiteur` VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'Visiteur', true, 'jdoe', 'password123');
/*!40000 ALTER TABLE `visiteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cours` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Crédits` int NOT NULL,
  `Groupe` int NOT NULL,
  `ProfesseurID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCours388136` (`ProfesseurID`),
  CONSTRAINT `FKCours388136` FOREIGN KEY (`ProfesseurID`) REFERENCES `professeur` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
INSERT INTO `cours` VALUES (1,'Programmation avancée',3,1,1),(2,'Programmation avancée',3,1,1);
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NoteObtenue` int DEFAULT NULL,
  `Session` varchar(255) NOT NULL,
  `Année` date NOT NULL,
  `Commentaire` varchar(1000) DEFAULT NULL,
  `ÉtudiantID` int NOT NULL,
  `CoursID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKNotes55906` (`ÉtudiantID`),
  KEY `FKNotes610320` (`CoursID`),
  CONSTRAINT `FKNotes55906` FOREIGN KEY (`ÉtudiantID`) REFERENCES `étudiant` (`ID`),
  CONSTRAINT `FKNotes610320` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
INSERT INTO `notes` VALUES (3,80,'Hiver','2022-01-01','Bonne participation',2,1);
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notesdecours`
--

DROP TABLE IF EXISTS `notesdecours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notesdecours` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(25) DEFAULT NULL,
  `Lien` varchar(255) NOT NULL,
  `CoursID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKNotesDeCou587519` (`CoursID`),
  CONSTRAINT `FKNotesDeCou587519` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notesdecours`
--

LOCK TABLES `notesdecours` WRITE;
/*!40000 ALTER TABLE `notesdecours` DISABLE KEYS */;
INSERT INTO `notesdecours` VALUES (1,'Exercices sur les DAOs','https://www.youtube.com/watch?v=12345',1),(2,'Configuration Netbeans','https://www.youtube.com/watch?v=54321',1);
/*!40000 ALTER TABLE `notesdecours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participationcours`
--

DROP TABLE IF EXISTS `participationcours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participationcours` (
  `CoursID` int NOT NULL,
  `ÉtudiantID` int NOT NULL,
  KEY `FKParticipat507234` (`CoursID`),
  KEY `FKParticipat812598` (`ÉtudiantID`),
  CONSTRAINT `FKParticipat507234` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`),
  CONSTRAINT `FKParticipat812598` FOREIGN KEY (`ÉtudiantID`) REFERENCES `étudiant` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participationcours`
--

LOCK TABLES `participationcours` WRITE;
/*!40000 ALTER TABLE `participationcours` DISABLE KEYS */;
INSERT INTO `participationcours` VALUES (1,2);
/*!40000 ALTER TABLE `participationcours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professeur` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Prénom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Role` varchar(255) NOT NULL,
  `Active` boolean NOT NULL,
  `NomUtilisateur` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `NomUtilisateur` (`NomUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professeur`
--

LOCK TABLES `professeur` WRITE;
/*!40000 ALTER TABLE `professeur` DISABLE KEYS */;
INSERT INTO `professeur` VALUES (1,'Marie','Lamoureux','marie.lamoureux@mail.com','Professeur',true,'mlamoureux','motdepasse');
/*!40000 ALTER TABLE `professeur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projet`
--

DROP TABLE IF EXISTS `projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projet` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Annee` int NOT NULL,
  `ListeEquipe` varchar(255) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  `Video` varchar(255) NOT NULL,
  `LienGitlab` varchar(255) NOT NULL,
  `CoursID` int NOT NULL,
  `ProfesseurID` int NOT NULL,
  `NotesID` int,
  PRIMARY KEY (`ID`),
  KEY `FKProjet961229` (`CoursID`),
  KEY `FKProjet854526` (`ProfesseurID`),
  KEY `FKProjet414873` (`NotesID`),
  CONSTRAINT `FKProjet414873` FOREIGN KEY (`NotesID`) REFERENCES `notes` (`ID`),
  CONSTRAINT `FKProjet854526` FOREIGN KEY (`ProfesseurID`) REFERENCES `professeur` (`ID`),
  CONSTRAINT `FKProjet961229` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projet`
--

LOCK TABLES `projet` WRITE;
/*!40000 ALTER TABLE `projet` DISABLE KEYS */;
INSERT INTO `projet` VALUES (7,'Application mobile',2023,'Anayees, Patrick, Francis, Othmane','Développement d\'une application mobile pour la gestion des tâches','https://www.youtube.com/watch?v=12345','https://gitlab.com/projet-mobile',1,1,3);
/*!40000 ALTER TABLE `projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicetutorat`
--

DROP TABLE IF EXISTS `servicetutorat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicetutorat` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CoursID` int NOT NULL,
  `ÉtudiantTutoréID` int NOT NULL,
  `ÉtudiantTuteurID` int NOT NULL,
  `DateTutorat` date NOT NULL,
  `Heure` time(6) NOT NULL,
  `Durée` int NOT NULL,
  `TypeDeRencontre` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKServiceTut199686` (`CoursID`),
  KEY `FKServiceTut946265` (`ÉtudiantTutoréID`),
  KEY `FKServiceTut686060` (`ÉtudiantTuteurID`),
  CONSTRAINT `FKServiceTut199686` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`),
  CONSTRAINT `FKServiceTut686060` FOREIGN KEY (`ÉtudiantTuteurID`) REFERENCES `étudiant` (`ID`),
  CONSTRAINT `FKServiceTut946265` FOREIGN KEY (`ÉtudiantTutoréID`) REFERENCES `étudiant` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicetutorat`
--

LOCK TABLES `servicetutorat` WRITE;
/*!40000 ALTER TABLE `servicetutorat` DISABLE KEYS */;
INSERT INTO `servicetutorat` VALUES (2,1,2,4,'2022-02-01','10:00:00.000000',1,'En ligne');
/*!40000 ALTER TABLE `servicetutorat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `étudiant`
--

DROP TABLE IF EXISTS `étudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `étudiant` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Prénom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `DDN` date NOT NULL,
  `Active` boolean NOT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `FormationComplétée` boolean NOT NULL,
  `Profil` varchar(255) NOT NULL,
  `NomUtilisateur` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  `CoursID` int NOT NULL,
  `Disponibilité` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `NomUtilisateur` (`NomUtilisateur`),
  KEY `FKÉtudiant106603` (`CoursID`),
  CONSTRAINT `FKÉtudiant106603` FOREIGN KEY (`CoursID`) REFERENCES `cours` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2102727 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `étudiant`
--

LOCK TABLES `étudiant` WRITE;
/*!40000 ALTER TABLE `étudiant` DISABLE KEYS */;
INSERT INTO `étudiant` VALUES (2,'Jean','Dupont','jean.dupont@mail.com','1995-01-01',true,'Étudiant',true,'Programmation','jdupont','motdepasse',1,NULL),(4,'Jenna','pont','jenna.dupont@mail.com','1995-01-01',true,'Étudiant',true,'Réseautique','jpont','motdepasse',1,NULL),(2102726,'othmane','sedjari','2102726@crosemont.qc.ca','2002-01-23',true,'Tuteur',true,'Programmation','sedjario','ottopro',1,NULL);
/*!40000 ALTER TABLE `étudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `étudiant_projet`
--

DROP TABLE IF EXISTS `étudiant_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `étudiant_projet` (
  `ÉtudiantID` int NOT NULL,
  `ProjetID` int NOT NULL,
  PRIMARY KEY (`ÉtudiantID`,`ProjetID`),
  KEY `FKÉtudiant_P779550` (`ProjetID`),
  CONSTRAINT `FKÉtudiant_P171312` FOREIGN KEY (`ÉtudiantID`) REFERENCES `étudiant` (`ID`),
  CONSTRAINT `FKÉtudiant_P779550` FOREIGN KEY (`ProjetID`) REFERENCES `projet` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `étudiant_projet`
--

LOCK TABLES `étudiant_projet` WRITE;
/*!40000 ALTER TABLE `étudiant_projet` DISABLE KEYS */;
INSERT INTO `étudiant_projet` VALUES (2,7);
/*!40000 ALTER TABLE `étudiant_projet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-28 12:37:23
