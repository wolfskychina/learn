-- 上级经理已离职的公司员工
select e_id as employee_id from (
(select employee_id as e_id, manager_id as m_id from Employees  where manager_id is not null and salary<30000) as a left join
Employees as b on a.m_id = b.employee_id ) where b.employee_id is  null order by e_id;