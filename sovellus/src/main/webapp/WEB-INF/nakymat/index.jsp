<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<meta charset="ISO-8859-1">
<title>Etusivu</title>

<spring:url value="resources/styles/frontpage.css" var="frontpageCSS" />

<link rel="stylesheet" href="${frontpageCSS}">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 

</head>
<body>
<div id="header">
<h1>HARRASTEMAATTI</h1>
<h3>Löydä kaikenlaista tekemistä!</h3>
</div>

<div id="contentbox">
 <!-- 
<table>
	<tr>
		<th><a id=jalka href=sovellus/jalkapallo>Jalkapallo</a></th> <th><a id=sali href=salibandy.jsp>Salibandy</a></th>
	</tr>
	<tr>
		<th><a id=kuto href=kutominen.jsp>Kutominen</a></th><th><a id=ruoan href=ruoanlaitto.jsp>Ruoanlaitto</a></th>
	</tr>
</table>
 -->
</div>
<br>
<div id="buttonbox">
<div class="pallobutton">
<div id="palloA">
		<a href=sovellus/jalkapallo class="pallobutton">Tapahtumat</a>
</div>
<div id="palloB">
		<a href=sovellus/luoIlmoitus class="pallobutton">Luo oma tapahtumasi</a>
</div>
 <!-- <br>
<div id="palloC">
		<a href=sovellus/salibandy class="pallobutton">Salibandy</a>
</div>
<div id="palloD">
		<a href=sovellus/ruoanlaitto class="pallobutton">Ruoanlaitto</a>
</div>-->
</div>
</div>

<br>
<br>
</body>
</html>