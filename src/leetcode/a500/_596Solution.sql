-- 超过5名学生的课
-- {easy}
select class from (select class, count(*) as num from Courses group by class having num>=5) as a ;