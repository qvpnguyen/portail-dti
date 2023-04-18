<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>CrÃ©ation du dÃ©pÃ´t du projet - Portail du dÃ©partement de l'informatique</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Inclusion des fichiers Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <!-- Importation des polices (fonts) -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;600;700;900&display=swap">
        <!-- Inclusion du stylesheet principal -->
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body class="fond-blanc">
        <jsp:include page="/entete.jsp"/>
        
        <main style="background: none;">
            <div class="container px-5 d-flex justify-content-center">
                <div class="row">
                    <div class="boite-inscription mt-5">
                        
                       
                        
                        <form action="creationNotesController" method="get">
                            <div class="row mx-2 mt-4">
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="noteObtenue">la note du projet:</label>
                                        <input type="text" class="form-control" id="nom" name="noteObtenue">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="etudiant">Etudiants responsable:</label>
                                        <select name="etudiant" id="etudiant" class="form-select">
                                            <c:forEach var="etud" items="${listeEtudiants}">
                                                <option value="${etud.id}">${etud.prenom} ${etud.nom}</option>
                                            </c:forEach>
                                      </select>
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="session">Session:</label>
                                        <select name="session">
                                          <option value="automne">Automne</option>
                                          <option value="hiver">Hiver</option>
                                          <option value="été">Été</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="date">Date:</label>
                                        <input type="date" id="date" name="date">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="commentaire">Commentaire :</label>
                                        <input type="text" class="form-control" id="commentaire" name="commentaire">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="cours">Cours associé:</label>
                                        <select name="cours" id="cours" class="form-select">
                                            <c:forEach var="unCours" items="${listeCours}">
                                                <option value="${unCours.id}">${unCours.nom}</option>
                                            </c:forEach>
                                      </select>
                                    </div>
                                </div>
                                <div class="col-10">
                                    <div class="form-group my-3">
                                        <label for="projet">Projet associé:</label>
                                        <select name="projet" id="projet" class="form-select">
                                            <c:forEach var="unProjet" items="${listeProjets}">
                                                <option value="${unProjet.id}">${unProjet.nom}</option>
                                            </c:forEach>
                                      </select>
                                    </div>
                                </div>
                              
                            </div>
                            
                            <div class="d-grid gap-2 mt-4 mx-3">
                                <button  type="submit" class="btn bouton-mauve">
                                    <svg width="27" height="24" viewBox="0 0 27 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M0 0H27V23.5161H0V0Z" fill="white" fill-opacity="0.01"/>
                                    <path d="M23.0625 1.95898H3.93748C3.0055 1.95898 2.24998 2.61701 2.24998 3.42874V20.086C2.24998 20.8977 3.0055 21.5557 3.93748 21.5557H23.0625C23.9945 21.5557 24.75 20.8977 24.75 20.086V3.42874C24.75 2.61701 23.9945 1.95898 23.0625 1.95898Z" stroke="white" stroke-width="2" stroke-linejoin="round"/>
                                    <path d="M19.125 1.95898V10.7775H8.43751V1.95898H19.125Z" stroke="white" stroke-width="2" stroke-linejoin="round"/>
                                    <path d="M15.1875 5.38867V7.34835" stroke="white" stroke-width="2" stroke-linecap="round"/>
                                    <path d="M6.74823 1.95898H20.8116" stroke="white" stroke-width="2" stroke-linecap="round"/>
                                    </svg>
                                    Sauvegarder
                                </button>
                                <a href="https://git.dti.crosemont.quebec/" class="btn bouton-mauve">
                                    <img src="images/logo-onedrive.png" height="24" alt="Logo OneDrive"/>
                                    OneDrive
                                </a>
                            </div>
                        </form>            
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <p>&copy; 2023 DÃ©partement de l'informatique</p>
        </footer>
    </body>
</html>
