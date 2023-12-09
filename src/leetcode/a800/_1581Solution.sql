-- 进店却未进行交易的客户
select customer_id , count(*) as count_no_trans  from
 (select customer_id , transaction_id from Visits a left join Transactions b on a.visit_id = b.visit_id ) c
where transaction_id is null group by customer_id;