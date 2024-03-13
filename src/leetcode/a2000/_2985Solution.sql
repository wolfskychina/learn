-- 平均订单数量 {sql:easy}
select round(a/b,2) as average_items_per_order from (
select sum(item_count*order_occurrences) as a, 
sum(order_occurrences) as b from Orders ) as c;