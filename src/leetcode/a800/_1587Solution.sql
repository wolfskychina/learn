-- 银行账户概要 {sql:easy}
select name , balance from  Users a , (select account, sum(amount) as balance from Transactions group by account ) as b
where a.account = b.account and b.balance > 10000;