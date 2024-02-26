-- 花费最多的客户 {sql:easy}
select user_id, sum(singlebuy) as spending from (
select user_id,quantity*price as singlebuy  from Sales a , Product b where a.product_id = b.product_id) as c
group by user_id order by spending desc,user_id asc;