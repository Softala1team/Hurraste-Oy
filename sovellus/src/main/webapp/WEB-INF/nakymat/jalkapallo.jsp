<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 

<title>Jalkapallokalenteri</title>
</head>
<body onload="teeKalenteri()">

<div id=header>

<div class="navdrop">
<button class="dropbtn">Muut aktiviteetit</button>
<div class="navdrop-content" style="left:0;">
	<a href="etusivu.jsp">Etusivu</a>
	<a class="active" href="jalkapallo.jsp">Jalkapallo</a>
	<a href="kutominen.jsp">Kutominen</a>
	<a href="ruoanlaitto.jsp">Ruoanlaitto</a>
	<a href="salibandy.jsp">Salibandy</a>
</div>
</div>
<div id="otsikko">
<h2>Jalkapallo</h2>
</div>
</div>

<div id="kalenteri">
<table style="width:85%;margin:auto;">
	
	<tr>
		<th id=tyhja></th>
		<th>Ma</th>
		<th>Ti</th>
		<th>Ke</th>
		<th>To</th>
		<th>Pe</th>
		<th>La</th>
		<th>Su</th>
	</tr>
	<tr class=tunti><th><small>8:00</small></th></tr>
	<tr class=tunti><th><small>9:00</small></th></tr>
	<tr class=tunti><th><small>10:00</small></th></tr>
	<tr class=tunti><th><small>11:00</small></th></tr>
	<tr class=tunti><th><small>12:00</small></th></tr>
	<tr class=tunti><th><small>13:00</small></th></tr>
	<tr class=tunti><th><small>14:00</small></th></tr>
	<tr class=tunti><th><small>15:00</small></th></tr>
	<tr class=tunti><th><small>16:00</small></th></tr>
	<tr class=tunti><th><small>18:00</small></th></tr>
	<tr class=tunti><th><small>19:00</small></th></tr>
	<tr class=tunti><th><small>20:00</small></th></tr>
	<tr class=tunti><th><small>21:00</small></th></tr>
	<tr class=tunti><th><small>22:00</small></th></tr>
	<tr class=tunti><th><small>23:00</small></th></tr>
</table>
</div>
<script src="resources/scripts.js"></script>
</body>
</html>
