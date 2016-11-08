<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<title>Ilmoita t��ll�</title>
</head>
<body>
<div id=header>

	<div class="navdrop">
	<button class="dropbtn">Muut aktiviteetit</button>
	<div class="navdrop-content" style="left:0;">
		<a href="/sovellus">Etusivu</a>
		<a class="active" href="/jalkapallo">Jalkapallo</a>
		<a href="kutominen.jsp">Kutominen</a>
		<a href="ruoanlaitto.jsp">Ruoanlaitto</a>
		<a href="salibandy.jsp">Salibandy</a>
	</div>
	</div>
	<div id="otsikko">
	<h2>Luo oma tapahtumasi</h2>
	</div>
</div>

<form:form modelAttribute="harraste" method="post" name="luoTapahtuma">
<table>
	<thead>
		<tr>
			<th><form:label path="jar_nimi">J�rjest�j�n nimi</form:label></th>
			<td><form:input path="jar_nimi" name="jar_nimi"/></td>
			
			<th><form:label path="puh_num">Puhelinnumero</form:label></th>
			<td><form:input path="puh_num" name="puh_num"/></td>
			
			<th><form:label path="email">Email</form:label></th>
			<td><form:input path="email" name="email"/></td>
		</tr>
		<tr>
			<th><form:label path="tapahtuma_paikka">Tapahtuman paikka</form:label></th>
			<td><form:input path="tapahtuma_paikka" name="tapahtuma_paikka"/></td>
			
			
			<th><form:label path="tapahtuma_nimi">Tapahtuman nimi</form:label></th>
			<td><form:input path="tapahtuma_nimi" name="tapahtuma_nimi"/></td>
		</tr>
		<tr>
			<th><form:label path="kuvaus">Tapahtuman kuvaus</form:label></th>
			<td><form:input path="kuvaus" name="kuvaus"/></td>
			
			<th><form:label path="tapahtuma_aika">Tapahtuman alkuaika</form:label></th>
			<td><form:input path="tapahtuma_aika" name="tapahtuma_aika"/></td>
		</tr>
		
		<tr>
			<th><form:label path="loppumis_aika">Tapahtuman loppumisaika</form:label>
			<td><form:input path="loppumis_aika" name="loppumis_aika"/></td>
		</tr>

		<tr>
			<th><form:label path="max_osallistujamaara">Osallistujia enint��n</form:label></th>
			<td><form:input path="max_osallistujamaara" name="max_osallistujamaara"/>
		</tr>
		<tr>
			<th>
			<button type="submit">Laita ilmoitus!</button>
			</th>
		</tr>
		
	</thead>
</table>
</form:form>
</body>
</html>