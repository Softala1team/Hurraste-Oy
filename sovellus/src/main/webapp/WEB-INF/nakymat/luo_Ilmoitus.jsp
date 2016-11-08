<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet">
<!-- <link href='../resources/jquery-ui.min.css' rel='stylesheet' type='text/css'> -->

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<script>
  $( function() {
	  $( ".valitsepvm" ).datepicker({
		  dateFormat: "yy-mm-dd",
		  dayNames:["Sunnuntai", "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai"],
		  dayNamesMin:["Su", "Ma", "Ti", "Ke", "To", "Pe", "La"],
		  monthNames:["Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu"],
		  monthNamesMin:["Tam", "Hel", "Maa", "Huh", "Tou", "Kes", "Hei", "Elo", "Syys", "Loka", "Marras", "Joulu"],
	  });
  });
</script>

<title>Ilmoita täällä</title>
</head>
<body>
<div id=header>

<a href="/sovellus">Etusivu</a>
	
	<div id="otsikko">
	<h2 style="margin-top:-75px;margin-bottom:450px">Luo oma tapahtumasi</h2>
	</div>
</div>

<form:form modelAttribute="harraste" method="post" name="luoTapahtuma">
<table>
	<thead>
		<tr>
			<th><form:label path="jar_nimi">Järjestäjän nimi</form:label></th>
			<td><form:input path="jar_nimi" name="jar_nimi" ng-model="jar_nimi"/></td>
			
			<th><form:label path="puh_num">Puhelinnumero</form:label></th>
			<td><form:input path="puh_num" name="puh_num" ng-model="puh_num"/></td>
			
		</tr>
		<tr>
			<th><form:label path="email">Email</form:label></th>
			<td><form:input path="email" name="email" ng-model="email"/></td>
			
			<th><form:label path="tapahtuma_paikka">Tapahtuman paikka</form:label></th>
			<td><form:input path="tapahtuma_paikka" name="tapahtuma_paikka" ng-model="tapahtuma_paikka"/></td>
		</tr>
		<tr>
			<th><form:label path="tapahtuma_nimi">Tapahtuman nimi</form:label></th>
			<td><form:input path="tapahtuma_nimi" name="tapahtuma_nimi" ng-model="tapahtuma_nimi"/></td>
			
			<th><form:label path="kuvaus">Tapahtuman kuvaus</form:label></th>
			<td><form:input path="kuvaus" name="kuvaus" ng-model="kuvaus"/></td>
		</tr>
		
		<tr>
			<th><form:label path="tapahtuma_aika">Tapahtuman alkuaika</form:label></th>
			<td><form:input class="valitsepvm" path="tapahtuma_aika" name="tapahtuma_aika"/></td>
		
			<th><form:label path="loppumis_aika">Tapahtuman loppumisaika</form:label>
			<td><form:input class="valitsepvm" path="loppumis_aika" name="loppumis_aika"/></td>
		</tr>

		<tr>
			<th><form:label path="max_osallistujamaara">Osallistujia enintään</form:label></th>
			<td><form:input path="max_osallistujamaara" name="max_osallistujamaara" ng-model="max_osallistujamaara"/>
		</tr>
		<tr>
			<th>
			<button type="submit">Laita ilmoitus!</button>
			</th>
		</tr>
		
	</thead>
</table>
</form:form>
</body>
</html>
