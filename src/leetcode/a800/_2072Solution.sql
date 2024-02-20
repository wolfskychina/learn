-- 赢得比赛的大学，谁高于90分的学生多获胜
-- {sql:case when}
SELECT CASE
WHEN n > c then 'New York University'
WHEN n < c then 'California University'
ELSE 'No Winner'
END AS winner 
FROM
(SELECT COUNT(*) AS n FROM NewYork WHERE score >= 90) AS u1 ,
(SELECT COUNT(*) AS c FROM California WHERE score >= 90) AS u2

