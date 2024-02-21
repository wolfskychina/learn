-- 各类货物的平均售价，不同月份的售价不同
select product_id , if(round(totalAmount/totalNum,2) is null, 0,round(totalAmount/totalNum,2)) as average_price 
from
(select b.product_id , sum(a.units*b.price) as totalAmount, sum(a.units) as totalNum from Prices b 
left join  UnitsSold a 
on a.product_id = b.product_id and a.purchase_date between b.start_date and b.end_date group by product_id) as c;