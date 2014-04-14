CREATE TABLE person (
  personid  INT    PRIMARY KEY NOT NULL,
  first_name  VARCHAR(50)  NOT NULL,
  middle_init  CHAR(1)    NULL,
  last_name  VARCHAR(75)  NOT NULL,
  ssn    INT    NULL 
);

CREATE TABLE demographics (
  demogid  INTEGER    PRIMARY KEY NOT NULL,
  personid  INTEGER    NOT NULL,
  dob    DATE      NULL,
  street    VARCHAR(255)  NOT NULL,
  city    CHAR(255)    NOT NULL,
  state    VARCHAR(2)    NOT NULL,
  country  VARCHAR(50)  NOT NULL,
  zip_code  INTEGER    NOT NULL,
  phone    INTEGER    NULL,
  
  FOREIGN KEY(personid) REFERENCES person(personid)
);

CREATE TABLE conditions (
  conditionid  INTEGER    PRIMARY KEY NOT NULL,
  personid  INTEGER    NOT NULL,
  name    VARCHAR(255)  NOT NULL,
  type    VARCHAR(255)  NULL,
  classification  VARCHAR(255)  NULL,
  onset_date_tm DATE      NULL,
  
  FOREIGN KEY(personid) REFERENCES person(personid)
);

CREATE TABLE provider (
  providerid  INTEGER    PRIMARY_KEY NOT NULL,
  personid  INTEGER    NOT NULL,
  
  FOREIGN KEY(personid) REFERENCES person(personid)
);

CREATE TABLE visit (
  visitid    INTEGER    PRIMARY KEY NOT NULL,
  providerid  INTEGER    NOT NULL,
  personid  INTEGER    NOT NULL,
  reason_for_visit  VARCHAR(50)  NULL,
  visit_date_tm  DATE      NOT NULL,
  
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
  FOREIGN KEY(personid) REFERENCES person(personid)
);

CREATE TABLE services (
  serviceid  INTEGER    PRIMARY KEY NOT NULL,
  providerid  INTEGER    NOT NULL,
  description  VARCHAR(255)  NOT NULL,
  cost    DOUBLE    NULL,
  
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
);

CREATE TABLE appointments (
  apptid    INTEGER    PRIMARY KEY NOT NULL,
  personid  INTEGER    NOT NULL,
  providerid  INTEGER    NOT NULL,
  locationid  INTEGER    NOT NULL,
  appt_date_tm  DATE      NOT NULL,
  
  FOREIGN KEY(personid) REFERENCES person(personid)
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
  FOREIGN KEY(locationid) REFERENCES location(locationid)
);

CREATE TABLE location (
  locationid  INTEGER    PRIMARY KEY NOT NULL,
  providerid  INTEGER    NOT NULL,
  street    VARCHAR(255)  NOT NULL,
  city    CHAR(255)    NOT NULL,
  state    VARCHAR(2)    NOT NULL,
  country  VARCHAR(50)  NOT NULL,
  zip_code  INTEGER    NOT NULL,
  name    VARCHAR(50)  NOT NULL,
  
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
);

CREATE TABLE notifications (
  notificationid  INTEGER    PRIMARY KEY NOT NULL,
  providerid  INTEGER    NOT NULL,
  alert_text  VARCHAR(255)  NOT NULL,
  notif_date_tm  DATE      NOT NULL,
  
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
);

CREATE TABLE notes (
  noteid    INTEGER    PRIMARY KEY NOT NULL,
  providerid  INTEGER    NOT NULL,
  note_text  VARCHAR(255)  NOT NULL,
  
  FOREIGN KEY(providerid) REFERENCES provider(providerid)
);
