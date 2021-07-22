DROP TABLE IF EXISTS USER;
  
CREATE TABLE USER (
  id integer  not null,
  birthdate timestamp,
 name varchar(255),
  primary key(id)
);