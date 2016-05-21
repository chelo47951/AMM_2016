/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fab
 * Created: 19-mag-2016
 */


/*
---------------------------------------------------------------------------------
DDL: Creazione delle tabelle relative alle entità del dominio
---------------------------------------------------------------------------------
 */


create table USERS
(
	USER_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	FNAME VARCHAR(64) not null,
	LNAME VARCHAR(64) not null,
	ADDRESS VARCHAR(512),
	USERNAME VARCHAR(64) not null,
	PASSWORD VARCHAR(16) not null,	
	USER_TYPE VARCHAR(32) not null
);


create table ACCOUNTS
(
	ACCOUNT_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	BALANCE DOUBLE default 0.0 not null,
        USER_ID INTEGER  unique not null,
	IS_ACTIVE BOOLEAN default true not null,
	IS_OVERDRAFT BOOLEAN default false not null
);

ALTER TABLE ACCOUNTS ADD CONSTRAINT USER_FK
Foreign Key (USER_ID) REFERENCES USERS (USER_ID);


create table OBJECT_SALES
(
	OBJECT_SALE_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	OBJECT_NAME VARCHAR(128) not null,
	DESCRIPTION VARCHAR(512) default 'Descrizione non disponibile' not null,
	CATEGORY VARCHAR(32) not null,
	PRICE DOUBLE default 0.0 not null,
	NUM_OF_ITEMS SMALLINT default 0 not null,
	IMG_URL VARCHAR(512),
	VENDOR_ID INTEGER not null
);

ALTER TABLE OBJECT_SALES ADD CONSTRAINT OBJECT_VENDOR_FK
Foreign Key (VENDOR_ID) REFERENCES USERS (USER_ID) ;



create table TRANSACTIONS
(
	TRANSACTION_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	CUSTOMER_ID INTEGER not null,
	VENDOR_ID INTEGER not null,
	OBJECT_SALE_ID INTEGER not null,
	AMOUNT DOUBLE default 0.0 not null,
	COMMIT_DATE DATE default CURRENT DATE not null
);

ALTER TABLE TRANSACTIONS ADD CONSTRAINT TRANSACTION_CUSTOMER_FK
Foreign Key (CUSTOMER_ID) REFERENCES USERS (USER_ID) ;

ALTER TABLE TRANSACTIONS ADD CONSTRAINT TRANSACTION_VENDOR_FK
Foreign Key (VENDOR_ID) REFERENCES USERS (USER_ID) ;

ALTER TABLE TRANSACTIONS ADD CONSTRAINT TRANSACTION_OBJECT_SALE_FK
Foreign Key (OBJECT_SALE_ID) REFERENCES OBJECT_SALES (OBJECT_SALE_ID) ;




/*
---------------------------------------------------------------------------------
DML: Caricamento dei dati
---------------------------------------------------------------------------------
 */


/* Utenti */
INSERT INTO USERS (USER_ID, FNAME, LNAME, ADDRESS, USERNAME, PASSWORD, USER_TYPE)
VALUES (default, 'Mario','Rossi','Via del Corso 11, Roma','rossim60','1960','IsCustomer'),
 (default, 'Giuseppe','Verdi','Via della Spiga 23, Milano','verdig55','1955','IsVendor'),
 (default, 'Giacomo','Leopardi','Via Aldo Moro 35, Recanati','leopardig49','1949','IsCustomer'),
 (default, 'Alessandro','Manzoni','Via Ripamonti 5, Milano','manzonia67','1967','IsVendor');


/* Conti correnti */
INSERT INTO ACCOUNTS (ACCOUNT_ID, BALANCE, USER_ID, IS_ACTIVE, IS_OVERDRAFT)
VALUES (default, 250.00 ,1,default, default),
 (default, 50.00 ,2,default, default),
 (default, 150.00 ,3,default, default),
 (default, 10.00 ,4,default, default);

/* Oggetti in vendita */
INSERT INTO OBJECT_SALES (OBJECT_SALE_ID, OBJECT_NAME, DESCRIPTION, CATEGORY, PRICE,NUM_OF_ITEMS,IMG_URL,VENDOR_ID)
 VALUES (default,'Captain Kirk','Star Trek: Captain Kirk', 'Action Figure', 299.00,3,'img/kirk.jpg',2),
 (default,'Eric Draven','The Crow: Eric Draven', 'Action Figure', 235.00,2,'img/theCrow.jpg',2),
 (default,'Devilman','Devilman anime version', 'Action Figure', 85.00,5,'img/devilman.jpg',2),
 (default,'Jeeg','Jeeg Robot', 'Robot', 155.00,2,'img/jeeg.jpg',4),
 (default,'Goldrake','Goldrake Bandai', 'Robot', 145.00,3,'img/goldrake.jpg',4),
 (default,'Nausicaa','Nausicaa della valle del vento', 'DVD', 35.00,6,'img/Nausicaa-dvd.png',4);


        

 
        
        
        
       
        
        
  

