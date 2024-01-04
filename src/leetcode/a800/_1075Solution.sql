-- 项目员工的平均工龄
select project_id, round(avg(experience_years),2) as average_years 
from Project a, Employee b 
where a.employee_id = b.employee_id group by project_id ;