<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<jsp:include page="head.jsp" />
</head>

<body>
	<jsp:include page="BarreNavi.jsp" />

	<!-- Header -->
	<header class="w3-container w3-red w3-center"
		style="padding: 128px 16px">
		<h1 class="w3-margin w3-jumbo">Panier</h1>

		<p class="w3-xlarge">
			<c:if test="${user != null}">
			Bonjour <c:out value="${user.username}" /> !
			</c:if>
			<c:if test="${user == null}">
				<a href="/login">Connectez-vous</a> pour acheter l'un de nos panier !
			</c:if>
		</p>

		<p class="w3-xlarge">Voici nos panier !</p>

	</header>

	<div class="w3-container w3-center w3-light-grey">
		<form method="GET" class="form-horizontal">
			<c:if test="${query != null}">
				<input type="text" id="query" name="query" value="${query}" placeholder="Rechercher un panier" style="width:350px;">
			</c:if>
			<c:if test="${query == null}">
				<input type="text" id="query" name="query" placeholder="Rechercher un panier" style="width:350px;">
			</c:if>
			<input type="submit" value="Chercher" class="w3-button w3-red w3-padding-large w3-large w3-margin-top w3-margin-bottom"/>
		</form>
	</div>

	<div class="Commercant">
		<c:forEach items="${ListCommercant}" var="Commercant" varStatus="loopStatus">
			<c:if test="${loopStatus.index%2==0}">
				<div class="w3-row-padding w3-padding-64 w3-container">
					<div class="w3-content">
						<div class="w3-twothird">
							<h1>
								<c:out value="${Commercant.name}" />
							</h1>
							<h5 class="w3-padding-8">
								<c:out value="${Commercant.categorie}" />
							</h5>
							<h5 class="w3-padding-8">
								à
								<c:out value="${Commercant.local}" />
							</h5>
							<p class="w3-text-grey">
								<c:out value="${Commercant.priix}" />
							</p>
						</div>

						<div class="w3-third w3-center" style="padding: 128px;">
							<a href="/Commercant?id=<c:out value="${Commercant.id}"/>"
								class="w3-button w3-red w3-padding-large w3-large w3-margin-top">En
								savoir plus</a>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${loopStatus.index%2==1}">
				<div class="w3-row-padding w3-light-grey w3-padding-64 w3-container">
					<div class="w3-content">
						<div class="w3-third w3-center" style="padding: 128px;">
							<a href="/Panier?id=<c:out value="${Panier.id}"/>"
								class="w3-button w3-red w3-padding-large w3-large w3-margin-top">En
								savoir plus</a>
						</div>
						<div class="w3-twothird">
							<h1>
								<c:out value="${Panier.utili}" />
							</h1>
							<h5 class="w3-padding-8">
								<c:out value="${Panier.Commercant}" />
							</h5>
							<h5 class="w3-padding-8">
								à
								<c:out value="${Panier.local}" />
							</h5>
							<p class="w3-text-grey">
								<c:out value="${Panier.description}" />
							</p>
							<p class="w3-text-grey">
								<c:out value="${Panier.categorie}" />
							</p>
							<p class="w3-text-grey">
								<c:out value="${Panier.prix}" />
							</p>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>

</body>
</html>