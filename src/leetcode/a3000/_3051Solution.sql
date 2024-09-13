-- {sql:easy}
select a.candidate_id from 
(select candidate_id from Candidates where skill = 'Python' ) as a,
(select candidate_id from Candidates where skill = 'Tableau' ) as b,
(select candidate_id from Candidates where skill = 'PostgreSQL' ) as c
where a.candidate_id = b.candidate_id and b.candidate_id=c.candidate_id order by a.candidate_id;
