-- 计算每个销售人员的总销售额
select s.salesperson_id as salesperson_id, 
s.name as name, if(sum(price) is null,0,sum(price)) as total from Salesperson s left join 
(select c.salesperson_id, price from Customer c, Sales ss where 
c.customer_id = ss.customer_id) as b on s.salesperson_id = b.salesperson_id
group by s.salesperson_id;