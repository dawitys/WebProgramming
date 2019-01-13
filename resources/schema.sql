drop table if exists ClassRoom;
drop table if exists Course;
drop table if exists Student;
drop table if exists Teacher;
drop table if exists Student_Courses_Grades;
drop table if exists Student_Classes;
drop table if exists Teacher_Courses;
drop table if exists Teacher_ClassesClassRooms;


create table if not exists ClassRoom (
  id int not null auto_increment,
  gradeLevel varchar(6) not null,
  section varchar(2) not null
);

create table if not exists StudentCoursesList(
	id int not null auto_increment,
    gradeLevel varchar(6) not null,
    section varchar(2) not null,
    course int not null
);

create table if not exists Course (
  id int not null auto_increment,
  gradeLevel varchar(6) not null,
  subjectType varchar(64) not null
);

create table if not exists Student (
  id int not null auto_increment,
  FirstName varchar(32) not null,
  LastName varchar(32) not null,
  Age smallint not null,
  createdAt timestamp not null
);

create table if not exists Teacher (
  id int not null auto_increment,
  FirstName varchar(32) not null,
  LastName varchar(32) not null,
  Age smallint not null,
  createdAt timestamp not null
);

create table if not exists Student_Courses_Grades (
  id bigint auto_increment unique,
  student int not null,
  course int not null,
  grade smallint null
);

create table if not exists Student_Classes (
id bigint auto_increment unique,
  student int not null,
  classRoom int not null
);

create table if not exists Teacher_Courses (
id bigint auto_increment unique,
  teacher int not null,
  course int not null
);

create table if not exists Teacher_ClassesClassRooms (
id bigint auto_increment unique,
  teacher int not null,
  classRoom int not null,
  course int not null
);

alter table Student_Courses_Grades
    add foreign key (student) references Student(id);
alter table Student_Courses_Grades
    add foreign key (course) references Course(id);

alter table StudentCoursesList
	add foreign key (course) references Course(id);

alter table Teacher_ClassesClassRooms
    add foreign key (teacher) references Teacher(id);
alter table Teacher_ClassesClassRooms
    add foreign key (classRoom) references ClassRoom(id);
alter table Teacher_ClassesClassRooms
    add foreign key (course) references Course(id);
    
alter table Student_Classes
    add foreign key (student) references Student(id);
alter table Student_Classes
    add foreign key (classRoom) references ClassRoom(id);

alter table Teacher_ClassesClassRooms 
    add foreign key (teacher) references Teacher(id);
alter table Teacher_ClassesClassRooms
    add foreign key (classRoom) references ClassRoom(id);
alter table Teacher_ClassesClassRooms 
	add foreign key (course) references Course(id);
