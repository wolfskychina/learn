-- {mysql:case when}
-- 三角形分类

select 
(case 
    when (A + B <= C or A + C <= B or B + C <= A) then 'Not A Triangle'
    when (A = B and B = C) then 'Equilateral'
    when (A != B and B != C and A != C) then 'Scalene'
    else 'Isosceles' end
) triangle_type  
from Triangles t