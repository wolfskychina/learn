-- {easy}销售名称
select product_name ,year,price from Sales,Product where 
Sales.product_id = Product.product_id;