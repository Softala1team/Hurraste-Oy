CREATE TABLE TAPAHTUMA (
tapahtuma_id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
osallistuja_id INT NOT NULL,
osallistujamaara SMALLINT,
max_osallistujamaara SMALLINT,
tapahtuma_nimi VARCHAR(255),
jar_nimi VARCHAR(255),
puh_num VARCHAR(10),
email VARCHAR(255),
tapahtuma_aika DATETIME,
loppumis_aika DATETIME,
kuvaus VARCHAR(255),
tapahtuma_paikka VARCHAR(255),
tapahtuman_tyyppi VARCHAR(30),
FOREIGN KEY (osallistuja_id) REFERENCES OSALLISTUJA (osallistuja_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE OSALLISTUJA (
osallistuja_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tapahtuma_id SMALLINT NOT NULL,
etunimi VARCHAR(255),
sukunimi VARCHAR(255),
puh_nro VARCHAR(255),
email VARCHAR(255),
FOREIGN KEY (tapahtuma_id) REFERENCES TAPAHTUMA (tapahtuma_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE TAPAHTUMA 
ADD FOREIGN KEY (osallistuja_id)
REFERENCES OSALLISTUJA (osallistuja_id);

ALTER TABLE OSALLISTUJA
ADD FOREIGN KEY (tapahtuma_id)
REFERENCES TAPAHTUMA (tapahtuma_id);