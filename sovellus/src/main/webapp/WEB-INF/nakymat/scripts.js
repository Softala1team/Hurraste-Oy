function teeKalenteri (){
	var elements = document.getElementsByClassName('tunti');
	var id=0
	var ids="";
	for (var i = 0; i < elements.length; i++) {
		for (i2 = 0; i2 < 7; i2++) {
			id++;
			ids=id.toString();
			elements[i].innerHTML += '<td><ul class="mainmenu"><li><a id="'+ids+'">&#8659; </a><ul class="submenu"><li><a id="'+ids+'linkki" href="https://goo.gl/forms/vYOYW7IjdWpRHmsi1">Luo tapahtuma</a></li></ul></li></ul></td>';
		}
	}
	//tee testi tapahtumia
	teeTapahtumia();
}

function teeTapahtumia(){
	teeTapahtuma("58", "Pieni porukka jalkapalloa pelaamaan", "Tule kanssani pelaamaan jalkapalloa! \n\nOsallistujat: 0/2 " +
			"\n\nMikko Mehilainen \n\nHiekkaharjun urheilukentta \n18:00-19:00");
	teeTapahtuma("32", "Joka torstai jalkapalloa!", "Pieni porukka kokoontuu pelaamaan jalkapalloa joka torstai ja etsimme muutamaa lisapelaajaa!" +
			"\n\nOsallistujat: 0/4 \n\nJussi Juuhala \n\nKapylan kentta \n\n12:00-13:00 ");
	teeTapahtuma("20", "Jalkapallo klub", "Jalkapallo klub kokoontuu lauantaisin, tule sinakin rohkeasti mukaan! \n\nOsallistujat: 0/10" +
			"\n\nMira Ryti \n\nHelsinki \n10:00-11:00");
}

function teeTapahtuma(numero, otsikko, teksti) {
	document.getElementById(numero).innerHTML += otsikko;
	document.getElementById(numero+"linkki").innerHTML = "Liity";
	document.getElementById(numero+"linkki").href = "#";
	document.getElementById(numero+"linkki").onclick = function() {liity(teksti)};
	document.getElementById(numero).style.backgroundColor = "#C9DDE8";
}
function liity(txt) {
    if (confirm(txt+"\n\nPaina OK jatkaaksesi liittymislomakkeeseen.") == true) {
    	window.location.href = "https://goo.gl/forms/WFJexKUQyieiqV5Y2";
    }
}