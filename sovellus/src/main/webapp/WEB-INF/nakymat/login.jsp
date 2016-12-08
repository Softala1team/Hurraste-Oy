<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sisäänkirjautuminen</title>
<link href="../resources/styles/frontpage.css" rel="stylesheet" type="text/css">

<style>
body {
background: lightblue;
}
</style>
</head>
<body>

<a href="/sovellus">Etusivu</a>

<div id="sisalto">
	<h1>KIRJAUDU SISÄÄN</h1>

	<c:if test="${not empty loginerror}">
		<p class="Error">Sisäänkirjautuminen epäonnistui. Käyttäjätunnus tai salasana on syötetty väärin.</p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info">Uloskirjautuminen onnistui</p>
	</c:if>
	
	<form action="j_spring_security_check" method="post">
	<fieldset>
		<table>
		<tr><td>USERNAME:</td><td><input type='text' name='j_username' value=''></td></tr>
		<tr><td>PASSWORD:</td><td><input type='password' name='j_password' /></td></tr>
		<tr><td>&nbsp;</td><td><button type="submit">Kirjaudu</button></td></tr>
		</table>
	</fieldset>
	</form>
	</div>
	

</body>
</html>