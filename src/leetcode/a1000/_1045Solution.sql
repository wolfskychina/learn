-- 买下所有商品的客户 {sql:easy}
select customer_id from (
select customer_id,count(*) as num from (select distinct * from Customer) as a group by customer_id) as b , (select count(*) as num from Product )as c where b.num = c.num;

-- 简洁的写法
select customer_id
from customer
group by customer_id
having count(distinct product_key) = (select count(product_key) from product)