-- {sql:distinct}
-- 阅读过自己文章的作者列表
select distinct(author_id) as id from Views where author_id = viewer_id order by id;