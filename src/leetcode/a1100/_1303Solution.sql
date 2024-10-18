-- 每个人所在的团队的人数 {sql:easy}
select a.employee_id  , count(*) as team_size from Employee a,Employee b
where a.team_id = b.team_id group by a.employee_id, a.team_id;