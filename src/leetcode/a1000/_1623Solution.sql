-- {sql:easy} 从三个学校各选出一个队员组队，所有的组队方式
select a.student_name as member_A, b.student_name as member_B, c.student_name as member_C
from SchoolA as a, SchoolB as B, SchoolC as C where a.student_id != b.student_id and b.student_id!=c.student_id and c.student_id!=a.student_id
and a.student_name!=b.student_name and b.student_name != c.student_name and c.student_name!=a.student_name;