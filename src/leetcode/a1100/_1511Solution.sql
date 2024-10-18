-- 消费者在两个月中下单额均超过100的用户清单
-- {sql:date_format()}
select customer_id,name from (
select customer_id,name, count(*) as num from (
select customer_id,name from (select a.customer_id, sum(c.quantity*b.price) as pconsume ,a.name from Customers a , Product b,
(select customer_id,product_id,quantity,DATE_FORMAT(order_date, '%Y-%m') as order_date from orders where year(order_date) = 2020 and month(order_date) in (6,7)) as c
where a.customer_id = c.customer_id and b.product_id = c.product_id group by a.customer_id,c.order_date) as d where pconsume>=100 ) as e group by customer_id having num=2 ) as f;