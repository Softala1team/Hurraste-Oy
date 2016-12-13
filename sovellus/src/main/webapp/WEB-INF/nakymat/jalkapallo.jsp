<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src='<%=request.getContextPath()%>/resources/jquery.min.js'></script>
<link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.min.css' rel='stylesheet' />
<link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.print.css' rel='stylesheet' media='print' />
<link href='<%=request.getContextPath()%>/resources/jquery-ui.min.css' rel='stylesheet' type='text/css'>
<script src='<%=request.getContextPath()%>/resources/moment.min.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.0.1/fullcalendar.min.js'></script>
<script src='<%=request.getContextPath()%>/resources/fi.js'></script>
<script src='<%=request.getContextPath()%>/resources/jquery-ui.min.js'></script>

<link href="<%=request.getContextPath()%>/resources/styles/style.css" rel="stylesheet" type="text/css">
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
		            $("#tyyppi").html(event.tyyppi);
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
		var tyypit=[];
		
		for(var i = 0; i < json.length; i++) {
		    var obj = json[i];
		    var tyyppi = obj.tapahtuman_tyyppi.toLowerCase();
			var colori="green";
		    if(obj.osallistujamaara>=obj.max_osallistujamaara){
		    	colori="red";
		    }
		    var newEvent = {
	                tyyppi: tyyppi,
					title: obj.tapahtuma_nimi,
	                start: obj.tapahtuma_aika,
	                end: obj.loppumis_aika,
	                description: obj.kuvaus,
	                paikka: obj.tapahtuma_paikka,
	                jarj: obj.jar_nimi,
	                osallistujia: obj.osallistujamaara+'/'+obj.max_osallistujamaara,
	                urli: '/sovellus/sovellus/'+obj.tapahtuma_id,
	                color: colori
	                //textColor:
	                //allDay: false,
	            };
	       $('#calendar').fullCalendar( 'renderEvent', newEvent,'stick');

		    var loyty=false;
		    for (i2 = 0; i2 < tyypit.length; i2++) {
		        if(tyyppi==tyypit[i2]){
		        	loyty=true;
		        }
		    }
		    if (loyty==false){
			    tyypit[tyypit.length]=tyyppi;
		    }
		}
		if (tyypit.length==1){
			document.getElementById("tyypitotsikko").innerHTML = tyypit[0];
			document.getElementById("tyypit").innerHTML += '<a href=/sovellus/sovellus/jalkapallo/>Näytä kaikki</a>';
		} else {
		    for (i3 = 0; i3 < tyypit.length; i3++) {
			    document.getElementById("tyypit").innerHTML += '<a href=/sovellus/sovellus/jalkapallo/'+tyypit[i3]+'>'+tyypit[i3]+'</a>';
		    }
		}
	});

</script>
<title>Tapahtumakalenteri</title>
</head>
<body>

<div id="eventContent" title="Event Details" style="display:none;">
    <small><span id="tyyppi"></span></small><br><br>
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
<button class="dropbtn" id="tyypitotsikko">Laji / Tyyppi</button>
<div class="navdrop-content" id="tyypit" style="left:0;">
</div>
</div>

<a href="/sovellus">
<img src="<%=request.getContextPath()%>/resources/images/home2.png" alt="etusivu" style="margin-left:1500px;height:75px;width:70px;padding:3px;border:2px solid grey;border-radius:700px;box-shadow:5px 5px 2px 2px #888888;">
</a>


<div id="otsikko">
	<h1>Tapahtumakalenteri</h1>
</div>
</div>


<div style="max-width:1200px;margin:40px auto;padding:0 10px;" id='calendar'></div>
</body>
</html>
