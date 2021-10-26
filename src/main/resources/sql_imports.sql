select * from product_stock ps ;
select * from product p ;
select * from product_category pc ;
select * from product_colour pc2 ;
select * from product_manufacturer pm ;

select distinct on (p.id) ps.product_id, p.product_name ,pc.category_name, ps.stock_record_date, ps.stock_current_quantity
	from product p
full join product_stock ps
	on p.id = ps.product_id
full join product_category pc
	on p.product_category_id = pc.id
;

insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date) values(10,'Sold',1,current_timestamp);


SELECT product_id,stock_quantity
     , sum(stock_quantity) OVER (PARTITION BY product_id,stock_operation
                         ORDER BY product_id) AS cum_amt
FROM   product_stock ps
ORDER  BY product_id;


select stock_id,stock_current_quantity from product_stock where stock_record_date = (select MAX(stock_record_date) from product_stock where product_id = 12)

select distinct on (product_id) product_id, stock_current_quantity from product_stock order by product_id, stock_record_date desc ;

drop view products_stocks;
create view products_stocks as select sum(stock_quantity) from product_stock where stock_operation = 'Purchased' except select sum(stock_quantity) from product_stock where stock_operation = 'Sold' group by product_id ;


používám negativní hodnoty pro stock_quantity - tak získám jednoduše tabulku s přehledem stavu skladu
select product_id, sum(stock_quantity) from product_stock group by product_id ;


insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(1,'Purchased',1,current_timestamp,1);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(1,'Purchased',1,current_timestamp,2);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(1,'Sold',1,current_timestamp,1);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(2,'Purchased',250,current_timestamp,250);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(2,'Purchased',10,current_timestamp,260);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(2,'Sold',1,current_timestamp,259);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(2,'Sold',1,current_timestamp,258);
insert into product_stock(product_id, stock_operation, stock_quantity,stock_record_date,stock_current_quantity) values(10,'Sold',-1,current_timestamp,258);


DROP MATERIALIZED VIEW IF EXISTS mat_product_stock;

create materialized view mat_product_stock as
select distinct on (p.id) ps.product_id, p.product_name ,pc.category_name, ps.stock_record_date, ps.stock_current_quantity
	from product p
full join product_stock ps
	on p.id = ps.product_id
full join product_category pc
	on p.product_category_id = pc.id
with no data;

refresh materialized view mat_product_stock;

select * from mat_product_stock;




insert into product_category (category_name,category_created,category_modified,is_category_active) values ('Drinks','2021-10-26 17:10:12.777',current_timestamp,true);
insert into product_manufacturer (product_manufacturer_name, product_manufacturer_created) values ('Pilsner Urquell', current_timestamp);
insert into product_colour (product_colour_name, product_colour_created) values ('Green',current_timestamp);
insert into product (product_created,product_name,product_quantity,product_category_id,product_colour_id,product_manufacturer_id) values (current_timestamp,'Pivo',58,1,1,1);