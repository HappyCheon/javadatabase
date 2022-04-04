show tables;

create table dbtest (
  idx    int not null auto_increment primary key,
  name   varchar(20) not null,
  age    int default 20,
  gender varchar(2) default '남',
  joinday datetime default now()
);

insert into dbtest values (default,'홍길동',25,default,default);
insert into dbtest values (default,'김말숙',29,'여','2022-4-1');

select * from dbtest;

drop table ccc;
