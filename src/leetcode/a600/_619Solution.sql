-- 只出现一次的最大数字
-- {sql:having}
select if(count(*)=0, null,num) as num 
from (select  num, count(*) as nums from MyNumbers 
group by num having nums =1 order by num desc) as a limit 1;

-- 
select 
(select num
from MyNumbers
group by num
having count(num) = 1
order by num desc
limit 1)
as num