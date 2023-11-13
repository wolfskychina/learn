-- 平面上两点最近的距离
-- {sql:sqrt}
select min(Round(SQRT((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)),2)) as shortest 
from Point2D as a, Point2D as b where a.x !=b.x or a.y != b.y ;