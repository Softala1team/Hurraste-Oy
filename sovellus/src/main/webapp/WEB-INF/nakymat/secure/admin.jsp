<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<%=request.getContextPath()%>/resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 

<title>Admin sivu</title>
<link href="../resources/styles/frontpage.css" rel="stylesheet" type="text/css">
<style>
body {
background: lightblue;
}
th {
font-size: 17px;
} 
</style>

</head>
<body>

<div id="header">
<h3>SUOJATTU PÄÄSIVU</h3>
<p>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></p>

</div>

       <div align="center">
           <h4>Tapahtumat</h4>
           
           <table border="1">
           <th>Poista</th>
           <th>Hyväksy</th>
           		<th>Onko hyväksytty</th>
            <th>ID</th>
               <th>Järjestäjän nimi</th>
               <th>Puhelinnumero</th>
               <th>Email</th>
               <th>Tapahtuman nimi</th>
               <th>Paikka</th>
               <th>Kuvaus</th>
               <th>Aloitus aika</th>
               <th>Lopetus aika</th>
               <th>Max osallistujat</th>
               <c:forEach var="tapahtuma" items="${listTapahtuma}" varStatus="status">
               <tr>
					<td><a href="${poistaTapahtuma}">poista</a></td>
					<td><a href="hyvaksy?id=${tapahtuma_id}">hyväksy</a></td>
					
					<td>${tapahtuma.hyvaksytty}</td>

                   <td>${tapahtuma.tapahtumaId}</td>
                   
                   <td>${tapahtuma.jar_nimi}</td>
                   
                   <td>${tapahtuma.puh_num}</td>
                   
                   <td>${tapahtuma.email}</td>
                   
                   <td>${tapahtuma.tapahtuma_nimi}</td>

                   <td>${tapahtuma.tapahtuma_paikka}</td>
                   
                   <td>${tapahtuma.kuvaus}</td>
                   
                   <td>${tapahtuma.tapahtuma_aika}</td>
                   <td>${tapahtuma.loppumis_aika}</td>
                   <td>${tapahtuma.max_osallistujamaara}</td>
                   
				
               </tr>
               </c:forEach>       
           </table>
       </div>

<div id="footer">
<p><a href="/sovellus">Pääsivulle ja kirjaudu ulos</a></p>
</div>
</body>
</html>