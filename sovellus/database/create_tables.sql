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

CREATE TABLE authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 CREATE TABLE KAYTTAJA (
  id integer NOT NULL auto_increment PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  firstname varchar(255) default NULL,
  lastname varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE webuser_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  webuser_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (webuser_id) REFERENCES KAYTTAJA(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;