-- 指定日期的产品价格
select distinct(c.product_id) as product_id , if(price is null,10,price) as price from Products as c left join (
select a.product_id as product_id, if(a.new_price is null,10,a.new_price) as price from Products as a ,(
select product_id,change_date, max(change_date) as qdate from Products where change_date <= '2019-08-16' group by product_id order by change_date desc) as b where a.product_id = b.product_id and a.change_date = b.qdate) as d on c.product_id =d.product_id;