<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hopital</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h3 class="text-center">Gestion de Dossiers Medicaux</h3>
   <hr />

   <input type="button" value="Ajout un Hopital"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" /> <br />
   <br />
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title"> Liste des Hopitaux</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Nom</th>
       <th>adresse</th>
       <th>coordonnee</th>
       <th>descriprion</th>
       <th>Modifier | Supprimer</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempHopital" items="${hopitals}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/hopital/updateForm">
        <c:param name="hopitalId" value="${tempHopital.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/hopital/delete">
        <c:param name="hopitalId" value="${tempHopital.id}" />
       </c:url>

       <tr>
        <td>${tempHopital.nom}</td>
        <td>${tempHopital.adresse}</td>
        <td>${tempHopital.description}</td>
        <td>${tempHopital.coordonnee}</td>
		
		
        <td>
         <!-- display the update link --> <a href="${updateLink}">Modifier</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this Hopital?'))) return false">Supprimer</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <div class="footer">
  <p>Footer</p>
 </div>
</body>

</html>