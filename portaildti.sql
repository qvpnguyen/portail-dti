CREATE DATABASE  IF NOT EXISTS `portailinfodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `portailinfodb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: portailinfodb
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
  `id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `data` longblob,
  `ddn` date DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `mot_de_passe` varchar(64) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `prenom` varchar(64) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_japhbtjxjwd39di9pv06o36b3` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrateur`
--

LOCK TABLES `administrateur` WRITE;
/*!40000 ALTER TABLE `administrateur` DISABLE KEYS */;
INSERT INTO `administrateur` VALUES (1,_binary '',NULL,'1990-01-01','root@crosemont.qc.ca','Root1234','Root','admin.png','Root','Administrateur');
/*!40000 ALTER TABLE `administrateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `credits` int DEFAULT NULL,
  `groupe` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
INSERT INTO `cours` VALUES (1,'420-G26-RO','APPLICATIONS WEB 2',NULL,1),(2,'420-G26-RO','APPLICATIONS WEB 2',NULL,2),(3,'420-G25-RO','APPLICATIONS NATIVES 2',NULL,1),(4,'420-G56-RO','APPLICATIONS DE JEUX OU SIMULATIONS',NULL,2),(5,'420-G63-RO','APPLICATIONS WEB 3',NULL,2),(6,'420-G04-RO','APPLICATIONS NATIVE 1',NULL,1),(7,'420-G03-RO','INTRODUCTION À LA SÉCURITÉ INFORMATIQUE',NULL,1),(8,'420-F04-RO','INTRODUCTION AUX BASES DE DONNÉES',NULL,1);
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etudiant` (
  `id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `data` longblob,
  `ddn` date DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `mot_de_passe` varchar(64) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `prenom` varchar(64) NOT NULL,
  `role` varchar(255) NOT NULL,
  `dispo_tutorat` bit(1) DEFAULT NULL,
  `formation_completee` bit(1) DEFAULT NULL,
  `is_tuteur` bit(1) DEFAULT NULL,
  `profil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fp3fcjv6jy2jsx19iq4cpd5p7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant`
--

LOCK TABLES `etudiant` WRITE;
/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
INSERT INTO `etudiant` VALUES (1,_binary '',NULL,'1996-03-12','1428398@crosemont.qc.ca','Sarkes1234','Sarkes','sarkes.png','Anayees','Etudiant',_binary '\0',_binary '\0',_binary '\0','Programmation'),(2,_binary '',NULL,'2002-01-23','2102726@crosemont.qc.ca','Sedjari1234','Sedjari','sedjari.png','Othmane','Étudiant',_binary '',_binary '\0',_binary '','Programmation'),(3,_binary '',NULL,'1991-08-06','0855068@crosemont.qc.ca','Nguyen1234','Nguyen','nguyen.png','Patrick','Étudiant',_binary '',_binary '\0',_binary '\0','Programmation'),(4,_binary '',NULL,'1996-03-12','2199000@crosemont.qc.ca','Lucarelli1234','Lucarelli','lucarelli.png','Mathieu','Étudiant',_binary '',_binary '\0',_binary '','Résautique'),(5,_binary '',NULL,'1996-03-12','1392603@crosemont.qc.ca','Tang1234','Tang','tang.png','Bao Quoc','Étudiant',_binary '',_binary '\0',_binary '','Programmation'),(6,_binary '',NULL,'1996-03-12','2100762@crosemont.qc.ca','Elbeloui1234','Elbeloui','elbeloui.png','Ali','Étudiant',_binary '\0',_binary '\0',_binary '\0','Résautique'),(7,_binary '',NULL,'1990-01-01','yassine.graitaa@hotmail.com','Graitaa1234','Yassine',NULL,'Graitaa','Étudiant',_binary '',_binary '',_binary '','Programmation'),(8,_binary '\0',NULL,'1990-01-02','ghafran786@hotmail.com','Ijaz1234','Gafran',NULL,'Ijaz','Étudiant',_binary '\0',_binary '',_binary '\0','Programmation'),(9,_binary '',NULL,'1990-01-03','snely550@gmail.com','Lys1234','Lys',NULL,'Snley Adam','Étudiant',_binary '',_binary '',_binary '','Programmation'),(10,_binary '\0',NULL,'1990-01-04','joel.2002.martin@gmail.com','Martin1234','Martin',NULL,'Joël','Étudiant',_binary '\0',_binary '',_binary '\0','Programmation'),(11,_binary '',NULL,'1990-01-05','g.boivert@gmail.com ','Boisvert1234','Boisvert',NULL,'Gabriel','Étudiant',_binary '\0',_binary '',_binary '','Programmation'),(12,_binary '\0',NULL,'1990-01-06','contact@rafaelhuard.com','Huard1234','Huard',NULL,'Rafaël','Étudiant',_binary '\0',_binary '',_binary '','Programmation'),(13,_binary '',NULL,'1990-01-07','2069521@crosemont.qc.ca','Elatris1234','Elatris',NULL,'Adham','Étudiant',_binary '\0',_binary '\0',_binary '\0','Programmation');
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant_projet`
--

DROP TABLE IF EXISTS `etudiant_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etudiant_projet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `étudiantid` int DEFAULT NULL,
  `projetid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1tr7kwlt5gvkmw1mkeiphsdi4` (`étudiantid`),
  KEY `FKbidw15hxbvv4nt9espjdi87kl` (`projetid`),
  CONSTRAINT `FK1tr7kwlt5gvkmw1mkeiphsdi4` FOREIGN KEY (`étudiantid`) REFERENCES `etudiant` (`id`),
  CONSTRAINT `FKbidw15hxbvv4nt9espjdi87kl` FOREIGN KEY (`projetid`) REFERENCES `projet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant_projet`
