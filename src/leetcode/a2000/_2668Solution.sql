-- 查询员工的最大薪水 {sql:easy}
select emp_id, firstname, lastname, max(salary) as salary,department_id
from Salary group by emp_id order by emp_id;