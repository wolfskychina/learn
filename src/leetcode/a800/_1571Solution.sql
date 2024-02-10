-- 仓库容积统计 {sql:easy}
    select a.name as warehouse_name , sum(a.units*b.Width*b.Length*b.Height) as volume  
from Warehouse a , Products b where a.product_id = b.product_id
group by a.name;