--

LOCK TABLES `etudiant_projet` WRITE;
/*!40000 ALTER TABLE `etudiant_projet` DISABLE KEYS */;
INSERT INTO `etudiant_projet` VALUES (1,13,7);
/*!40000 ALTER TABLE `etudiant_projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_de_cours`
--

DROP TABLE IF EXISTS `note_de_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_de_cours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` longblob,
  `document` varchar(255) DEFAULT NULL,
  `lien` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `coursid` int DEFAULT NULL,
  `professeurid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKti2mi55fheji4cgsx2g89hcm1` (`coursid`),
  KEY `FK6daho0so0246euncf4hvp9t6i` (`professeurid`),
  CONSTRAINT `FK6daho0so0246euncf4hvp9t6i` FOREIGN KEY (`professeurid`) REFERENCES `professeur` (`id`),
  CONSTRAINT `FKti2mi55fheji4cgsx2g89hcm1` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_de_cours`
--

LOCK TABLES `note_de_cours` WRITE;
/*!40000 ALTER TABLE `note_de_cours` DISABLE KEYS */;
INSERT INTO `note_de_cours` VALUES (1,NULL,'IntroAngular.pdf',NULL,'Angular',2,1),(2,NULL,'Intro3D.pdf',NULL,'3D',4,4),(3,NULL,'SpringBoot.pdf',NULL,'Spring Boot',2,1),(4,NULL,'Intro2D.pdf',NULL,'2D',4,4),(5,NULL,'DemoChezBio.zip',NULL,'Chez Bio',2,1),(6,NULL,'signalR.zip',NULL,'Introduction SignalR',5,7),(7,NULL,'SQLiteRoom.docx',NULL,'SQLite Room',3,3),(8,NULL,'git.docx',NULL,'Introduction Git',3,3);
/*!40000 ALTER TABLE `note_de_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `annee` int DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `note_obtenue` int DEFAULT NULL,
  `session` varchar(10) DEFAULT NULL,
  `coursid` int DEFAULT NULL,
  `professeurid` int DEFAULT NULL,
  `projetid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkennjb2swk3cj90nmjpiyjagq` (`coursid`),
  KEY `FK6oxwauyorwchusd1j74ptr6pm` (`professeurid`),
  KEY `FKm7uix3ykmugdnnx3786pu3y0l` (`projetid`),
  CONSTRAINT `FK6oxwauyorwchusd1j74ptr6pm` FOREIGN KEY (`professeurid`) REFERENCES `professeur` (`id`),
  CONSTRAINT `FKkennjb2swk3cj90nmjpiyjagq` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`),
  CONSTRAINT `FKm7uix3ykmugdnnx3786pu3y0l` FOREIGN KEY (`projetid`) REFERENCES `projet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
INSERT INTO `notes` VALUES (1,2023,'Excellent travail !',100,'2',2,1,1),(2,2023,'Très bien. ',95,'2',4,4,3),(3,2023,'Bien',82,'2',3,3,4),(4,2022,'Bravo !!',90,'1',6,8,5);
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participationcours`
--

DROP TABLE IF EXISTS `participationcours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participationcours` (
  `coursid` int NOT NULL,
  `étudiantid` int NOT NULL,
  PRIMARY KEY (`coursid`,`étudiantid`),
  KEY `FKcdb4cnbd6xhy8o5f3c4c0de3q` (`étudiantid`),
  CONSTRAINT `FKcdb4cnbd6xhy8o5f3c4c0de3q` FOREIGN KEY (`étudiantid`) REFERENCES `etudiant` (`id`),
  CONSTRAINT `FKceplhjkes0n3xj7eht7igjhju` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participationcours`
--

LOCK TABLES `participationcours` WRITE;
/*!40000 ALTER TABLE `participationcours` DISABLE KEYS */;
/*!40000 ALTER TABLE `participationcours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professeur` (
  `id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `data` longblob,
  `ddn` date DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `mot_de_passe` varchar(64) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `prenom` varchar(64) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6rpvhy4fq3n25yo0h6tw5jn32` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professeur`
--

LOCK TABLES `professeur` WRITE;
/*!40000 ALTER TABLE `professeur` DISABLE KEYS */;
INSERT INTO `professeur` VALUES (1,_binary '',NULL,'1980-01-01','dahamada@crosemont.qc.ca','Ahamada1234','Ahamada','ahamada.png','Dini','Professeur'),(2,_binary '',NULL,'1980-02-02','afahmi@crosemont.qc.ca','Fahmi1234','Fahmi','fahmi.png','Amine','Professeur'),(3,_binary '',NULL,'1980-03-03','plafrance@crosemont.qc.ca','Lafrance1234','Lafrance',NULL,'Patrick','Professeur'),(4,_binary '',NULL,'1980-04-04','hanoual@crosemont.qc.ca','Anoual1234','Anoual','','Hinde','Professeur'),(5,_binary '',NULL,'1980-05-05','mleduc@crosemont.qc.ca','Leduc1234','Leduc','leduc.png','Michel','Professeur'),(6,_binary '',NULL,'1980-06-06','jmassinon@crosemont.qc.ca','Massinon1234','Massinon','massinon.png','Jérémy','Professeur'),(7,_binary '',NULL,'1980-07-07','asahraoui@crosemont.qc.ca','Sahraoui1234','Sahraoui','sahraoui.png','Abderrazak','Professeur'),(8,_binary '',NULL,'1980-08-08','mlazar@crosemont.qc.ca','Lazar1234','Lazar',NULL,'Meriem','Professeur'),(9,_binary '',NULL,'1980-09-09','fkadima@crosemont.qc.ca','Florent1234','Florent Kpassi',NULL,'Adima','Professeur');
/*!40000 ALTER TABLE `professeur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professeur_cours`
--

DROP TABLE IF EXISTS `professeur_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professeur_cours` (
  `professeurid` int NOT NULL,
  `coursid` int NOT NULL,
  PRIMARY KEY (`professeurid`,`coursid`),
  KEY `FKfnk3jaqt4xb3q5vka2vrkgvgh` (`coursid`),
  CONSTRAINT `FKf3ar0qde7e4iv2osxywshwhmv` FOREIGN KEY (`professeurid`) REFERENCES `professeur` (`id`),
  CONSTRAINT `FKfnk3jaqt4xb3q5vka2vrkgvgh` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professeur_cours`
--

LOCK TABLES `professeur_cours` WRITE;
/*!40000 ALTER TABLE `professeur_cours` DISABLE KEYS */;
INSERT INTO `professeur_cours` VALUES (2,1),(1,2),(3,3),(4,4),(7,5),(5,7),(6,8),(9,8);
/*!40000 ALTER TABLE `professeur_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projet`
--

DROP TABLE IF EXISTS `projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `annee` int DEFAULT NULL,
  `data` longblob,
  `description` varchar(500) DEFAULT NULL,
  `lien_gitlab` varchar(255) DEFAULT NULL,
  `nom` varchar(100) NOT NULL,
  `video` varchar(255) DEFAULT NULL,
  `coursid` int DEFAULT NULL,
  `professeurid` int DEFAULT NULL,
  `ratingid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfhrpceoksgh8y2bfyp7pcr6ck` (`coursid`),
  KEY `FK5kp5r6pusbg9p1opkuym8f06f` (`professeurid`),
  KEY `FKiv5p2cy1vwg6mqb7tijly7atv` (`ratingid`),
  CONSTRAINT `FK5kp5r6pusbg9p1opkuym8f06f` FOREIGN KEY (`professeurid`) REFERENCES `professeur` (`id`),
  CONSTRAINT `FKfhrpceoksgh8y2bfyp7pcr6ck` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`),
  CONSTRAINT `FKiv5p2cy1vwg6mqb7tijly7atv` FOREIGN KEY (`ratingid`) REFERENCES `vote` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projet`
--

LOCK TABLES `projet` WRITE;
/*!40000 ALTER TABLE `projet` DISABLE KEYS */;
INSERT INTO `projet` VALUES (1,2023,NULL,'Un portail scolaire innovant permet aux élèves de présenter leurs projets réalisés pendant leurs cours. Ces projets, créés par de jeunes étudiants en informatique, mettent en valeur leur créativité et leur ingéniosité, offrant ainsi une expérience pratique en développement d\'applications web et les préparant à réussir dans l\'industrie technologique en constante évolution.','https://git.dti.crosemont.quebec/asarkes/portaildepartementinformatiqueanayeesfrancispatrickothmane','EdVolution','',2,1,NULL),(2,2023,NULL,'Une application de site de rencontre en ligne permettant aux individus de créer des profils, rechercher des correspondances potentielles et communiquer avec d\'autres personnes partageant des intérêts et des préférences similaires.',NULL,'Matchez-Moi','dOjpDZhpz4A',2,1,NULL),(3,2023,NULL,'Galaxion est un jeu en 2D captivant dans lequel le joueur doit affronter des astéroïdes et des ennemis. Le joueur doit manœuvrer habilement son vaisseau et tirer sur les astéroïdes pour les détruire, tout en évitant les attaques ennemies.','https://git.dti.crosemont.quebec/asarkes/galaxion','Galaxion','meRXxAeOF9w',4,4,NULL),(4,2023,NULL,'Le jeu du pendu est un classique où les joueurs doivent deviner un mot secret en proposant des lettres une par une. À chaque proposition incorrecte, une partie du pendu est dessinée. L\'objectif est de deviner correctement le mot avant que le pendu ne soit complété, ajoutant ainsi un élément de suspense et de défi au jeu.','https://git.dti.crosemont.quebec/asarkes/Pendu','Pendu',NULL,3,3,NULL),(5,2022,NULL,'Cette mini application native offre aux étudiants la possibilité de remplir un formulaire d\'inscription. Les étudiants peuvent saisir leurs informations personnelles telles que leur nom, leur adresse e-mail, leur date de naissance, etc. Une fois le formulaire rempli, les étudiants peuvent soumettre leurs informations pour finaliser leur inscription.','https://git.dti.crosemont.quebec/asarkes/inscriptionetudiant','Inscription Étudiant',NULL,6,8,NULL),(6,2022,NULL,'Tableu des vols d\'arrivée en temps réel','https://git.dti.crosemont.quebec/pnguyen/volsarriveesapi','Vols Arrivées',NULL,5,7,NULL),(7,2023,NULL,'testestest','www.google.com','test','',1,2,NULL);
/*!40000 ALTER TABLE `projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projet_visiteur`
--

DROP TABLE IF EXISTS `projet_visiteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projet_visiteur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `visiteur_id` int DEFAULT NULL,
  `data` longblob,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj4nxhkchjgqpetdqayrlt0vgd` (`visiteur_id`),
  CONSTRAINT `FKj4nxhkchjgqpetdqayrlt0vgd` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projet_visiteur`
--

LOCK TABLES `projet_visiteur` WRITE;
/*!40000 ALTER TABLE `projet_visiteur` DISABLE KEYS */;
/*!40000 ALTER TABLE `projet_visiteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_tutorat`
--

DROP TABLE IF EXISTS `service_tutorat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_tutorat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_tutorat` date NOT NULL,
  `duree` double NOT NULL,
  `heure` time NOT NULL,
  `type_de_rencontre` varchar(255) NOT NULL,
  `coursid` int DEFAULT NULL,
  `étudiant_tutoréid` int DEFAULT NULL,
  `étudiant_tuteurid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1b4d5wlrt3m0f2dad7yd7jloj` (`coursid`),
  KEY `FK6nxp7n0n7r7mfb2cejhm8n4m7` (`étudiant_tutoréid`),
  KEY `FK58hyrn1qmi1luk4pgifeha9bn` (`étudiant_tuteurid`),
  CONSTRAINT `FK1b4d5wlrt3m0f2dad7yd7jloj` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`),
  CONSTRAINT `FK58hyrn1qmi1luk4pgifeha9bn` FOREIGN KEY (`étudiant_tuteurid`) REFERENCES `etudiant` (`id`),
  CONSTRAINT `FK6nxp7n0n7r7mfb2cejhm8n4m7` FOREIGN KEY (`étudiant_tutoréid`) REFERENCES `etudiant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_tutorat`
--

LOCK TABLES `service_tutorat` WRITE;
/*!40000 ALTER TABLE `service_tutorat` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_tutorat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuteur_cours`
--

DROP TABLE IF EXISTS `tuteur_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuteur_cours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coursid` int DEFAULT NULL,
  `tuteurid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq9d0xep701wn0pm34b297w34d` (`coursid`),
  KEY `FKd33uxki4v8q1r2qurlltx0eyn` (`tuteurid`),
  CONSTRAINT `FKd33uxki4v8q1r2qurlltx0eyn` FOREIGN KEY (`tuteurid`) REFERENCES `etudiant` (`id`),
  CONSTRAINT `FKq9d0xep701wn0pm34b297w34d` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuteur_cours`
--

LOCK TABLES `tuteur_cours` WRITE;
/*!40000 ALTER TABLE `tuteur_cours` DISABLE KEYS */;
INSERT INTO `tuteur_cours` VALUES (1,2,2),(2,3,2),(3,8,5),(4,4,5),(5,7,4),(6,5,7),(7,5,9),(8,8,4),(9,6,2);
/*!40000 ALTER TABLE `tuteur_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visiteur` (
  `id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `data` longblob,
  `ddn` date DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `mot_de_passe` varchar(64) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `prenom` varchar(64) NOT NULL,
  `role` varchar(255) NOT NULL,
  `compagnie` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_aou8yl6m040da8n4udknt3x9l` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visiteur`
--

LOCK TABLES `visiteur` WRITE;
/*!40000 ALTER TABLE `visiteur` DISABLE KEYS */;
/*!40000 ALTER TABLE `visiteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rating` int DEFAULT NULL,
  `rating_average` double NOT NULL,
  `etudiantid` int DEFAULT NULL,
  `projetid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKle76h4o0iaso3dv0ptxyhnlmx` (`etudiantid`),
  KEY `FKdhbus3tkm10n5dec9vgkd5c0` (`projetid`),
  CONSTRAINT `FKdhbus3tkm10n5dec9vgkd5c0` FOREIGN KEY (`projetid`) REFERENCES `projet` (`id`),
  CONSTRAINT `FKle76h4o0iaso3dv0ptxyhnlmx` FOREIGN KEY (`etudiantid`) REFERENCES `etudiant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (1,2,0,NULL,1),(2,3,0,NULL,1),(3,3,0,NULL,1),(4,5,0,NULL,1);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `étudiant_cours`
--

DROP TABLE IF EXISTS `étudiant_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `étudiant_cours` (
  `étudiantid` int NOT NULL,
  `coursid` int NOT NULL,
  PRIMARY KEY (`étudiantid`,`coursid`),
  KEY `FKimynmh9rh9iy52dle5304oay1` (`coursid`),
  CONSTRAINT `FKgg49s0hmq49jk55u1h1lo5gmt` FOREIGN KEY (`étudiantid`) REFERENCES `etudiant` (`id`),
  CONSTRAINT `FKimynmh9rh9iy52dle5304oay1` FOREIGN KEY (`coursid`) REFERENCES `cours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `étudiant_cours`
--

LOCK TABLES `étudiant_cours` WRITE;
/*!40000 ALTER TABLE `étudiant_cours` DISABLE KEYS */;
INSERT INTO `étudiant_cours` VALUES (3,1),(1,2),(2,2),(1,3),(2,3),(3,3),(1,4),(2,4),(3,4),(5,4),(5,5),(4,7),(6,7);
/*!40000 ALTER TABLE `étudiant_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `étudiant_projet`
--

DROP TABLE IF EXISTS `étudiant_projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `étudiant_projet` (
  `étudiantid` int NOT NULL,
  `projetid` int NOT NULL,
  PRIMARY KEY (`étudiantid`,`projetid`),
  KEY `FK7wr94afhklmwmwnxf29pmq9qg` (`projetid`),
  CONSTRAINT `FK7wr94afhklmwmwnxf29pmq9qg` FOREIGN KEY (`projetid`) REFERENCES `projet` (`id`),
  CONSTRAINT `FKhaqumnb3qrhn442vik9ysfr3d` FOREIGN KEY (`étudiantid`) REFERENCES `etudiant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `étudiant_projet`
--

LOCK TABLES `étudiant_projet` WRITE;
/*!40000 ALTER TABLE `étudiant_projet` DISABLE KEYS */;
INSERT INTO `étudiant_projet` VALUES (1,1),(2,1),(3,1),(13,2),(1,3),(5,3),(1,4),(3,4),(1,5),(2,5),(3,6);
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

-- Dump completed on 2023-06-09  5:06:16
