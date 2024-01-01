-- 查询近30天登陆的用户数
-- {sql:datediff()}mysql计算日期差的函数
select activity_date day, count(distinct user_id) active_users
from activity
where datediff('2019-07-27', activity_date) >= 0 AND datediff('2019-07-27', activity_date) <30
group by activity_date;