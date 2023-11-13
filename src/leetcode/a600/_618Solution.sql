-- 分组统计学生信息，行转列
-- {TODO},{sql:pivot},{sql:case when}
-- 因为行转列之后每一列的行数不一定一样，为了保证所有行都输出，需要max函数

Student table:
+--------+-----------+
| name   | continent |
+--------+-----------+
| Jane   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jack   | America   |
+--------+-----------+
Output: 
+---------+------+--------+
| America | Asia | Europe |
+---------+------+--------+
| Jack    | Xi   | Pascal |
| Jane    | null | null   |
+---------+------+--------+


select 
   max(case when continent = 'America' then name end) as America,
    max(case when continent = 'Asia' then name end) as Asia,
    max(case when continent = 'Europe' then name end) as Europe

from 
(
    select *, row_number() over (partition by continent order by name) rk 
    from student
) t
group by rk;