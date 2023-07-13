## Department Highest Salary
Table: Employee
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id is the primary key column for this table.
departmentId is a foreign key of the ID from the Department table.
Each row of this table indicates the ID, name, and salary of an employee. It also contains the ID of their department.
 

Table: Department
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id is the primary key column for this table. It is guaranteed that department name is not NULL.
Each row of this table indicates the ID of a department and its name.

Find employees who have the highest salary in each of the departments.
-- 三个表连接 sql:
select c.name as Department, a.name as Employee, a.salary as Salary from Employee a,(select departmentId, max(salary) as salary from Employee group by departmentId) as b,Department as c
where a.salary = b.salary and a.departmentId = b.departmentId and b.departmentId = c.id;