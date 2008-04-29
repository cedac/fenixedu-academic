
ALTER TABLE PROCESS DROP COLUMN KEY_DEGREE;
ALTER TABLE PROCESS ADD COLUMN KEY_CANDIDACY_PERIOD INT(11) DEFAULT NULL, ADD INDEX (KEY_CANDIDACY_PERIOD);
ALTER TABLE PROCESS ADD COLUMN KEY_CANDIDACY_PROCESS INT(11) DEFAULT NULL, ADD INDEX (KEY_CANDIDACY_PROCESS);
ALTER TABLE PROCESS ADD COLUMN STATE VARCHAR(100) DEFAULT NULL;
ALTER TABLE PROCESS ADD COLUMN KEY_CANDIDACY INT(11) DEFAULT NULL, ADD INDEX (KEY_CANDIDACY);
ALTER TABLE EVENT ADD COLUMN KEY_INDIVIDUAL_CANDIDACY INT(11), ADD INDEX (KEY_INDIVIDUAL_CANDIDACY);
ALTER TABLE REGISTRATION ADD COLUMN KEY_INDIVIDUAL_CANDIDACY INT(11), ADD INDEX (KEY_INDIVIDUAL_CANDIDACY);


-- DROP TABLE IF EXISTS CANDIDACY_PERIOD;
CREATE TABLE CANDIDACY_PERIOD (
	ID_INTERNAL int(11) NOT NULL auto_increment,
	KEY_ACADEMIC_PERIOD INT(11) NOT NULL,
	START DATETIME NOT NULL DEFAULT '00-00-0000 00:00',
	END DATETIME NOT NULL DEFAULT '00-00-0000 00:00',
	KEY_ROOT_DOMAIN_OBJECT int(11),
	PRIMARY KEY (ID_INTERNAL),
	INDEX (KEY_ROOT_DOMAIN_OBJECT),
	INDEX (KEY_ACADEMIC_PERIOD)
) type=InnoDB;

-- DROP TABLE IF EXISTS OVER23_INDIVIDUAL_CANDIDACY_DEGREE_ENTRY;
CREATE TABLE OVER23_INDIVIDUAL_CANDIDACY_DEGREE_ENTRY (
  ID_INTERNAL int(11) NOT NULL auto_increment,
  DEGREE_ORDER int(11),
  KEY_DEGREE int(11),
  KEY_OVER23_INDIVIDUAL_CANDIDACY int(11),
  KEY_ROOT_DOMAIN_OBJECT int(11),
  PRIMARY KEY (ID_INTERNAL),
  INDEX (KEY_DEGREE),
  INDEX (KEY_OVER23_INDIVIDUAL_CANDIDACY),
  INDEX (KEY_ROOT_DOMAIN_OBJECT)
) type=InnoDB ;


-- DROP TABLE IF EXISTS INDIVIDUAL_CANDIDACY;
CREATE TABLE INDIVIDUAL_CANDIDACY (
	ID_INTERNAL int(11) NOT NULL auto_increment,
	OJB_CONCRETE_CLASS text,
	STATE VARCHAR(100) NOT NULL,
	KEY_ACCEPTED_DEGREE int(11),
	KEY_CANDIDACY_PROCESS int(11),
	KEY_EVENT int(11),
	KEY_PERSON int(11),
	KEY_REGISTRATION int(11),
	KEY_ROOT_DOMAIN_OBJECT int(11),
	PRIMARY KEY (ID_INTERNAL),
	INDEX (KEY_ACCEPTED_DEGREE),
	INDEX (KEY_CANDIDACY_PROCESS),
	INDEX (KEY_EVENT),
	INDEX (KEY_PERSON),
	INDEX (KEY_REGISTRATION),
	INDEX (KEY_ROOT_DOMAIN_OBJECT)
) type=InnoDB;
