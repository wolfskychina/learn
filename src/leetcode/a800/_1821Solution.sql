-- 寻找今年具有正收入的客户 {sql:easy}
select customer_id from (
select customer_id, sum(revenue) as total from Customers where year = 2021 group by customer_id
having total >0) as a ;