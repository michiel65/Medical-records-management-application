<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<jsp:include page="_menu.jsp" />
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h3 class="text-center">Gestion Dossier Medicaux</h3>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Ajouter Un Patient</div>
    </div>
    <div class="panel-body">
     <form:form action="savePersonne" cssClass="form-horizontal"
      method="post" modelAttribute="personne">

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
       <label for="prenom" class="col-md-3 control-label">Prenom</label>
       <div class="col-md-9">
        <form:input type="text" path="prenom" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="sexe" class="col-md-3 control-label">Sexe</label>
       <div class="col-md-9">
        <form:select path="sexe" cssClass="form-control">
                <form:option selected="selected" value="Feminin">Feminin</form:option>
                <form:option value="Masculin">Masculin</form:option>
            </form:select>
       </div></div>
       
       <div class="form-group">
       <label for="profession" class="col-md-3 control-label">Profession</label>
       <div class="col-md-9">
        <form:input type="text" path="profession" cssClass="form-control" />
       </div></div>
       
        <div class="form-group">
       <label for="age" class="col-md-3 control-label">Age</label>
       <div class="col-md-9">
        <form:input type="number" path="age" cssClass="form-control" />
       </div></div>
      
		
		<div class="form-group">
       <label for="adresse" class="col-md-3 control-label">Adresse</label>
       <div class="col-md-9">
        <form:input type="text" path="adresse" cssClass="form-control" />
       </div></div>
       
       <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input type="adresse" path="email" cssClass="form-control" />
       </div></div>
       
  	  <form:hidden path="role" value="Patient"/>
  	  
  	  <form:hidden path="id_createur" value="Patient"/>
     
       <div class="form-group">
       <label for="dateNais" class="col-md-3 control-label">Date de Naissance</label>
       <div class="col-md-9">
        <form:input type="date" path="dateNais" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="lieuNais" class="col-md-3 control-label">Lieu de Naissance</label>
       <div class="col-md-9">
        <form:input path="lieuNais" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="login" class="col-md-3 control-label">Login</label>
       <div class="col-md-9">
        <form:input type="text" path="login" cssClass="form-control" />
       </div>
       </div>
       
       <div class="form-group">
       <label for="password" class="col-md-3 control-label">Mot de Passe</label>
       <div class="col-md-9">
        <form:input type="password" path="password" cssClass="form-control" />
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