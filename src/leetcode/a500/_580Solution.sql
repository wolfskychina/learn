Table: Student
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| student_name | varchar |
| gender       | varchar |
| dept_id      | int     |
+--------------+---------+
student_id is the primary key (column with unique values) for this table.
dept_id is a foreign key (reference column) to dept_id in the Department tables.
Each row of this table indicates the name of a student, their gender, and the id of their department.

Table: Department
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| dept_id     | int     |
| dept_name   | varchar |
+-------------+---------+
dept_id is the primary key (column with unique values) for this table.
Each row of this table contains the id and the name of a department.

-- 
select  a.dept_name, count(b.student_id) as student_number 
    from 
Department as a left join Student as b 
on a.dept_id = b.dept_id 
group by a.dept_id order by student_number desc, dept_name asc;