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
	<p><a href="/sovellus/sovellus/jalkapallo">Takaisin</a></p>
	<h3>${harrastus.tapahtuma_nimi}</h3>
</div>
<div>
	
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
	<p>Osallistujia:<br>${harrastus.osallistujamaara}/${harrastus.max_osallistujamaara}<br><small>esim merkki<br>matti esim</small></p>
</div>

<form:form modelAttribute="x" method="post" name="x">
<table id="lomaketable">
	<caption style="color:red; font-size:20px;"><c:out value="${virheviesti}"/></caption>
	<thead>
		<tr>
			<td class="lomaketd"><h3 id="lomakeh3">Osallistu:</h3></td>
		</tr>
		<tr>
			<td class="jarjestajantiedot"><form:label path="jar_nimi">Nimi: </form:label></td>
			<td class="lomaketd"><form:input path="jar_nimi" name="jar_nimi" placeholder="Etunimi Sukunimi"/><c:out value="${tietovirhe}"/></td>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="puh_num">Puhelinnumero: </form:label></td>
			<td class="lomaketd"><form:input path="puh_num" name="puh_num" placeholder="0441234567"/><c:out value="${tietovirhe}"/></td>
		</tr>
	</thead>
</table>
</form:form>

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
