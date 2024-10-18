-- 每家商店的产品价格 {sql:left join},{sql:sum if}
Products table:
+-------------+--------+-------+
| product_id  | store  | price |
+-------------+--------+-------+
| 0           | store1 | 95    |
| 0           | store3 | 105   |
| 0           | store2 | 100   |
| 1           | store1 | 70    |
| 1           | store3 | 80    |
+-------------+--------+-------+
Output: 
+-------------+--------+--------+--------+
| product_id  | store1 | store2 | store3 |
+-------------+--------+--------+--------+
| 0           | 95     | 100    | 105    |
| 1           | 70     | null   | 80     |
+-------------+--------+--------+--------+


select a.product_id,store1,store2,store3 from 
(select distinct(product_id) as product_id from Products ) as a left join
(select product_id , price as store1 from Products where store = 'store1' ) as b on a.product_id = b.product_id left join
(select product_id , price as store2 from Products where store = 'store2' ) as c on  a.product_id = c.product_id  left join
(select product_id , price as store3 from Products where store = 'store3' ) as d on   a.product_id = d.product_id;

select
    product_id,
    sum(if(store='store1',price,null)) store1,
    sum(if(store='store2',price,null)) store2,
    sum(if(store='store3',price,null)) store3
from
    Products
group by
    1