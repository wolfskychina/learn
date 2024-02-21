-- 每位经理下属的员工个数
select  a.employee_id ,a.name, count(*) as reports_count, round(avg(b.age),0) as average_age   from Employees a ,Employees b where
b.reports_to = a.employee_id group by employee_id order by a.employee_id;