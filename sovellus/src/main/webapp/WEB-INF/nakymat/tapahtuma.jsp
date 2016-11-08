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
<script src='../resources/moment.min.js'></script>

<title>${harrastus.tapahtuma_nimi}</title>
<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 
</head>
<body>

<div style="text-align:center;">

<div id=header>
	<h3>${harrastus.tapahtuma_nimi}</h3>
	<div style="background-color:white;">
		<p id="aika"></p>
		<p>${harrastus.kuvaus}</p>
		<p>${harrastus.tapahtuma_paikka}<br>
		<a href="https://www.google.fi/maps/search/${harrastus.tapahtuma_paikka}"><small>Etsi kartalta</small></a></p>
		<!--<iframe
		  width="600"
		  height="450"
		  frameborder="0" style="border:0"
		  src="https://www.google.com/maps/embed/v1/place?key=YOUR_API_KEYPERKELE
		    &q=${harrastus.tapahtuma_paikka}" allowfullscreen>
		</iframe>-->
		<p>${harrastus.jar_nimi}</p>
		<p>Osallistujia:<br>${harrastus.osallistujamaara}/${harrastus.max_osallistujamaara}</p>
	</div>
</div>

</div>
<script>
console.log('id: ${harrastus.tapahtumaId} Loppumisaika: ${harrastus.loppumis_aika}');
if (moment('${harrastus.tapahtuma_aika}').isSame('${harrastus.loppumis_aika}', 'day')) {
	//console.log("on sama päivä");
	var pvm = moment('${harrastus.tapahtuma_aika}').format('DD.MM.YYYY<br>HH:mm');
	var lpvm = moment('${harrastus.loppumis_aika}').format('HH:mm');
	document.getElementById("aika").innerHTML = '<small>Aikataulu</small><br>'+pvm+" - "+lpvm;
} else {
	var pvm = moment('${harrastus.tapahtuma_aika}').format('DD.MM.YYYY HH:mm');
	var lpvm = moment('${harrastus.loppumis_aika}').format('DD.MM.YYYY HH:mm');
	document.getElementById("aika").innerHTML = '<small>Alkaa</small><br>'+pvm+"<br><small>Loppuu</small><br>"+lpvm;
}
</script>
</body>
</html>
