-- 某一个特定月播放的儿童电影
-- {sql:easy}
select distinct(title) as title from TVProgram a, Content b
where a.content_id  = b.content_id 
and Kids_content = 'Y'
and content_type = 'Movies'
and Month(program_date) = 6 and Year(program_date) = 2020;