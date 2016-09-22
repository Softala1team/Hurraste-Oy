<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="styles/style.css" rel="stylesheet" type="text/css">

<title>JalkapallokalenteriTEST</title>
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
	<tr class=tunti><th><small>8-9</small></th></tr>
	<tr class=tunti><th><small>9-10</small></th></tr>
	<tr class=tunti><th><small>10-11</small></th></tr>
	<tr class=tunti><th><small>11-12</small></th></tr>
	<tr class=tunti><th><small>12-13</small></th></tr>
	<tr class=tunti><th><small>14-15</small></th></tr>
	<tr class=tunti><th><small>15-16</small></th></tr>
	<tr class=tunti><th><small>16-17</small></th></tr>
	<tr class=tunti><th><small>18-19</small></th></tr>
	<tr class=tunti><th><small>19-20</small></th></tr>
	<tr class=tunti><th><small>20-21</small></th></tr>
	<tr class=tunti><th><small>21-22</small></th></tr>
	<tr class=tunti><th><small>22-23</small></th></tr>
	<tr class=tunti><th><small>23-00</small></th></tr>
</table>
</div>
<script src="TESTIscript.js"></script>
</body>
</html>
