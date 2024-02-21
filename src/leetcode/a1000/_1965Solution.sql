-- {sql:union}
-- mysql没有fulljoin
select employee_id from (select employee_id from Employees union select employee_id from Salaries) as c where employee_id not in(
    select a.employee_id from Employees a, Salaries b where a.employee_id = b.employee_id
) order by employee_id;