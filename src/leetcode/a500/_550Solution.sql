# 首次登录后第二天仍然登录的用户占比
{sql},{sql:round},{sql:date_add}

Table: Activity

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+

select ROUND(x.num/xx.total ,2) as fraction from (select count(*) as num from Activity a, (select player_id, min(event_date) as event_date from Activity group by player_id) as b where a.player_id = b.player_id and a.event_date = DATE_ADD(b.event_date,INTERVAL 1 DAY) ) as x, (select count(distinct( player_id)) as total from Activity ) as xx;