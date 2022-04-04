show tables;

CREATE TABLE javagreen00.dbtest LIKE javagreen.dbtest;
INSERT INTO javagreen00.dbtest SELECT * FROM javagreen.dbtest;

select * from dbtest;



select distinct gender from dbtest;


/*
create table dbtest (
  idx    int not null auto_increment primary key,
  name   varchar(20) not null,
  age    int default 20,
  gender varchar(2) default '남',
  joinday datetime default now()
);

insert into dbtest values (default,'홍길동',25,default,default);

select * from dbtest;

drop table ccc;
*/