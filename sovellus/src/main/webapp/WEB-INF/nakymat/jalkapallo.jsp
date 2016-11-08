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
				right: 'month,agendaWeek,agendaDay,listYear'
			},
			defaultDate: $('#calendar').fullCalendar('getDate'),
			defaultView: 'month',
			//theme:true,
			navLinks: true,
			weekNumbers: false,
			editable: false,
			eventLimit: true,
			timezone: 'local',
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

		var json = JSON.parse('${json}');
		
		for(var i = 0; i < json.length; i++) {
		    var obj = json[i];
		    var newEvent = {
					title: obj.tapahtuma_nimi,
	                start: obj.tapahtuma_aika,
	                end: obj.loppumis_aika,
	                description: obj.kuvaus,
	                paikka: obj.tapahtuma_paikka,
	                jarj: obj.jar_nimi,
	                osallistujia: obj.osallistujamaara+'/'+obj.max_osallistujamaara,
	                urli: '/sovellus/sovellus/'+obj.tapahtuma_id,
	                color: 'green'
	                //textColor:
	                //allDay: false,
	            };
	       $('#calendar').fullCalendar( 'renderEvent', newEvent,'stick');
		}
	});

</script>
<title>Tapahtumakalenteri</title>
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
	<a href="/kutominen">Kutominen</a>
	<a href="ruoanlaitto.jsp">Ruoanlaitto</a>
	<a href="salibandy.jsp">Salibandy</a>
</div>
</div>
<div id="otsikko">
<h2>Tapahtumakalenteri</h2>
</div>
</div>


<div style="max-width:1200px;margin:40px auto;padding:0 10px;" id='calendar'></div>
</body>
</html>
