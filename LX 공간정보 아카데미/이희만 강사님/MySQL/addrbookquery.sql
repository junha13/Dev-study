use newhr;
select * from addrbook;
insert into addrbook(ab_name, ab_comdept) values('haha', 'test');


delete from addrbook where ab_id <50;

begin;
insert into addrbook(ab_name, ab_comdept) values('huhu', 'test');
select * from addrbook;
commit;
select @@autocommit;  # 1이면 오토커밋되는중임
set autocommit = false;


insert into addrbook(ab_name, ab_comdept) values('hoho', 'test');
select * from addrbook;
commit;


update addrbook set ab_name='aaa' where ab_id = 3;
select * from addrbook;
commit;

