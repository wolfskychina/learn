-- 对于所有员工，互换性别字符
-- {sql:case when}
Table: Salary
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
| sex         | ENUM     |
| salary      | int      |
+-------------+----------+
id is the primary key (column with unique values) for this table.
The sex column is ENUM (category) value of type ('m', 'f').
The table contains information about an employee.

-- sql:
update Salary set sex = CASE sex when 'm' then 'f' else 'm' end;
