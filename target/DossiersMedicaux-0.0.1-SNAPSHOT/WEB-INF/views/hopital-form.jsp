<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopital</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h3 class="text-center">Gestion Dossier Medicaux</h3>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Ajouter Hopital</div>
    </div>
    <div class="panel-body">
     <form:form action="saveHopital" cssClass="form-horizontal"
      method="post" modelAttribute="hopital">

      <!-- need to associate this data with cPerson id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for="nom" class="col-md-3 control-label">
        Nom</label>
       <div class="col-md-9">
        <form:input type="text" path="nom" cssClass="form-control" />
       </div>
      </div>
     
       
  
      
		
		<div class="form-group">
       <label for="adresse" class="col-md-3 control-label">Adresse</label>
       <div class="col-md-9">
        <form:input type="text" path="adresse" cssClass="form-control" />
       </div></div>
       
 
       
       <div class="form-group">
       <label for="description" class="col-md-3 control-label">Description</label>
       <div class="col-md-9">
        <form:input type="textarea" path="description" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="coordonnee" class="col-md-3 control-label">Coordonnee</label>
       <div class="col-md-9">
        <form:input type="coordonee" path="coordonnee" cssClass="form-control" />
       </div>
       </div>
       
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>