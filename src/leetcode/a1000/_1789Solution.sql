-- {sql:union}
select a.employee_id ,a.department_id from Employee a,
(select employee_id ,count(*) as num from Employee group by employee_id) as b where a.employee_id = b.employee_id and a.primary_flag = 'Y'
union
select c.employee_id ,c.department_id from Employee c,
(select employee_id ,count(*) as num from Employee group by employee_id) as d
 where c.employee_id = d.employee_id and d.num=1
and c.primary_flag = 'N'