-- Schema: public

-- DROP SCHEMA public;

\connect webapp

--CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE Registration
(
  Registration_ID 	character varying(36) NOT NULL,
  Username 			character varying(999) UNIQUE NOT_NULL,
  Password 			character varying(36),
  Nickname 			character varying(999) UNIQUE NOT_NULL,
  CONSTRAINT PK_Registration PRIMARY KEY (Registration_ID)
);

CREATE TABLE Role
(
  Role_ID 			character varying(36) NOT NULL,
  Registration_ID 	character varying(36),
  Role 				character varying(255),
  CONSTRAINT PK_Role PRIMARY KEY (Role_ID),
  CONSTRAINT FK_Registration FOREIGN KEY (Registration_ID)
      REFERENCES Registration(Registration_ID)
);


INSERT INTO Registration  VALUES ('1', 'admin', 'admin','Administrator');
INSERT INTO Registration  VALUES ('2', 'jack', 'jack','Jack');

INSERT INTO Role  VALUES ('1', '1', 'admin');
INSERT INTO Role  VALUES ('2', '2', 'user');



