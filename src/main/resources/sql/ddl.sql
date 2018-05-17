DROP DATABASE IF EXISTS LojmanSistemi;
CREATE DATABASE IF NOT EXISTS LojmanSistemi;
USE LojmanSistemi;

CREATE TABLE IF NOT EXISTS LojmanBlok (
  `blok_id` INTEGER AUTO_INCREMENT NOT NULL,
  `blok_adi` NVARCHAR(255) NOT NULL,
  `daire_sayisi` INTEGER NOT NULL,
  PRIMARY KEY (`blok_id`)
);

CREATE TABLE IF NOT EXISTS LojmanDairesi (
  `daire_id` INTEGER AUTO_INCREMENT NOT NULL,
  `blok_id` INTEGER NOT NULL,
  `daire_no` INTEGER NOT NULL,
  `giris_tarihi` DATE NULL,
  `cikis_tarihi` DATE NULL,
  `oda_sayisi` INTEGER NULL,
  PRIMARY KEY (`daire_id`),
  FOREIGN KEY (blok_id) REFERENCES LojmanBlok(blok_id)
);

CREATE  TABLE USERS (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE USER_ROLES (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES USERS (username));


INSERT INTO USERS(username,password,enabled)
VALUES ('oguz','$2a$10$nXYlW5Aw5m.X75av5PpciO8jsKNxj11j3x7iu21zwcXv3AMWYpd9e', true);

INSERT INTO USER_ROLES (username, role)
VALUES ('oguz', 'ROLE_ADMIN');

