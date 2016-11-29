<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<form:form modelAttribute="osallistuja" method="post" name="osallistuja">
<table id="lomaketable">
	<caption style="color:${vari}; font-size:20px;"><c:out value="${viesti}"/></caption>
	<thead>
		<tr class="lomaketr">
			<th class="lomaketd" colspan="2"><h3 id="lomakeh3">Osallistu:</h3></th>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="etunimi">Etunimi: </form:label></td>
			<td class="lomaketd"><form:input path="etunimi" name="etunimi" /></td>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="sukunimi">Sukunimi: </form:label></td>
			<td class="lomaketd"><form:input path="sukunimi" name="sukunimi" /></td>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="puh_nro">Puhelinnumero: </form:label></td>
			<td class="lomaketd"><form:input path="puh_nro" name="puh_nro"/></td>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="email">Sähköposti: </form:label></td>
			<td class="lomaketd"><form:input path="email" name="email" /></td>
		</tr>
		<tr class="lomaketr">
			<td class="lomaketd"><form:label path="tapahtuma_id">Osallistut tapahtumaan nro: </form:label></td>
			<td class="lomaketd"><form:input path="tapahtuma_id" disabled="true" value="${harrastus.tapahtumaId}"></form:input></td>
		</tr>
		<tr>
			<td class="lomaketd"><button type="submit">Osallistu tästä</button></td>
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
