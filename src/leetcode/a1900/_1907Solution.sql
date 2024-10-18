-- 按分类统计薪水人数
-- {sql:union all},{sql:case when then}
Accounts table:
+------------+--------+
| account_id | income |
+------------+--------+
| 3          | 108939 |
| 2          | 12747  |
| 8          | 87709  |
| 6          | 91796  |
+------------+--------+
Output: 
+----------------+----------------+
| category       | accounts_count |
+----------------+----------------+
| Low Salary     | 1              |
| Average Salary | 0              |
| High Salary    | 3              |
+----------------+----------------+

select 'Low Salary' category, count(*) accounts_count
from Accounts
where income < 20000
union all
select 'Average Salary' category, count(*) accounts_count
from Accounts
where income between 20000 and 50000
union all
select 'High Salary' category, count(*) accounts_count
from Accounts
where income > 50000;


with t as(
    select 'Low Salary' category 
    union 
    select 'Average Salary' 
    union 
    select 'High Salary'
)
select
    t.category, ifnull(a.cnt,0) accounts_count
from
    t
left join
    (
        select 
            case when income  < 20000 then 'Low Salary'
                 when income  > 50000 then 'High Salary'
                 else 'Average Salary' end as category,
            count(1) as cnt
        from
            Accounts 
        group by 1
    ) a
on
    t.category = a.category
