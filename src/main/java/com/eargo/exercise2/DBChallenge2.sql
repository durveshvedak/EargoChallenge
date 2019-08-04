create database eargo;

use eargo;

create table pages(id int not null auto_increment , home_page int, product_page int, warranty_page int, primary key (id) );

insert into pages (home_page, product_page, warranty_page) values (1,1,1);

insert into pages (home_page, product_page, warranty_page) values (1,1,0);

insert into pages (home_page, product_page, warranty_page) values (1,0,1);

insert into pages (home_page, product_page, warranty_page) values (1,0,0);

insert into pages (home_page, product_page, warranty_page) values (0,1,1);

insert into pages (home_page, product_page, warranty_page) values (0,1,0);

insert into pages (home_page, product_page, warranty_page) values (0,0,1);

insert into pages (home_page, product_page, warranty_page) values (0,0,0);

create table cols as (select column_name from information_schema.columns where table_name ='pages');

create table page_count ( select column_name, count(*) from cols inner join pages group by column_name limit 5 offset 1 );
