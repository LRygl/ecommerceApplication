select * from product;
select * from product_category;
select * from product_manufacturer;
select * from product_colour;

insert into product_category (category_name,category_name_added,is_category_active) values ('Drinks',current_timestamp,true);
insert into product_manufacturer (product_manufacturer_name, product_manufacturer_created) values ('Pilsner Urquell', current_timestamp);
insert into product_colour (product_colour_name, product_colour_created) values ('Green',current_timestamp);
insert into product (product_created,product_name,product_quantity,product_category_id,product_colour_id,product_manufacturer_id) values (current_timestamp,'Pivo',58,1,1,1);
