-- 统计所有旅客的总旅行里程
select user_id ,name ,if(distance is null, 0,distance) as 'traveled distance' from
( select Users.user_id, name,distance from Users left join 
(  select user_id , sum(distance) as distance from  Rides group by user_id ) as b   on Users.user_id = b.user_id  ) as c order by user_id;