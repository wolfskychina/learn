-- 统计所有旅客的总旅行里程
select user_id ,name ,sum(distance) as 'traveled distance' from 
( select  Users.user_id,name  ,if(distance is null, 0,distance) as distance from Users left join Rides on Users.user_id = Rides.user_id ) as a group by user_id order by user_id;