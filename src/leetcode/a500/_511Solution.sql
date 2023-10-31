# 返回每个用户的最早登录时间信息
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

select  player_id, min(event_date) as first_login from Activity 
 group by player_id;