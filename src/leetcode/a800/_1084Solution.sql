-- {sql:distinct},{sql:not in}
select distinct(a.product_id) , a.product_name from Product a , Sales b where a.product_id = b.product_id
 and b.sale_date between '2019-01-01' and '2019-03-31' and a.product_id not in (select product_id from Sales where sale_date < '2019-01-01' or sale_date > '2019-03-31');