-- 排名靠前的旅行者 {easy}
select Users.name, if(Sum(distance) is null,0,Sum(distance)) as travelled_distance 
from Users left join Rides on Users.id = Rides.user_id group by Users.id order by travelled_distance desc,name asc