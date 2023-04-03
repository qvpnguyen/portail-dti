<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Inscription - Portail du département de l'informatique</title>
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

        <main class="d-flex align-items-center h-50 mt-5 main-index-inscription">
            <div class="container px-5 d-flex justify-content-center">
                <div class="row">
                    <div class="boite-inscription">

                        <form action="" method="post">
                            <div class="d-flex justify-content-center">
                                <div class="btn-group mt-5" role="group" aria-label="Login radio toggle button group">
                                    <input type="radio" class="btn-check" name="btnradio" id="btnetudiant" value="Étudiant" autocomplete="off" checked>
                                    <label class="btn btn-outline-dark" for="btnetudiant">Étudiant</label>

                                    <input type="radio" class="btn-check" name="btnradio" id="btnprofesseur" value="Professeur" autocomplete="off">
                                    <label class="btn btn-outline-dark" for="btnprofesseur">Professeur</label>

                                    <input type="radio" class="btn-check" name="btnradio" id="btnvisiteur" value="Visiteur" autocomplete="off">
                                    <label class="btn btn-outline-dark" for="btnvisiteur">Visiteur</label>
                                </div>
                            </div>
                            <div class="row gx-5 mx-2">
                                <div class="col-6">
                                    <div class="form-group my-3">
                                        <label for="prenom">Prénom:</label>
                                        <input type="text" class="form-control" id="prenom" name="prenom">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group my-3">
                                        <label for="nom">Nom:</label>
                                        <input type="text" class="form-control" id="nom" name="nom">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group my-3">
                                        <label for="dateDeNaissance">Date de naissance:</label>
                                        <input type="date" class="form-control" id="dateDeNaissance" name="dateDeNaissance">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group my-3">
                                        <label for="profil">Profil:</label>
                                        <select name="profil" id="profil" class="form-select">
                                            <option value="">---</option>
                                            <option value="Programmation">Programmation</option>
                                            <option value="Réseautique">Réseautique</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group my-3">
                                        <label for="numeroUtilisateur">Numéro d'utilisateur:</label>
                                        <input type="text" class="form-control" id="numeroUtilisateur" name="numeroUtilisateur">
                                    </div>
                                    <div class="form-group my-3">
                                        <label for="courriel">Courriel:</label>
                                        <input type="email" class="form-control" id="courriel" name="courriel" placeholder="courriel@dti.crosemont.quebec">
                                    </div>
                                    <div class="form-group my-3">
                                        <label for="nomUtilisateur">Nom d'utilisateur:</label>
                                        <input type="text" class="form-control" id="nomUtilisateur" name="nomUtilisateur" placeholder="pNom">
                                    </div>
                                    <div class="form-group my-3">
                                        <label for="motDePasse">Mot de passe:</label>
                                        <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Entrez votre mot de passe">
                                    </div>
                                    <div class="form-group my-3">
                                        <label for="confirmerMotDePasse">Confirmer le mot de passe:</label>
                                        <input type="password" class="form-control" id="confirmerMotDePasse" name="confirmerMotDePasse" placeholder="Confirmez votre mot de passe">
                                    </div>
                                </div>
                            </div>

                            <div class="text-center mt-4">
                                <input type="submit" class="btn btn-dark" value="Soumettre"/>
                            </div>
                        </form>
                        <div class="text-center mt-4">
                            <p><a href="projets.html" class="text-dark">Continuer en tant que visiteur <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M21.883 12l-7.527 6.235.644.765 9-7.521-9-7.479-.645.764 7.529 6.236h-21.884v1h21.883z"/></svg></a></p>
                            <!--<p>Pas de compte? <a href="" class="text-dark">Cliquez ici</a></p>-->
                        </div>              
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="/pied.jsp"/>
    </body>
</html>
