-- 奥运奖牌榜排名 {sql:easy}
select * from Olympic order by gold_medals desc,silver_medals desc,bronze_medals desc, country  asc; 