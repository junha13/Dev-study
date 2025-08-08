CREATE TABLE addrbook (
  ab_id int(11) auto_increment,
  ab_name varchar(15) NOT NULL,
  ab_email varchar(50) DEFAULT NULL,
  ab_comdept varchar(20) NOT NULL,
  ab_birth varchar(10) NOT NULL,
  ab_tel varchar(20) DEFAULT NULL,
  ab_memo varchar(100) DEFAULT NULL,
  PRIMARY KEY (ab_id)
);
select * from addrbook;