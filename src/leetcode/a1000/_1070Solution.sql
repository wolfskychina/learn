-- 每种产品在他第一年的销售额

select a.product_id as product_id, b.first_year as first_year , a.quantity as quantity, a.price as price 
from Sales as a, 
(select product_id ,min(year) as first_year from Sales group by product_id )as b
 where a.product_id = b.product_id and a.year = b.first_year;
