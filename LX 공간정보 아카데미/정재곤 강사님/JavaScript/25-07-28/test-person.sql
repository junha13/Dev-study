SELECT id, NAME, age, mobile
FROM test.person;

Insert into test.person(name, age, mobile)
values
('홍길동', 22, '010-1111-1111');

Update test.person 
set mobile = '010-2222-2222'
where id = 2;

delete from test.person
where id = 2;
