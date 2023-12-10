drop table if exists student_tbl;

create table student_tbl(
	id int primary key auto_increment,
	name varchar(45) not null,
	age int default 1
);

insert into student_tbl(name,age) values ('william',23);
insert into student_tbl(name,age) values ('John',30);
insert into student_tbl(name,age) values ('Arnel',42);