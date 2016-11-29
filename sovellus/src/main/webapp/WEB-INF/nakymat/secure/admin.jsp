<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Admin sivu</title>
<link href="../resources/styles/frontpage.css" rel="stylesheet" type="text/css">
<style>
body {
background: lightblue;
}
</style>
</head>
<body>
<div id="header">
</div>
<h1>SUOJATTU PÄÄSIVU</h1>

<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="admin/tools">Admin tools</a></p>
</sec:authorize>


<p><a href="/sovellus">Pääsivu</a></p>
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p> <!-- href?? -->

</body>
</html>