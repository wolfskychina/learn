-- 查询结果的质量占比
-- {sql:avg} avg函数不仅可以计算表达式，还可以加筛选条件

Table: Queries
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| query_name  | varchar |
| result      | varchar |
| position    | int     |
| rating      | int     |
+-------------+---------+

--
select a.query_name,  round(quality,2) as quality, if(poor_num is null,0, round(poor_num/total_num*100,2) ) as poor_query_percentage  from (
(select query_name,avg(rating/position) as quality ,count(*) as total_num from Queries where query_name is not null group by query_name) as a
 left join (select query_name , count(*) as poor_num from Queries  where rating <3 and query_name is not null group by query_name ) as b on a.query_name = b.query_name);

-- 简洁的写法
select query_name,
round(avg(rating / position),2)  as quality,
round(avg(rating < 3)*100,2) as poor_query_percentage 
from Queries
group by query_name