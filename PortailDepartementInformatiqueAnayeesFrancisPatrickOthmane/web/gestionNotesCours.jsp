<%@page import="com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<%
    ArrayList<NoteDeCours> listeNotesCours = (ArrayList) request.getAttribute("listeNotesCours");
    NoteDeCours tnotes = (NoteDeCours) request.getAttribute("notes");
%>
<html>
    <head>
        <title>Gestion des notes de cours - Portail du dÃÂ©partement de l'informatique</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Inclusion des fichiers Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <!-- Importation des polices (fonts) -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400;600;700;900&display=swap">
        <!-- Inclusion de jQuery -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
        <!-- Inclusion des fichiers pour le plugin DataTables -->
        <link href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
        <!-- Inclusion du stylesheet principal -->
        <link rel="stylesheet" href="css/style.css"/>
        <!-- Script pour gÃÂ©nÃÂ©rer les donnÃÂ©es des utilisateurs avec jQuery dans DataTables -->
        <script>
            $(document).ready(function () {
                $('#tableNotesCours').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.13.2/i18n/fr-FR.json"
                    }, "searching": false
                });
            });
        </script>
    </head>
    <body class="fond-blanc">
        <jsp:include page="/entete.jsp"/>

        <main>
            <div class="container conteneur-table bg-light p-5 mt-5">
                <h4>Chercher notes de cours par nom : </h4>
                <form action="notesDeCoursController" method="get"> 
                    <input type="search" name="note">
                    <input type="submit"  value="rechercher" />
                </form>




                <a href="creationNotesCoursController" class="btn bouton-mauve mb-5">Ajouter une note de cours</a>

                <table id="tableNotesCours" class="display">
                    <% if (request.getAttribute("message") != null) {%>
                    <center><b><font color=red> <%=request.getAttribute("message")%></font></b></center>
                            <%}%>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Cours</th>
                            <th>Lien</th>
                            <th>Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (tnotes != null && !tnotes.equals("")) {%>
                        <tr>
                            <td> <%=tnotes.getId()%> </td>

                            <td> <%=tnotes.getNom()%> </td>
                            <td> <%=tnotes.getCours().getNom()%> </td>
                            <td> <%=tnotes.getLien()%> </td>
                            <td>
                                <form method="get" action="notesDeCoursController">
                                    <input type="hidden" name="supprimerNoteDeCours" value="<%= tnotes.getId()%>">
                                    <button type="submit">
                                        <svg width="20" height="24" viewBox="0 0 20 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M1 8.94444L2.39757 18.7662C2.68429 20.7829 2.82829 21.7924 3.55471 22.3962C4.28243 23 5.35214 23 7.49414 23H12.5059C14.6479 23 15.7189 23 16.4453 22.3962C17.1717 21.7924 17.3157 20.7829 17.6024 18.7662L19 8.94444M6.14286 4.66667C6.14286 3.52756 6.14286 2.958 6.33829 2.50944C6.46752 2.21267 6.65701 1.94301 6.89593 1.71588C7.13485 1.48876 7.41852 1.30863 7.73071 1.18578C8.20257 1 8.80171 1 10 1C11.1983 1 11.7974 1 12.2693 1.18578C12.5815 1.30863 12.8651 1.48876 13.1041 1.71588C13.343 1.94301 13.5325 2.21267 13.6617 2.50944C13.8571 2.958 13.8571 3.52756 13.8571 4.66667M19 4.66667H1M6.78571 9.55556L7.42857 18.7222M13.2143 9.55556L12.5714 18.7222" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                        </svg>
                                    </button>
                                </form>
                            </td>

                        </tr>

                        <% } else {  %>
                        <%
                            for (NoteDeCours user : listeNotesCours) {%>
                        <tr>
                            <td> <%=user.getId()%> </td>

                            <td> <%=user.getNom()%> </td>
                            <td> <%=user.getCours().getNom()%> </td>
                            <td> <%=user.getLien()%> </td>
                            <td>
                                <form method="get" action="notesDeCoursController">
                                    <input type="hidden" name="supprimerNoteDeCours" value="<%= user.getId()%>">
                                    <button type="submit">
                                        <svg width="20" height="24" viewBox="0 0 20 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M1 8.94444L2.39757 18.7662C2.68429 20.7829 2.82829 21.7924 3.55471 22.3962C4.28243 23 5.35214 23 7.49414 23H12.5059C14.6479 23 15.7189 23 16.4453 22.3962C17.1717 21.7924 17.3157 20.7829 17.6024 18.7662L19 8.94444M6.14286 4.66667C6.14286 3.52756 6.14286 2.958 6.33829 2.50944C6.46752 2.21267 6.65701 1.94301 6.89593 1.71588C7.13485 1.48876 7.41852 1.30863 7.73071 1.18578C8.20257 1 8.80171 1 10 1C11.1983 1 11.7974 1 12.2693 1.18578C12.5815 1.30863 12.8651 1.48876 13.1041 1.71588C13.343 1.94301 13.5325 2.21267 13.6617 2.50944C13.8571 2.958 13.8571 3.52756 13.8571 4.66667M19 4.66667H1M6.78571 9.55556L7.42857 18.7222M13.2143 9.55556L12.5714 18.7222" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                        </svg>
                                    </button>
                                </form>
                            </td>

                        </tr>

                        <% }
                            }%>
                    </tbody>
                </table>
            </div>

        </main>
        <jsp:include page="/pied.jsp"/>

    </body>
</html>
