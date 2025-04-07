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

-- 使用left join的版本，题目给出的数据保证最左边的列数据最多
-- left join需要使用row_number关联
select America,Asia,Europe 
from(
    select row_number() over(order by name) as rn,name as America from student
    where continent='America'
) a
left join(
    select row_number() over(order by name) as rn,name as Asia from student
    where continent='Asia'
) b on a.rn=b.rn
left join(
    select row_number() over(order by name) as rn,name as Europe from student
    where continent='Europe'
) c on a.rn=c.rn