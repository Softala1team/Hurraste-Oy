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

<script>



</script>

</head>
<body>
<div id="header">
<h3>SUOJATTU PÄÄSIVU</h3>
<p>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></p>
</div>

       <div align="center">
           <h4>Tapahtumat</h4>
           
           <table border="1">
               <th>No</th>
               <th>jar_nimi</th>
               <th>tapahtuma_paikka</th>
               <c:forEach var="tapahtuma" items="${listTapahtuma}" varStatus="status">
               <tr>

                   <td>${status.index + 1}</td>

                   <td>${tapahtuma.jar_nimi}</td>

                   <td>${tapahtuma.tapahtuma_paikka}</td>

               </tr>
               </c:forEach>       
           </table>
       </div>

<div id="footer">
<p><a href="/sovellus">Pääsivu</a></p>
<p><a href="/haeKaikki">Päivitä kaikki tapahtumat</a></p>
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p> <!-- tarvitaanko?? -->
</div>
</body>
</html>