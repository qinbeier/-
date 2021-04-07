CREATE DATABASE schadmin
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';
 
 use  schadmin;
 
create table student(STUID VARCHAR(10) not null,
     username VARCHAR(64) not null,
     gender VARCHAR(64) not null,
     city VARCHAR(64) not null,
     PID VARCHAR(64) not null,
     phone VARCHAR(64) not null,
     email VARCHAR(128), 
     postID VARCHAR(64),
     address VARCHAR(255),
     refnum1 int(10),
     refnum2 int(10),
     refstr1 VARCHAR(255),
     refstr2 VARCHAR(255),
     refdate1 DateTime,
     refdate2 DateTime,
     lastmodifiedtime DateTime
     );
  ALTER TABLE student ADD PRIMARY KEY(STUID);
  
 create table stu_grade(STUID VARCHAR(10) not null,
     g_electron int(3) default 0 not null,
     g_software int(3) default 0 not null,
     g_security int(3) default 0 not null,
     g_java int(3) default 0 not null,
     g_db int(3) default 0 not null,
     g_image int(3) default 0 not null,
     g_distributed int(3) default 0 not null,
     g_test int(3) default 0 not null,
     lastmodifiedtime DateTime
     );
 ALTER TABLE stu_grade ADD PRIMARY KEY(STUID);