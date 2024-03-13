-- 同时拥有两种贷款类型的用户id
-- {sql:easy}
select distinct(a.user_id) as user_id from
(select user_id from Loans where loan_type = 'Refinance' ) as a,
(select user_id from Loans where loan_type = 'Mortgage') as b
where a.user_id = b.user_id order by user_id;