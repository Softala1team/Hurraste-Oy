<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Etusivu</title>
<link rel="stylesheet" type="text/css" href="resources/styles/frontpage.css">
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
		<a href=sovellus/jalkapallo class="pallobutton">Jalkapallo</a>
</div>
<div id="palloB">
		<a href=sovellus/kutominen class="pallobutton">Kutominen</a>
</div>
<br>
<div id="palloC">
		<a href=sovellus/salibandy class="pallobutton">Salibandy</a>
</div>
<div id="palloD">
		<a href=sovellus/ruoanlaitto class="pallobutton">Ruoanlaitto</a>
</div>
</div>
</div>

<!-- <form action="https://goo.gl/forms/vYOYW7IjdWpRHmsi1"> -->
<form action="sovellus/luoIlmoitus">
 <button id=lisaa_oma>Lisää oma tapahtuma</button> 
</form>
<!-- <a href="sovellus/luoIlmoitus">Luo testidataa kantaan tästä!</a> -->
<br>
<br>
</body>
</html>