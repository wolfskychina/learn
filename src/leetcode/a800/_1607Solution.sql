-- 某一年没有订单的卖家
-- {sql:year()}
select seller_name from Seller where seller_id not in(
    select distinct(seller_id) from Orders where
        YEAR(sale_date) = 2020
 
) order by seller_name;