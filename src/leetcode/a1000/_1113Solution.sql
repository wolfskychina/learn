-- 各种类型报告的数量 {sql:easy}
select extra as report_reason , count(distinct(post_id)) as report_count 
from Actions 
where action = 'report' and action_date = '2019-07-04'
 group by extra;