-- 统计员工除最近发薪月外的所有发薪月份前三个连续月（包括发薪月）的累计工资
-- 如果前三个连续月中有没有发薪的月份，那么累计工资不算这个月
Table: Employee
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| month       | int  |
| salary      | int  |
+-------------+------+
(id, month) is the primary key (combination of columns with unique values) for this table.
Each row in the table indicates the salary of an employee in one month during the year 2020.

select a.id, a.month, sum(b.salary) as Salary from 
(select * from Employee where (id,month) not in 
    (select id,max(month) as month from Employee group by id order by month desc)) as a,
(select * from Employee) as b 
where a.id = b.id and 
     (a.month =b.month or a.month = b.month+1 or a.month = b.month +2) 
group by a.id , a.month order by id asc,month desc ;