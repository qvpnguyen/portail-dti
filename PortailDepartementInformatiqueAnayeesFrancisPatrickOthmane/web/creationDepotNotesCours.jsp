<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
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

                        <% if (request.getAttribute("message") != null) {%>
                        <center><b><font color=red> <%=request.getAttribute("message")%></font><b></center>
                                    <%}%>

                                    <form action="creationNotesCoursController" method="get">
                                        <div class="row mx-2 mt-4">
                                            <div class="col-10">
                                                <div class="form-group my-3">
                                                    <label for="nomProjet">Nom de notes de cours:</label>
                                                    <input type="text" class="form-control" id="nom" name="nom">
                                                </div>
                                            </div>
                                            <div class="col-10">
                                                <div class="form-group my-3">
                                                    <label for="professeur">Professeur responsable:</label>
                                                    <input type="text" class="form-control" id="professeur" name="professeur" value="LE PROFESSEUR AUTHENTIFIÃ DYNAMIQUEMENT" disabled>
                                                </div>
                                            </div>
                                            <div class="col-10">
                                                <div class="form-group my-3">
                                                    <label for="membresEquipe">Lien URL:</label>
                                                    <input type="text" class="form-control" id="lien" name="lien">
                                                </div>
                                            </div>
                                            <div class="col-10">
                                                <div class="form-group my-3">
                                                    <label for="cours">Cours associÃ©:</label>
                                                    <input type="text" class="form-control" id="cours" name="cours">
                                                </div>
                                            </div>
                                            <div class="col-10">
                                                <div class="form-group my-3">
                                                    <label for="video">TÃ©lÃ©versez votre document de notes de cours:</label>
                                                    <div class="row">
                                                        <div class="col-8">
                                                            <input type="file" class="form-control mt-2" id="documentNotesCours" name="documentNotesCours">
                                                        </div>
                                                        <div class="col-4 mt-2">
                                                            <button type="button" class="btn bouton-mauve">
                                                                <svg width="17" height="20" viewBox="0 0 17 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M8.54878 14.7195V1.87793M8.54878 1.87793L12.6883 6.34964M8.54878 1.87793L4.40921 6.34964" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                                <path d="M1.09756 12.3413V15.195C1.09756 16.989 1.09756 17.8851 1.58272 18.4425C2.06788 18.9999 2.84777 18.9999 4.40922 18.9999H12.6883C14.2498 18.9999 15.0297 18.9999 15.5148 18.4425C16 17.8851 16 16.989 16 15.195V12.3413" stroke="white" stroke-width="2" stroke-linecap="round"/>
                                                                </svg>
                                                                TÃ©lÃ©verser
                                                            </button>
                                                        </div>
                                                    </div>
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
                                    <jsp:include page="/pied.jsp"/>

                                    </body>
                                    </html>
