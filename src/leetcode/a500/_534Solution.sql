# Table: Activity
-- 统计每人截止到每次登录时玩过的总的游戏次数
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key (column with unique values) of this table.
This table shows the activity of players of some games.
Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on someday using some device.
 

Write a solution to report for each player and date, how many games played so far by the player. That is, the total number of games played by the player until that date. Check the example for clarity.

Return the result table in any order.

-- 笨办法，数据表自乘，然后过滤掉每个日期后面日期的记录
-- 对剩下的日期进行分组后sum统计次数
-- n2次的时间和空间复杂度
select t1.player_id,
       t1.event_date,
       sum(t2.games_played) games_played_so_far
from Activity t1,Activity t2
where t1.player_id=t2.player_id
  and t1.event_date>=t2.event_date
group by t1.player_id,t1.event_date;

-- 
select player_id, event_date, sum(games_played) over(partition by player_id order by event_date) as games_played_so_far
from activity
