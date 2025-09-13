
drop SCHEMA company;
create schema company;
use company;


-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.351.0831
--   위치:        2025-09-09 15:43:57 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11ggg



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE COM_DEPARTMENT 
    ( 
     DEPARTMENT_NO      varchar (20)  NOT NULL , 
     DEPARTMENT_NAME    varchar (30) , 
     MANAGER_START_DATE DATE , 
     EMPLOYEE_ID        varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE COM_DEPARTMENT 
    ADD CONSTRAINT DEPARTMENT_PK PRIMARY KEY ( DEPARTMENT_NO ) ;

CREATE TABLE COM_DEPARTMENT_LOCATION 
    ( 
     LOCATION_NO   varchar (20)  NOT NULL , 
     LOCATION_NAME varchar (50) , 
     DEPARTMENT_NO varchar (20)  NOT NULL 
    ) 
;

ALTER TABLE COM_DEPARTMENT_LOCATION 
    ADD CONSTRAINT DEPARTMENT_LOCATION_PK PRIMARY KEY ( LOCATION_NO ) ;

CREATE TABLE COM_EMPLOYEE 
    ( 
     EMPLOYEE_ID   varchar (50)  NOT NULL , 
     NAME          varchar (30) , 
     SSN           varchar (15) , 
     ADDRESS       varchar (500) , 
     SALARY        decimal (14,2) , 
     GENDER        CHAR (1) , 
     BIRTH_DATE    DATE , 
     DEPARTMENT_NO varchar (20)  NOT NULL , 
     EMPLOYEE_ID   varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE COM_EMPLOYEE 
    ADD CONSTRAINT EMPLOYEE_PK PRIMARY KEY ( EMPLOYEE_ID ) ;

CREATE TABLE COM_PROJECT 
    ( 
     PROJECT_NO       varchar (50)  NOT NULL , 
     PROJECT_NAME     varchar (50) , 
     PROJECT_LOCATION varchar (500) , 
     DEPARTMENT_NO    varchar (20)  NOT NULL 
    ) 
;

ALTER TABLE COM_PROJECT 
    ADD CONSTRAINT PROJECT_PK PRIMARY KEY ( PROJECT_NO ) ;

CREATE TABLE COM_WORD_PROJECT 
    ( 
     EMPLOYEE_ID      varchar (50)  NOT NULL , 
     PROJECT_NO       varchar (50)  NOT NULL , 
     WORK_DAYS_AMOUNT int 
    ) 
;

ALTER TABLE COM_WORD_PROJECT 
    ADD CONSTRAINT WORD_PROJECT_PK PRIMARY KEY ( EMPLOYEE_ID, PROJECT_NO ) ;

ALTER TABLE COM_PROJECT 
    ADD CONSTRAINT DEPARTMENT_FK FOREIGN KEY 
    ( 
     DEPARTMENT_NO
    ) 
    REFERENCES COM_DEPARTMENT 
    ( 
     DEPARTMENT_NO
    ) 
;

ALTER TABLE COM_DEPARTMENT_LOCATION 
    ADD CONSTRAINT DEPARTMENT_FKv1 FOREIGN KEY 
    ( 
     DEPARTMENT_NO
    ) 
    REFERENCES COM_DEPARTMENT 
    ( 
     DEPARTMENT_NO
    ) 
;

ALTER TABLE COM_EMPLOYEE 
    ADD CONSTRAINT DEPARTMENT_FKv3 FOREIGN KEY 
    ( 
     DEPARTMENT_NO
    ) 
    REFERENCES COM_DEPARTMENT 
    ( 
     DEPARTMENT_NO
    ) 
;

ALTER TABLE COM_DEPARTMENT 
    ADD CONSTRAINT EMPLOYEE_FK FOREIGN KEY 
    ( 
     EMPLOYEE_ID
    ) 
    REFERENCES COM_EMPLOYEE 
    ( 
     EMPLOYEE_ID
    ) 
;

ALTER TABLE COM_WORD_PROJECT 
    ADD CONSTRAINT EMPLOYEE_FKv1 FOREIGN KEY 
    ( 
     EMPLOYEE_ID
    ) 
    REFERENCES COM_EMPLOYEE 
    ( 
     EMPLOYEE_ID
    ) 
;

ALTER TABLE COM_EMPLOYEE 
    ADD CONSTRAINT EMPLOYEE_FKv3 FOREIGN KEY 
    ( 
     EMPLOYEE_ID
    ) 
    REFERENCES COM_EMPLOYEE 
    ( 
     EMPLOYEE_ID
    ) 
;

ALTER TABLE COM_WORD_PROJECT 
    ADD CONSTRAINT PROJECT_FK FOREIGN KEY 
    ( 
     PROJECT_NO
    ) 
    REFERENCES COM_PROJECT 
    ( 
     PROJECT_NO
    ) 
;



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
