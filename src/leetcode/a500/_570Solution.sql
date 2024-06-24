# 查找至少有5名直系下属的领导名字
{sql:having}
Table: Employee
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+

-- Write your MySQL query statement below
select name from Employee where id in
(select managerId from Employee group by managerId having count(*)>=5);
