-- {sql:easy} 即时食物配送
select round(immi/total*100,2) as immediate_percentage from
(select count(*) as immi from Delivery where order_date = customer_pref_delivery_date) as a,
(select count(*) as total from Delivery) as b;