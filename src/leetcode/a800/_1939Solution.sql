-- 一天内访问两次的用户，时间比较函数
--{sql:timestampdiff()}
select
    distinct c1.user_id
from confirmations c1
join confirmations c2 on
    c1.user_id = c2.user_id and
    c1.time_stamp <> c2.time_stamp and
    timestampdiff(
        second,
        c1.time_stamp,
        c2.time_stamp
        ) between 1 and 24*60*60;

-- {sql:to_seconds()}
select
    distinct c1.user_id
from confirmations c1
join confirmations c2 on
    c1.user_id = c2.user_id and
    c1.time_stamp <> c2.time_stamp and
    (to_seconds(c1.time_stamp) - to_seconds(c2.time_stamp))
        between 1 and 24*60*60;