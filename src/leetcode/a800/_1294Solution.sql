-- 不同国家的温度类型
-- {sql:case when}
select country_name , CASE WHEN avgtmp <= 15 THEN 'Cold'
            WHEN avgtmp >= 25 THEN 'Hot'
            ELSE 'Warm' END AS WEATHER_TYPE
 from Countries ,
(select country_id, avg(weather_state) as avgtmp from Weather where Month(day) = 11 and Year(day) =2019
group by country_id ) as a where Countries.country_id = a.country_id;