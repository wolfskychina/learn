-- {sql:self join}
select  round(num/num1 *100,2) as immediate_percentage from (
    select count(*) as num from (
        select customer_id, min(order_date) as first_order from Delivery group by customer_id ) as a, (select customer_id,order_date from Delivery where order_date = customer_pref_delivery_date  ) as b where a.customer_id = b.customer_id and a.first_order = b.order_date )  as c join (
select count(distinct(customer_id)) as num1 from Delivery) as d;