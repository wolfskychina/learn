-- {sql:abs()}
select abs(engmax-markmax) as  salary_difference  from (select 1, max(salary) as engmax from Salaries where department = 'Engineering' ) as a,
(select 1, max(salary) as markmax from Salaries where department = 'Marketing' ) as  b where a.1 = b.1;

