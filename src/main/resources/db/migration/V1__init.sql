create table products (id bigserial primary key, title varchar(255), price int);
insert into products (title, price)
values
('Milk', 90),
('Coconut Milk', 110),
('Bread', 24),
('Cheese', 355);