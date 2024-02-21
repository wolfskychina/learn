-- {sql:self join}
select project_id from 
 (select project_id, count(*) as num from Project group by project_id) as b,
(select max(num) as num from (
    select project_id ,count(*) as num from Project group by project_id
) as a ) as c where b.num = c.num;