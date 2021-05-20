<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Editer un commercant</title>
<jsp:include page="head.jsp" />
</head>

<body>
<jsp:include page="BarreNavi.jsp"/>

<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:64px 16px">
  <h1 class="w3-margin w3-jumbo">Editer un commercant</h1>
  <p class="w3-xlarge">Veuillez saisir les informations :</p>
</header>

<div class="w3-container w3-center">
<form  method="POST" class="form-horizontal">
	
	<c:if test="${event.id != null}">
		<input type="hidden" id="id" name="id" value="0"/>
	</c:if>
	<br>
	<div class="form-group">
	<label for="name">prenom</label>
	<input type="text" id="name" name="name" value="<c:out value="${Commercant.name}"/>" placeholder="Titre" autofocus />
	</div><br>
	<div class="form-group">
	<label for="location">Lieu</label>
	<input type="text" id="location" name="location" value="<c:out value="${Commercant.local}"/>" placeholder="Lieu" />
	</div><br>
	<div class="form-group">
	<label for="categorie">Categorie</label>
	<input type="text" id="categorie" name="description" value="<c:out value="${Commercant.categorie}"/>" placeholder="Categorie" />
	</div><br>
	<div class="form-group">
	<label for="tags">Priix</label>
	<input type="text" id="tags" name="tags" value="<c:out value="${Commercant.priix}"/>" placeholder="Priix" />
	</div><br>

	<div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="w3-button w3-red w3-padding-large w3-large w3-margin-top">Valider</button>
      </div>
	</div>
</form>
</div>

</body>
</html>