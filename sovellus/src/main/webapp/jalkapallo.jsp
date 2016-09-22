<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 

<title>Jalkapallokalenteri</title>
</head>
<body onload="teeKalenteri()">

<div id=header>
<h2>Kalenteri</h2>
<nav class="navigaatio">
<ul class="paavalikko">
	<li><a href="etusivu.jsp">Etusivu</a></li>
	<li><a href="jalkapallo.jsp">Jalkapallo</a></li>
	<li><a href="kutominen.jsp">Kutominen</a></li>
	<li><a href="ruoanlaitto.jsp">Ruoanlaitto</a></li>
	<li><a href="salibandy.jsp">Salibandy</a></li>
</ul>
</nav>
</div>

<div id="kalenteri">
<table style="width:100%;height:100%;">
	
	<tr>
		<th id=tyhja></th>
		<th>Maanantai</th>
		<th>Tiistai</th>
		<th>Keskiviikko</th>
		<th>Torstai</th>
		<th>Perjantai</th>
		<th>Lauantai</th>
		<th>Sunnuntai</th>
	</tr>
	<tr class=tunti><th>8-9</th></tr>
	<tr class=tunti><th>9-10</th></tr>
	<tr class=tunti><th>10-11</th></tr>
	<tr class=tunti><th>11-12</th></tr>
	<tr class=tunti><th>12-13</th></tr>
	<tr class=tunti><th>14-15</th></tr>
	<tr class=tunti><th>15-16</th></tr>
	<tr class=tunti><th>16-17</th></tr>
	<tr class=tunti><th>18-19</th></tr>
	<tr class=tunti><th>19-20</th></tr>
	<tr class=tunti><th>20-21</th></tr>
	<tr class=tunti><th>21-22</th></tr>
	<tr class=tunti><th>22-23</th></tr>
	<tr class=tunti><th>23-00</th></tr>
</table>
</div>
<script src="scripts.js"></script>
</body>
</html>
