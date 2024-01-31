-- {sql:easy} 商品销售记录
select product_id, sum(quantity) as total_quantity 
from Sales group by product_id;