DROP TABLE IF EXISTS CONTACT;
CREATE TABLE CONTACT (
  CONTACT_ID int(11) NOT NULL AUTO_INCREMENT,
  CONTACT_EMAIL varchar(255) NOT NULL,
  CONTACT_NAME varchar(255) NOT NULL,
  CONTACT_PHONE varchar(255) NOT NULL,
  PRIMARY KEY (CONTACT_ID)
)
