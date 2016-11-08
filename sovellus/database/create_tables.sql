CREATE TABLE AKTIVITEETTI (
aktiivi_id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
aktiivi_nimi VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE TAPAHTUMA (
tapahtuma_id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
aktiivi_id SMALLINT,
FOREIGN KEY (aktiivi_id) REFERENCES AKTIVITEETTI (aktiivi_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;