drop table if exists member_tbl;

create table member_tbl(
	loginId varchar(45) primary key,
	name varchar(45) not  null,
	password varchar(45) not null
);

insert into member_tbl values('john','Johnwick','123');
insert into member_tbl values('william','william smith','111');
insert into member_tbl values('samlew','Samlew','222');