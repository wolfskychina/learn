-- 各项赛事的注册率
-- {sql:round}
select contest_id , round(reusers/allusers*100,2) as percentage from (
(select contest_id, count(*) as reusers from 
Register group by contest_id ) as a, (select count(*) as allusers from Users ) as b )
order by percentage desc,contest_id;

select
    contest_id,
    round(count(user_id) * 100 / (select count(*) from users), 2) as percentage
from
    Register
group by
    contest_id
order by percentage desc, contest_id;