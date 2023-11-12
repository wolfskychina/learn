-- 没有在A公司拿到订单的业务员
select name from SalesPerson where sales_id not in (select sales_id from Orders,Company where Orders.com_id = Company.com_id and Company.name = 'RED');