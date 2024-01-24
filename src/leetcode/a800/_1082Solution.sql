-- 销量最高的销售员的id {easy} 
select seller_id from (
select seller_id, sum(price) as price from Sales group by seller_id having price in(
select max(price) as maxprice from 
    (select sum(price) as price from Sales group by seller_id ) as c ) ) as b ;