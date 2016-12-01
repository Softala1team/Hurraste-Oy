INSERT INTO TAPAHTUMA
	(max_osallistujamaara, tapahtuma_nimi, jar_nimi, puh_num, email, tapahtuma_aika, loppumis_aika, kuvaus, tapahtuma_paikka, tapahtuman_tyyppi, hyvaksytty)
VALUES
	('3','Koodausta','Lilja Kuikka','0401253567','lilja.kuikka@sposti.fi','2016-12-21 10:00:00','2016-12-21 13:00:00','Pidet‰‰n koodaus taidot kunnossa lomallakin!','Kirjasto','Ohjelmointi','1');

	
INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	
INSERT INTO KAYTTAJA
	(id, username, password_encrypted, enabled, firstname, lastname)
VALUES 
	('1','hurradmin','9d5d9e8b634113a6aa05628d6fb37a05447878520ef7e912d43a2e5dc981f2e187a90daa3319dbb4','1','Heikki','Hurra');

INSERT INTO
	webuser_authority
VALUES
	(1,1,1),
	(2,1,2);