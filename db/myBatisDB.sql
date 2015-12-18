create table student(
id INT PRIMARY KEY,
name VARCHAR(255) ,
teacher_id int
);
create table teacher(
id INT PRIMARY KEY,
name VARCHAR(255) ,
age int
);
create sequence seq_student;
create sequence seq_teacher;
select * from teacher t for update;
select * from student t for update;
