<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src='../resources/jquery.min.js'></script>
<link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.min.css' rel='stylesheet' />
<link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.print.css' rel='stylesheet' media='print' />
<link href='../resources/jquery-ui.min.css' rel='stylesheet' type='text/css'>
<script src='../resources/moment.min.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.min.js'></script>
<script src='../resources/fi.js'></script>
<script src='../resources/jquery-ui.min.js'></script>



<link href="../resources/styles/style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Yatra+One" rel="stylesheet"> 
<script>

	$(document).ready(function() {
		var initialLocaleCode = 'fi';
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listMonth'
			},
			defaultDate: $('#calendar').fullCalendar('getDate'),
			defaultView: 'month',
			//theme:true,
			navLinks: true,
			weekNumbers: false,
			editable: false,
			eventLimit: true,
			eventRender: function (event, element) {
		        element.attr('href', 'javascript:void(0);');
		        element.click(function() {
		            $("#startTime").html(moment(event.start).format('Do MMMM HH:mm'));
		            $("#endTime").html(moment(event.end).format('Do MMMM HH:mm'));
		            $("#eventInfo").html(event.description);
		            $("#paikka").html(event.paikka);
		            $("#jarj").html(event.jarj);
		            $("#osallistujia").html(event.osallistujia);
		            $("#eventLink").attr('href', event.urli);
		            $("#eventContent").dialog({ modal: true, title: event.title, width:450, closeText: "Sulje" });
		        });
		    }
		});
		//var aa="$";
		for (i = 0, len=parseInt("${lkm}"); i < len; i++) {
			var newEvent = {
					title: '${harrasteet.get(i).getTapahtuma_nimi()}',
	                start: '${harrasteet.get(i).getTapahtuma_aika()}',
	                //end: '${harrasteet.get(i).getTapahtuma_aika()}',
	                description: '${harrasteet.get(i).getKuvaus()}',
	                paikka: '${harrasteet.get(i).getTapahtuma_paikka()}',
	                jarj: "${harrasteet.get(i).getJar_nimi()}",
	                osallistujia: '${harrasteet.get(i).getOsallistujamaara()}/${harrasteet.get(i).getMax_osallistujamaara()}',
	                urli: '/sovellus/${harrasteet.get(i).getTapahtumaId()}'
	                //allDay: false,
	            };
	            $('#calendar').fullCalendar( 'renderEvent', newEvent,'stick');
		}
	});

</script>
<title>Jalkapallokalenteri</title>
</head>
<body>

<div id="eventContent" title="Event Details" style="display:none;">
    Alkaa: <span id="startTime"></span><br>
    Loppuu: <span id="endTime"></span><br>
    <small>Järjestäjä: <span id="jarj"></span></small><br><br>
    <span id="paikka"></span><br>
    <small>Osallistujia: <span id="osallistujia"></span></small><br>
    <p id="eventInfo"></p>
    <p><strong><a id="eventLink" href="" target="_blank">Ilmoittaudu!</a></strong></p>
</div>

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
<p>Harrastuksien lukumäärä kannassa: <c:out value="${lkm}"/></p>
</div>
</div>


<div style="max-width:1200px;margin:40px auto;padding:0 10px;" id='calendar'></div>
</body>
</html>
