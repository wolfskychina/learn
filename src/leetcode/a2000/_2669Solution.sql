-- 统计艺术家出现的次数 {sql:easy}
select artist,count(*) as occurrences from 
Spotify group by artist order by occurrences desc, artist asc;