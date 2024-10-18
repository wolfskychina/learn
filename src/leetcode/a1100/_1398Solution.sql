-- 购买了A和B产品但是没有购买C产品的客户

select d.customer_id, customer_name from
(
select customer_id from 
(select a.customer_id from 
(select distinct(customer_id) as customer_id from Orders where product_name = 'A') as a ,
(select distinct(customer_id) as customer_id from Orders where product_name = 'B') as b where a.customer_id = b.customer_id

) as c where 
customer_id not in (
    select distinct(customer_id) from Orders where product_name = 'C'
)
) as d, Customers as cu where d.customer_id = cu.customer_id; 

-- 更优雅的写法
SELECT
    customer_id, customer_name
FROM
    Customers
WHERE
    customer_id NOT IN (
        SELECT customer_id
        FROM Orders
        WHERE product_name = 'C'
    ) AND Customer_id IN (
        SELECT customer_id
        FROM Orders
        WHERE product_name = 'A'
    ) AND Customer_id IN (
        SELECT customer_id
        FROM Orders
        WHERE product_name = 'B'
    )
ORDER BY customer_id