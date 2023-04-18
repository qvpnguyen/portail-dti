<%@page import="com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%
    ArrayList<Notes> listeNotes = (ArrayList) request.getAttribute("listeNotes");
    Notes tnotes = (Notes) request.getAttribute("prof");

%>
<html>
    <head>
        <title>Projets - Portail du département de l'informatique</title>
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
        <main>

            <div class="container conteneur-table bg-light p-5 mt-5">

                <style>
                    th, td {
                        padding: 0 10px;
                    }
                    td {
                        width: 20%;
                        position: relative;
                    }


                </style>
                 <% if( request.getAttribute("message")!=null) { %>
                      <center><b><font color=red> <%=request.getAttribute("message")  %></font></b></center>
               <%}%>


                <a href="creationNotesController" class="btn bouton-mauve mb-5">Ajouter une note a un projet</a>   
                <table id="tableNotesCours" class="display">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>nom du Projet</th>
                            <th>Session</th>
                            <th>Ann�e</th>
                            <th>Nom de l'etudiant</th>
                            <th>Cours</th>
                            <th>Note obtenue</th>
                            <th>Commentaire</th>
                            <th>Modifier la note </th>
                            <th>Supprimer la note </th>

                        </tr>
                    </thead>
                    <tbody>
                        <%                                                    if (tnotes != null) {%>
                        <tr>
                            <td> <%=tnotes.getProjetID().getNom()%> </td>

                            <td> <%=tnotes.getSession()%> </td>
                            <td> <%=tnotes.getAnnee()%> </td>
                            <td> <%=tnotes.getEtudiantID().getPrenom() + " " + tnotes.getEtudiantID().getNom()%> </td>
                            <td> <%=tnotes.getCoursID().getNom()%> </td>
                            <td> <%=tnotes.getNoteObtenue() + "%"%> </td>
                            <td> <%=tnotes.getCommentaire()%> </td>

                            <td>
                                <a href="">
                                    <svg width="21" height="21" viewBox="0 0 21 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M14.8183 1.99162C15.1654 1.64454 15.3384 1.47153 15.5114 1.35548C15.8584 1.12371 16.2662 1 16.6835 1C17.1007 1 17.5086 1.12371 17.8555 1.35548C18.0285 1.47153 18.2015 1.64454 18.5486 1.99162C18.8946 2.33764 19.0677 2.5117 19.1837 2.68366C19.4157 3.03071 19.5395 3.43878 19.5395 3.85623C19.5395 4.27369 19.4157 4.68176 19.1837 5.02881C19.0677 5.20076 18.8946 5.37483 18.5486 5.72085L7.11932 17.1501C6.84082 17.4297 6.70051 17.569 6.5391 17.6797C6.37664 17.7905 6.19625 17.8696 5.83546 18.0279L4.8649 18.4551C2.76978 19.3771 1.72116 19.8381 1.21162 19.3286C0.70103 18.818 1.16204 17.7705 2.08407 15.6743L2.51132 14.7037C2.66956 14.3429 2.74974 14.1625 2.85945 14.0011C2.97128 13.8387 3.11053 13.6994 3.39009 13.4209L14.8183 1.99162Z" stroke="black" stroke-width="2" stroke-linecap="round"/>
                                    <path d="M11.9246 4.84766L15.6549 8.57795" stroke="black" stroke-width="2"/>
                                    </svg>
                                </a>
                            </td>

                        </tr>

                        <% } else {  %>
                        <%
                            for (Notes user : listeNotes) {%>
                        <tr>
                            <td> <%= user.getId()%> </td>

                            <td> <%= user.getProjetID().getNom()%> </td>
                            <td> <%=user.getSession()%> </td>
                            <td> <%=user.getAnnee()%> </td>
                            <td> <%=user.getEtudiantID().getPrenom() + " " + user.getEtudiantID().getNom()%> </td>
                            <td> <%=user.getCoursID().getNom()%> </td>
                            <td> <%=user.getNoteObtenue() + "%"%> </td>
                            <td> <%=user.getCommentaire()%> </td>

                            <td>
                                <form method="get" action="modificationNotesController">
                                    <input type="hidden" name="supprimer" value="<%= user.getId()%>">
                                    <button type="submit">
                                        <svg width="20" height="24" viewBox="0 0 20 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M1 8.94444L2.39757 18.7662C2.68429 20.7829 2.82829 21.7924 3.55471 22.3962C4.28243 23 5.35214 23 7.49414 23H12.5059C14.6479 23 15.7189 23 16.4453 22.3962C17.1717 21.7924 17.3157 20.7829 17.6024 18.7662L19 8.94444M6.14286 4.66667C6.14286 3.52756 6.14286 2.958 6.33829 2.50944C6.46752 2.21267 6.65701 1.94301 6.89593 1.71588C7.13485 1.48876 7.41852 1.30863 7.73071 1.18578C8.20257 1 8.80171 1 10 1C11.1983 1 11.7974 1 12.2693 1.18578C12.5815 1.30863 12.8651 1.48876 13.1041 1.71588C13.343 1.94301 13.5325 2.21267 13.6617 2.50944C13.8571 2.958 13.8571 3.52756 13.8571 4.66667M19 4.66667H1M6.78571 9.55556L7.42857 18.7222M13.2143 9.55556L12.5714 18.7222" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                        </svg>
                                    </button>
                                </form>


                            </td>
                            <td>
                                <button  onclick="showForm(<%= user.getId()%>)">
                                    <svg width="21" height="21" viewBox="0 0 21 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M14.8183 1.99162C15.1654 1.64454 15.3384 1.47153 15.5114 1.35548C15.8584 1.12371 16.2662 1 16.6835 1C17.1007 1 17.5086 1.12371 17.8555 1.35548C18.0285 1.47153 18.2015 1.64454 18.5486 1.99162C18.8946 2.33764 19.0677 2.5117 19.1837 2.68366C19.4157 3.03071 19.5395 3.43878 19.5395 3.85623C19.5395 4.27369 19.4157 4.68176 19.1837 5.02881C19.0677 5.20076 18.8946 5.37483 18.5486 5.72085L7.11932 17.1501C6.84082 17.4297 6.70051 17.569 6.5391 17.6797C6.37664 17.7905 6.19625 17.8696 5.83546 18.0279L4.8649 18.4551C2.76978 19.3771 1.72116 19.8381 1.21162 19.3286C0.70103 18.818 1.16204 17.7705 2.08407 15.6743L2.51132 14.7037C2.66956 14.3429 2.74974 14.1625 2.85945 14.0011C2.97128 13.8387 3.11053 13.6994 3.39009 13.4209L14.8183 1.99162Z" stroke="black" stroke-width="2" stroke-linecap="round"/>
                                    <path d="M11.9246 4.84766L15.6549 8.57795" stroke="black" stroke-width="2"/>
                                    </svg>
                                </button>

                                <form id="form-<%= user.getId()%>" style="display:none;" action="modificationNotesController" method="get">
                                    <input type="hidden" name="id" value="<%= user.getId()%>">
                                    <input type="text" name="noteObtenue">
                                    <input type="submit"  value="Envoyer" />

                                </form>
                            </td>


                        </tr>
                    <style>
                        #form-<%= user.getId()%> {
                            display: none;
                            position: absolute;
                            top: 0;
                            left: 50%;
                            width: 50%;
                        }

                        #form-<%= user.getId()%> input[type="text"] {
                            width: 50%;
                        }
                    </style>

                    <% }
                        }%>
                    </tbody>
                </table>
                <a href="professeur.jsp" class="btn bouton-mauve mb-5">Revenir a l'acceuil</a>   
            </div>

        </main>
        <footer>
            <p>&copy; 2023 Département de l'informatique</p>
        </footer>
      
    </body>
    <script>
        function showForm(id) {
            var form = document.getElementById("form-" + id);
            if (form.style.display === "none") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
         $(document).ready( function () {
                $('#tableNotesCours').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.13.2/i18n/fr-FR.json"
                    }, "searching": false
                });
            } );
    </script>
</html>
