-- 返回票数最多的候选人
Table: Candidate
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
+-------------+----------+

Table: Vote
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| candidateId | int  |
+-------------+------+

--
select a.name  as name from Candidate as a, 
(select count(*) as num , candidateId from Vote 
    group by candidateId order by num desc limit 1) as b 
where
a.id = b.candidateId;