INSERT INTO AKTIVITEETTI 
	(aktiivi_nimi)
VALUES
	('Jalkapallo'),
	('Kutominen'),
	('Salibandy'),
	('Ruoanlaitto');

INSERT INTO TAPAHTUMA
	(osallistujamaara, max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, loppumis_aika, kuvaus, tapahtuma_paikka, aktiivi_id)
VALUES
	('0','2','Jalkapalloa','Juha Kuikka','0401234567','juha-kuikka@sposti.fi','2016-11-10 16:00:00','2016-11-10 17:00:00','Tule pelaamaan jalkapalloa pienen porukan kanssa!','Käpylän urheilukenttä','1');

	
INSERT INTO KAYTTAJA
	(id, username, password_encrypted, enabled, firstname, lastname)
VALUES 
	('1','hurradmin','9d5d9e8b634113a6aa05628d6fb37a05447878520ef7e912d43a2e5dc981f2e187a90daa3319dbb4','1','Heikki','Hurra');
