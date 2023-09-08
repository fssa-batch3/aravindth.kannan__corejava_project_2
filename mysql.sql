USE aravindth_kannan_corejava_project;
CREATE TABLE User(
	user_id  INT AUTO_INCREMENT ,
    email varchar(30),
    username varchar(50),
    password varchar(20),
    phonenumber varchar(12),
    type varchar(50),
    primary key (user_id)
);
ALTER TABLE User RENAME user;
USE aravindth_kannan_corejava_project;
SHOW TABLES;
SELECT * FROM User;
CREATE TABLE if not exists hairstyle(
    haircut_id INT AUTO_INCREMENT,
    haircut_email varchar(30),
    haircut_name varchar(50),
    haircut_type varchar(20),
    haircut_about varchar(200),
    haircut_url varchar(200),
    primary key(haircut_id)
);

SELECT * FROM hairstyle;
show tables;

CREATE TABLE barber(
	barber_id  INT AUTO_INCREMENT ,
    barber_email varchar(30),
    barber_experience varchar(200),
    barber_profile_URL varchar(250),
    barber_about varchar(250),
    barber_address varchar(250),
    barber_name varchar(50),
    barber_password varchar(20),
   barber_phonenumber varchar(12),
    primary key (barber_id)
);

SELECT * FROM barber;