-- {sql:easy}最高成绩和最低成绩的差
select max(total)-min(total) as difference_in_score from
 (select assignment1+assignment2+assignment3 as total from Scores) as a;