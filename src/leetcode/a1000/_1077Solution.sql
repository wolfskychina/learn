-- 项目员工，每个项目中经验最多的职工的id
Project table:
+-------------+-------------+
| project_id  | employee_id |
+-------------+-------------+
| 1           | 1           |
| 1           | 2           |
| 1           | 3           |
| 2           | 1           |
| 2           | 4           |
+-------------+-------------+
Employee table:
+-------------+--------+------------------+
| employee_id | name   | experience_years |
+-------------+--------+------------------+
| 1           | Khaled | 3                |
| 2           | Ali    | 2                |
| 3           | John   | 3                |
| 4           | Doe    | 2                |
+-------------+--------+------------------+
Output: 
+-------------+---------------+
| project_id  | employee_id   |
+-------------+---------------+
| 1           | 1             |
| 1           | 3             |
| 2           | 1             |
+-------------+---------------+

-- 可能会有多个人工作年限同样最长，所以需要先查到最长时间，然后回去反查
select  c.project_id,e.employee_id from 
Project d, Employee e ,
(select  project_id, max(experience_years) as max_year from Project a, Employee b 
 where a.employee_id  =  b.employee_id group by project_id) as c 
where 
    d.employee_id = e.employee_id 
    and d.project_id = c.project_id 
    and e.experience_years = c.max_year;