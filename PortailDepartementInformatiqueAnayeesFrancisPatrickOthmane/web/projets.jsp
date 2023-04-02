
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            </c:choose> --%>

            <h2 class="p-5 text-center">Ces ensembles des projets sont rÃ©alisÃ©s par des étudiants en informatique au cours de leur parcours scolaire qui témoignent de la créativité et de l'ingéniosité de la prochaine gÃ©nÃ©ration de dÃ©veloppeurs. GrÃ¢ce Ã  ces projets, les Ã©tudiants en informatique ont acquis une expÃ©rience pratique en dÃ©veloppement des applications de Web et se sont positionnÃ©s pour rÃ©ussir dans l'industrie technologique rapide et en constante Ã©volution.</h2>
            <div class="container px-5">
                <c:choose>
                    <c:when test="${empty listeProjets}">
                        <p>Aucun projet trouvé.</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="projet" items="${listeProjets}" varStatus="status">
                            <c:if test="${status.index % 2 != 0}">
                                <div class="rangee-projet row gx-5">
                                    <div class="col-4">
                                        <div class="carte-video">
                                            <img class="video-projet" src="images/play-button-icon.png" alt="Jouer"/>
                                            <div class="conteneur-infos-projet">
                                                <h4 class="mt-2">${projet.nom}</h4>
                                                <p><i>${projet.description}</i></p>
                                                <p>Réalisé par: Anayees Sarkes, Francis Martel, Patrick Nguyen, Othmane Sedjari</p>
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
                            <c:if test="${status.index % 2 == 0}">
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
                                                <h4 class="mt-2">${projet.nom}</h4>
                                                <p><i>${projet.description}</i></p>
                                                <p>Réalisé par: Anayees Sarkes, Francis Martel, Patrick Nguyen, Othmane Sedjari</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                                <div class="rangee-projet row gx-5">
                                    <div class="col-4">
                                        <div class="carte-video">
                                            <img class="video-projet" src="images/play-button-icon.png" alt="Jouer"/>
                                            <div class="conteneur-infos-projet">
                                                <h4 class="mt-2">Nom du projet</h4>
                                                <p><i>Lorem ipsum dolor sit amet, oblique oporteat quaestio an his, no vis adipisci forensibus, admodum invidunt ea sea.</i></p>
                                                <p>Réalisé par: Anayees Sarkes, Francis Martel, Patrick Nguyen, Othmane Sedjari</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8">
                                        <div class="carte-description p-4">
                                            <p>Lorem ipsum dolor sit amet, oblique oporteat quaestio an his, no vis adipisci forensibus, admodum invidunt ea sea. Ut sed simul maiestatis. Ius ad dicant molestie delicatissimi. Semper mandamus ut nec, mei menandri inimicus aliquando ei, vim numquam omnesque offendit ea. Accusamus dignissim quo an, mel at admodum mandamus eloquentiam. Vel et dico dicat praesent, sit ad corpora mediocritatem.</p>
                                        </div>
                                    </div>
                                </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </main>
        <jsp:include page="/pied.jsp"/>

    </body>
</html>
