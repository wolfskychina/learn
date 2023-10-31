# 返回每个用户的最早登录设备
# Write your MySQL query statement below
# Table: Activity

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
# TODO 单条语句不能返回正确值  select player_id, device_id, min(event_date) as event_date from Activity
# 返回的每组的单条语句是组里面第一条数据加上event_date的最小值，并不是原表的数据行
# Write your MySQL query statement below
select a.player_id, a.device_id from 
   Activity as a, 
   (select player_id,min(event_date) as event_date from Activity group by player_id) as t 
where a.player_id = t.player_id and a.event_date = t.event_date;