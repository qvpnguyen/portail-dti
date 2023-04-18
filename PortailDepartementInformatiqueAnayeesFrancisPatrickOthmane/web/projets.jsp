
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao" />

<html>
    <head>
        <title>Projets - Portail du dÃ©partement de l'informatique</title>
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
    <body>
        <jsp:include page="/entete.jsp"/>

        <main class="section-principale">
            <%-- <c:choose>
                <c:when test="${empty listeProjets}">
                    <p>Aucun projet trouvé.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="projet" items="${listeProjets}">
                        <p>${projet.nom}</p>
                    </c:forEach>
                </c:otherwise>
            </c:choose> 
            <c:forEach var="teacher" items="${listeProfesseurs}">
                <p>${listeProfesseurs.nom}</p>
            </c:forEach>--%>
            <c:choose>
                <c:when test="${empty listeProjets}">
                    <p class="navbar-brand">Aucun résultat trouvé.</p>
                </c:when>
                <c:otherwise>
                    <div class="container px-5">
                        <h2 class="p-5 text-center">Ces ensembles des projets sont rÃ©alisÃ©s par des étudiants en informatique au cours de leur parcours scolaire qui témoignent de la créativité et de l'ingéniosité de la prochaine gÃ©nÃ©ration de dÃ©veloppeurs. GrÃ¢ce Ã  ces projets, les Ã©tudiants en informatique ont acquis une expÃ©rience pratique en dÃ©veloppement des applications de Web et se sont positionnÃ©s pour rÃ©ussir dans l'industrie technologique rapide et en constante Ã©volution.</h2>

                        <c:forEach var="projet" items="${listeProjets}" varStatus="status">
                            <c:if test="${status.index % 2 == 0}">
                                <div class="rangee-projet row gx-5">
                                    <div class="col-4">
                                        <div class="carte-video">
                                            <img class="video-projet" src="images/play-button-icon.png" alt="Jouer"/>
                                            <div class="conteneur-infos-projet">
                                                <a href="ProjetEtudiantsController?nomProjet=${projet.nom}"><h4 class="mt-2">${projet.nom}</h4></a>
                                                <p><i>${projet.description}</i></p>
                                                <ul>
                                                    <c:forEach var="etudiant" items="${dao.findEtudiantsParProjet(projet.nom)}" varStatus="status">
                                                        <li>${fn:toUpperCase(etudiant.nom)} ${fn:toUpperCase(etudiant.prenom)}</li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8">
                                        <div class="carte-description p-4">
                                            <p>${projet.description}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${status.index % 2 != 0}">
                                <div class="rangee-projet row gx-5">
                                    <div class="col-8">
                                        <div class="carte-description p-4">
                                            <p>${projet.description}</p>
                                        </div>
                                    </div> 
                                    <div class="col-4">
                                        <div class="carte-video">
                                            <img class="video-projet" src="images/play-button-icon.png" alt="Jouer"/>
                                            <div class="conteneur-infos-projet">
                                                <a href="ProjetEtudiantsController?nomProjet=${projet.nom}"><h4 class="mt-2">${projet.nom}</h4></a>
                                                <p><i>${projet.description}</i></p>
                                                <ul>
                                                    <c:forEach var="etudiant" items="${dao.findEtudiantsParProjet(projet.nom)}" varStatus="status">
                                                        <li>${fn:toUpperCase(etudiant.nom)} ${fn:toUpperCase(etudiant.prenom)}</li>
                                                        </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </main>
        <jsp:include page="/pied.jsp"/>

    </body>
</html>
