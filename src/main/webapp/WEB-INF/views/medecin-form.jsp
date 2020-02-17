<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personne</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h3 class="text-center">Gestion Dossier Medicaux</h3>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Ajouter Patient</div>
    </div>
    <div class="panel-body">
     <form:form action="saveMedecin" cssClass="form-horizontal"
      method="post" modelAttribute="medecin" >

      <!-- need to associate this data with cPerson id -->
      <form:hidden path="idPersonne" />

      <div class="form-group">
       <label for="personne.nom" class="col-md-3 control-label">
        Nom</label>
       <div class="col-md-9">
        <form:input type="text" path="personne.nom" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="personne.prenom" class="col-md-3 control-label">Prenom</label>
       <div class="col-md-9">
        <form:input type="text" path="personne.prenom" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="personne.sexe" class="col-md-3 control-label">Sexe</label>
       <div class="col-md-9">
        <form:select path="personne.sexe" cssClass="form-control">
                <form:option selected="selected" value="Feminin">Feminin</form:option>
                <form:option value="Masculin">Masculin</form:option>
            </form:select>
       </div></div>
      
       
       <div class="form-group">
       <label for="personne.age" class="col-md-3 control-label">Age</label>
       <div class="col-md-9">
        <form:input type="number" path="personne.age" cssClass="form-control" />
       </div></div>
      
		
		<div class="form-group">
       <label for="personne.adresse" class="col-md-3 control-label">Adresse</label>
       <div class="col-md-9">
        <form:input type="text" path="personne.adresse" cssClass="form-control" />
       </div></div>
       
       <div class="form-group">
       <label for="personne.email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input type="email" path="personne.email" cssClass="form-control" />
       </div></div>
       
     
        <form:hidden path="personne.profession" value="Medecin"/>
         <form:hidden path="personne.role" value="Medecin"/>
       
     
       <div class="form-group">
       <label for="personne.datenais" class="col-md-3 control-label">Date de Naissance</label>
       <div class="col-md-9">
        <form:input type="date" path="personne.datenais"  cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="personne.lieunais" class="col-md-3 control-label">Lieu de Naissance</label>
       <div class="col-md-9">
        <form:input path="personne.lieunais" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="personne.login" class="col-md-3 control-label">Login</label>
       <div class="col-md-9">
        <form:input type="text" path="personne.login" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="personne.password" class="col-md-3 control-label">Mot de Passe</label>
       <div class="col-md-9">
        <form:input type="password" path="personne.password" cssClass="form-control" />
       </div>
       </div>
       
       
        <div class="form-group">
       <label for="hopital1.id" class="col-md-3 control-label">Hopital d'exercice</label>
       <div class="col-md-9">
        
         <form:select path="hopital1.id" cssClass="form-control">
         <c:forEach var="tempHos" items="${hopitals}">
                <form:option value="${tempHos.id}">${tempHos.nom}</form:option>
          </c:forEach>     
            </form:select>
       </div>
       </div>
       
       
        <div class="form-group">
       <label for="specialite1.id" class="col-md-3 control-label">Spécialité</label>
       <div class="col-md-9">
        
         <form:select path="specialite1.id" cssClass="form-control">
         <c:forEach var="tempSpe" items="${specialites}">
                <form:option value="${tempSpe.id}">${tempSpe.libelle}</form:option>
          </c:forEach>     
            </form:select>
       </div>
       </div>
       
       
       
       
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
        <form:button type="reset" cssClass="btn btn-danger">Reset</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>