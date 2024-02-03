-- 所有帖子的评论数{sql:easy}
# Write your MySQL query statement below
select a.sub_id as post_id , if(number_of_comments is null,0,number_of_comments) as number_of_comments from
(select distinct(sub_id) as sub_id from Submissions where parent_id is null) as a left join 
(select parent_id, count(distinct(sub_id)) as number_of_comments  from  Submissions group by parent_id ) as b on a.sub_id = b.parent_id order by sub_id;