/**CREATE DATABASE schema-mysql;

Use Application;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users(
userId int(15) not NULL primary key AUTO_INCREMENT,
fname varchar(100),
lname varchar(100),
email varchar(100) not NULL,
password varchar(50) unique not null,
username varchar(100) not NULL primary key
enabled bit not null default 1
);

--CREATE TABLE users(
--username varchar(100) not null primary key,
--password varchar(100)  not null,
--enabled boolean not null
--)

CREATE TABLE authorities(
username varchar(100) not null,
authority varchar(50) not null,
foreign key (username) references users (username),
);

insert into persons(userId, fname, lname, email, password, username) values (1, 'Tareq', 'Hanafi', 'hanafitareq@gmail.com', '123', 'THanafi', true);
--insert into users(username, password, enabled)values('THanafi','123',true);
insert into authorities(username, authority) values ('THanafi', 'ROLE_ADMIN');
insert into authorities(username, authority) values ('THanafi', 'ROLE_USER');
--insert into users(id, fname, lname, email, password, username) values*/
