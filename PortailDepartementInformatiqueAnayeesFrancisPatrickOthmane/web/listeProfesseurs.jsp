<%@page import="java.util.ArrayList"%>
<%@page import="com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%  
    ArrayList<Professeur> listeProfesseurs = (ArrayList)request.getAttribute("listeProfesseurs");
    Professeur tnotes = (Professeur) request.getAttribute("prof");

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
                 <h4>Chercher Professeur par nom : </h4>
                <form action="professeurController" method="get"> 
                    <input type="search" name="nomProf">
                    <input type="submit"  value="rechercher" />
                </form>

                
                <style>
                  th, td {
                    padding: 0 10px;
                  }
                 </style>
                
               
                <table id="tableNotesCours" class="display">
                    <thead>
                        <tr>
                             <th>ID</th>
                            <th>Nom</th>
                            <th>Email</th>
                            <th>Profil</th>
                            <th>Photo</th>
                            <th>Modifier</th>
                           
                        </tr>
                    </thead>
                    <tbody>
                                                <%  
     if(tnotes!=null ){%>
      <tr>
      <td> <%=tnotes.getId() %> </td>
  
      <td> <%=tnotes.getNom() +" "+ tnotes.getPrenom() %> </td>
     <td> <%=tnotes.getEmail() %> </td>
      <td> <%=tnotes.getProfil() %> </td>
      <td> <%=tnotes.getPhoto() %> </td>
      
      <td>
            <a href="">
                <svg width="21" height="21" viewBox="0 0 21 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M14.8183 1.99162C15.1654 1.64454 15.3384 1.47153 15.5114 1.35548C15.8584 1.12371 16.2662 1 16.6835 1C17.1007 1 17.5086 1.12371 17.8555 1.35548C18.0285 1.47153 18.2015 1.64454 18.5486 1.99162C18.8946 2.33764 19.0677 2.5117 19.1837 2.68366C19.4157 3.03071 19.5395 3.43878 19.5395 3.85623C19.5395 4.27369 19.4157 4.68176 19.1837 5.02881C19.0677 5.20076 18.8946 5.37483 18.5486 5.72085L7.11932 17.1501C6.84082 17.4297 6.70051 17.569 6.5391 17.6797C6.37664 17.7905 6.19625 17.8696 5.83546 18.0279L4.8649 18.4551C2.76978 19.3771 1.72116 19.8381 1.21162 19.3286C0.70103 18.818 1.16204 17.7705 2.08407 15.6743L2.51132 14.7037C2.66956 14.3429 2.74974 14.1625 2.85945 14.0011C2.97128 13.8387 3.11053 13.6994 3.39009 13.4209L14.8183 1.99162Z" stroke="black" stroke-width="2" stroke-linecap="round"/>
                <path d="M11.9246 4.84766L15.6549 8.57795" stroke="black" stroke-width="2"/>
                </svg>
            </a>
       </td>
 
     </tr>
   
   <% }else{  %>
                        <%  
     for( Professeur user : listeProfesseurs){%>
      <tr>
      <td> <%=user.getId() %> </td>
  
      <td> <%=user.getNom() + user.getPrenom() %> </td>
     <td> <%=user.getEmail() %> </td>
      <td> <%=user.getProfil() %> </td>
      <td> <%=user.getPhoto() %> </td>
      
      <td>
            <a href="">
                <svg width="21" height="21" viewBox="0 0 21 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M14.8183 1.99162C15.1654 1.64454 15.3384 1.47153 15.5114 1.35548C15.8584 1.12371 16.2662 1 16.6835 1C17.1007 1 17.5086 1.12371 17.8555 1.35548C18.0285 1.47153 18.2015 1.64454 18.5486 1.99162C18.8946 2.33764 19.0677 2.5117 19.1837 2.68366C19.4157 3.03071 19.5395 3.43878 19.5395 3.85623C19.5395 4.27369 19.4157 4.68176 19.1837 5.02881C19.0677 5.20076 18.8946 5.37483 18.5486 5.72085L7.11932 17.1501C6.84082 17.4297 6.70051 17.569 6.5391 17.6797C6.37664 17.7905 6.19625 17.8696 5.83546 18.0279L4.8649 18.4551C2.76978 19.3771 1.72116 19.8381 1.21162 19.3286C0.70103 18.818 1.16204 17.7705 2.08407 15.6743L2.51132 14.7037C2.66956 14.3429 2.74974 14.1625 2.85945 14.0011C2.97128 13.8387 3.11053 13.6994 3.39009 13.4209L14.8183 1.99162Z" stroke="black" stroke-width="2" stroke-linecap="round"/>
                <path d="M11.9246 4.84766L15.6549 8.57795" stroke="black" stroke-width="2"/>
                </svg>
            </a>
       </td>
 
     </tr>
   
   <% } } %>
                    </tbody>
                </table>
     <a href="professeur.jsp" class="btn bouton-mauve mb-5">Revenir a l'acceuil</a>          
    </div>
            
        </main>
        <footer>
            <p>&copy; 2023 Département de l'informatique</p>
        </footer>
    </body>
</html>
