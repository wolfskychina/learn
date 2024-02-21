-- 指定时间段内的全部产品
-- {sql:year()},{sql:month()}
select product_name , total as unit from
(
select product_id , sum(unit) as total from 
(select * from Orders where Year(order_date) = 2020 and Month(order_date) = 2) as a
group by product_id having total >=100 ) as b,
Products where b.product_id = Products.product_id;