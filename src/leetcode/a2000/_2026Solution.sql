-- 低质量问题的数量 {sql:easy}
select problem_id from Problems where likes/(likes+dislikes)<0.6 order by problem_id;