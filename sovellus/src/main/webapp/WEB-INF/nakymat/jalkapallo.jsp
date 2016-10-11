<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 

<title>Jalkapallokalenteri</title>
</head>
<body onload="teeKalenteri()">

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
<script type="text/javascript">

	//var val1="${harrasteet.get(0).getTapahtuma_nimi()}";
	//console.log("${harrasteet.get(0)}");
	var pituus="${lkm}";
	var lista=[];
	
	for (i = 0; i < pituus; i++) {
		lista[i]=[];
		lista[i][0]="30";
		lista[i][1]="${harrasteet.get(i).getTapahtuma_nimi()}";
		lista[i][2]="${harrasteet.get(i).getKuvaus()}";
		lista[i][3]="Osallistujat: ${harrasteet.get(i).getOsallistujamaara()}/${harrasteet.get(i).getMax_osallistujamaara()}";
		lista[i][4]="${harrasteet.get(i).getJar_nimi()}";
		lista[i][5]="${harrasteet.get(i).getTapahtuma_paikka()}";
		lista[i][6]="${harrasteet.get(i).getTapahtuma_aika()}";
		//console.log(lista[i][3]); 
	}
    
</script>
<script src="../resources/script.js"></script>
</body>
</html>
