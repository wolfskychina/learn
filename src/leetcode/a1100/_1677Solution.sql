-- 发票中的产品金额 {sql:easy}
select a.name  , if(rest is null,0,rest) as rest , if(paid is null,0,paid) as paid , 
if(canceled is null,0,canceled) as canceled, if(refunded is null, 0,refunded) as refunded from Product as a left join (select  product_id , sum(rest) as rest, sum(paid) as paid , sum(canceled) as canceled , sum(refunded) as refunded 
from Invoice group by product_id) as b on a.product_id = b.product_id order by name;