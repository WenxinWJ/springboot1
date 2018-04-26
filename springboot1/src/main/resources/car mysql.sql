CREATE TABLE car
(
  id          int PRIMARY KEY AUTO_INCREMENT,
  name        varchar(50),
  price       double,
  create_date date
);

insert into car (name, price, create_date) VALUES ('吉利', 5500, current_timestamp);
insert into car (name, price, create_date) VALUES ('玛莎拉蒂', 5500, current_timestamp);
insert into car (name, price, create_date) VALUES ('凯迪拉克', 5500, current_timestamp);
insert into car (name, price, create_date) VALUES ('奔驰', 5500, current_timestamp);
