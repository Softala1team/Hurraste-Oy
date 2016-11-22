<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Admin sivu</title>
<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="header">
<a href="/sovellus">
<img src="../resources/images/home2.png" alt="etusivu" style="height:75px;width:70px;padding:3px;border:2px solid grey;border-radius:700px;box-shadow:5px 5px 2px 2px #888888;">
</a>
</div>
<h1>SUOJATTU PÄÄSIVU</h1>

<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

<p><a href="/sovellus">Pääsivu</a></p>
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p> <!-- href?? -->

</body>
</html>