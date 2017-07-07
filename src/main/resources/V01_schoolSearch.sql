DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS schools;
DROP TABLE IF EXISTS studentsschools;

CREATE TABLE students(
id int NOT NULL PRIMARY KEY,
name varchar(100),
birthday DATE
);

CREATE TABLE schools (
id int NOT NULL PRIMARY KEY,
name varchar(100),
city varchar(100)
);

CREATE TABLE studentsschools (
  student SERIAL NOT NULL REFERENCES students ON DELETE CASCADE,
  school SERIAL NOT NULL REFERENCES schools ON DELETE CASCADE,
  PRIMARY KEY (student, school)
);