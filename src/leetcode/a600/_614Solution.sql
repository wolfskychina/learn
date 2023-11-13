-- 第二层的用户的粉丝数量
-- 第二层指本身follow了别人，又被别人follow
select followee as follower , count(*) as num  from Follow 
where followee in (select distinct follower from Follow) 
group by followee order by follower;