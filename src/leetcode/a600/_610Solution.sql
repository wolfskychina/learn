-- 判断三条线段能否构成三角形
select x,y,z,'Yes' as triangle from Triangle where x+y>z and x+z>y and y+z>x
union
select x,y,z,'No' as triangle from Triangle where x+y<=z or x+z<=y or y+z<=x;

select *,
if(x+y>z and x+z>y and y+z>x,'Yes','No') as triangle
from Triangle