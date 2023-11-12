-- 朋友最多的用户
--{sql:full join},{sql:ifnull},{sql:union}
-- mysql没有full join只能两个表分别在前面进行left join然后将结果集union
select id, sum(num) as num from 
(
select a.requester_id as id, ifnull(num,0)+ifnull(num2,0) as num from 
(select requester_id , count(distinct accepter_id) as num from requestAccepted group by requester_id) as a left join  (select accepter_id ,count(distinct requester_id) as num2 from requestAccepted group by accepter_id ) as b on a.requester_id = b.accepter_id
union 
  select  c.accepter_id as id, ifnull(num,0)+ifnull(num2,0) as num from 
 (select accepter_id ,count(distinct requester_id) as num2 from requestAccepted group by accepter_id ) as c  left join 
 (select requester_id , count(distinct accepter_id) as num from requestAccepted group by requester_id) as d on  c.accepter_id = d.requester_id) as c
 group by id order by num desc limit 1;