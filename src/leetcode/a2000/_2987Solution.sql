-- 寻找房价大于全国均值的城市 {sql:avg}
select city from (select city, avg(price) as avg from Listings group by city having
avg > (select avg(price) from Listings)) as a order by city;