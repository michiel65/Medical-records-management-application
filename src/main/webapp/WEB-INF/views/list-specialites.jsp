<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specialite</title>
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

   <input type="button" value="Ajout Specialite"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" /> <br />
   <br />
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title"> Liste Des Specialités</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>libelle</th>
       <th>Description</th>
       <th>Modifier | Supprimer</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempSpecialite" items="${specialites}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/specialite/updateForm">
        <c:param name="specialiteId" value="${tempSpecialite.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/specialite/delete">
        <c:param name="specialiteId" value="${tempSpecialite.id}" />
       </c:url>

       <tr>
        <td>${tempSpecialite.libelle}</td>
        <td>${tempSpecialite.description}</td>
      
		
        <td>
         <!-- display the update link --> <a href="${updateLink}">Modifier</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this Person?'))) return false">Supprimer</a>
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