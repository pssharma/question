DROP TABLE answers IF EXISTS;
DROP TABLE questions IF EXISTS;
DROP TABLE users IF EXISTS;



CREATE TABLE questions (
  id INTEGER IDENTITY PRIMARY KEY,
  Type VARCHAR(30),
  question  VARCHAR(250),
  no_of_choices INTEGER,
  answer VARCHAR(40),
  options VARCHAR(900) 
);

CREATE TABLE answers (
  id INTEGER IDENTITY PRIMARY KEY,
  qid INTEGER,
  uid  INTEGER,
  answer VARCHAR(40),
  user_answers VARCHAR(900) 
);

ALTER TABLE answers ADD CONSTRAINT fk_questions FOREIGN KEY (qid) REFERENCES questions(id);





CREATE  TABLE users (
  username    VARCHAR(20) NOT NULL ,
  password    VARCHAR(20) NOT NULL ,
  enabled     BOOLEAN DEFAULT TRUE NOT NULL ,
  PRIMARY KEY (username)
);

CREATE TABLE roles (
  id              INTEGER IDENTITY PRIMARY KEY,
  username        VARCHAR(20) NOT NULL,
  role            VARCHAR(20) NOT NULL
);
ALTER TABLE roles ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username);
CREATE INDEX fk_username_idx ON roles (username);
