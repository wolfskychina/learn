-- 合作过至少三次的演员和导演
-- {easy}
select actor_id, director_id from 
(select actor_id,director_id,count(*) as num from ActorDirector group by actor_id,director_id having num >=3) as a ; 