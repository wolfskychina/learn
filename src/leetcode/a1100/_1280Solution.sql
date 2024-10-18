-- 学生参加各科测试的次数
-- {sql:if},{sql:left join}

Table: Students
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| student_id    | int     |
| student_name  | varchar |
+---------------+---------+
 

Table: Subjects
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| subject_name | varchar |
+--------------+---------+

Table: Examinations
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| subject_name | varchar |
+--------------+---------+

-- sql:
select a.student_id,a.student_name,a.subject_name, if(attended_exams is null,0,attended_exams) as attended_exams from 
(select * from Students , Subjects  where 1=1) as  a
 left join 
(select student_id, subject_name , count(*) as attended_exams from Examinations group by student_id, subject_name) as b 
on a.student_id =b.student_id and a.subject_name = b.subject_name 
 order by student_id,subject_name