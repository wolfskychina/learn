-- 直线上最近的两点的距离
-- {easy}
select min(abs(a.x-b.x)) as shortest from Point as a, Point as b where a.x !=b.x;