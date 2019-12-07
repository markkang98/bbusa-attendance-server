CREATE TABLE RegisteredUser
(email VARCHAR(256) PRIMARY KEY,
 first_name VARCHAR(256) NOT NULL,
 last_name VARCHAR(256) NOT NULL,
 password VARCHAR(256) NOT NULL, 
 salt BLOB NOT NULL);
 
 CREATE TABLE Student
(studentEmail VARCHAR(256) NOT NULL references RegisteredUser(email) ,
 SID INTEGER PRIMARY KEY NOT NULL,
 belt VARCHAR(256) NOT NULL CHECK(belt in ('white','black','blue','orange','purple')),
 gender VARCHAR(256) CHECK(gender in ('M','F')),
 age INTEGER NOT NULL CHECK(age > 4),
 emergency_contact_name VARCHAR(256) NOT NULL, #added emegency contact info below
 emergency_contact_number VARCHAR(256) NOT NULL); #added emegency contact info below

CREATE TABLE Parent
(parentEmail VARCHAR(256) NOT NULL references RegisteredUser(email) ,
 PID INTEGER PRIMARY KEY NOT NULL,  
 phone_number CHAR(10) UNIQUE);

CREATE TABLE Instructor
(instructorEmail VARCHAR(256) references RegisteredUser(email),
 IID INTEGER PRIMARY KEY NOT NULL,
 belt VARCHAR(256) NOT NULL CHECK(belt in ('white','black','blue','orange','purple')));

CREATE TABLE Classes
(CID INTEGER PRIMARY KEY NOT NULL,
 start_time VARCHAR(256) NOT NULL, 
 end_time VARCHAR(256),
 target_start_age INTEGER NOT NULL,
 target_older_age INTEGER NOT NULL,
 description VARCHAR(256) NOT NULL);

-- CREATE TABLE Finances
-- (SID INTEGER NOT NULL references Student(SID) ,
--  PID INTEGER NOT NULL references Parent(PID) ,
--  PRIMARY KEY (SID,PID));

CREATE TABLE Takes
(SID INTEGER NOT NULL references Student(SID),
 CID INTEGER NOT NULL references Classes(CID) ,
 start_date DATE NOT NULL CHECK(STR_TO_DATE(end_date,'%d,%m,%Y')  >= start_date), 
 end_date DATE,
 Verified INT(11),
 PRIMARY KEY (CID,SID));

CREATE TABLE Attends
(SID INTEGER NOT NULL references Student(SID) ,
 CID INTEGER NOT NULL references Classes(CID) ,
 attendDate date NOT NULL, 
 attendance VARCHAR(256) CHECK(attendance IS NULL or attendance IN ('Attends','Absent','Cancelled','Late')), #added attendance details
 PRIMARY KEY (CID,SID,attendDate));

CREATE TABLE ParentStudent
(SID INTEGER NOT NULL references Student(SID) ,
 PID INTEGER NOT NULL references Parent(PID) ,
 PRIMARY KEY (PID,SID));

CREATE TABLE Teaches
(IID INTEGER NOT NULL references Instructor(IID),
 CID INTEGER NOT NULL references Classes(CID),
 start_date DATE CHECK(STR_TO_DATE(end_date,'%d,%m,%Y')  >= start_date), 
 end_date DATE,
 PRIMARY KEY (IID,CID));