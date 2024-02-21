-- 销售分析，买了s8但是没有买iphone的用户 {easy}
select distinct(buyer_id) from Sales where 
buyer_id in (select distinct(buyer_id) from Sales ,Product where Sales.product_id = Product.product_id and product_name = 'S8') 
and buyer_id not in(select distinct(buyer_id) from Sales ,Product where Sales.product_id = Product.product_id and product_name = 'iPhone');