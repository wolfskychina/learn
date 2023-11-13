-- 部门不同月份人均收入和公司不同月份人均收入比较 
-- {sql:if},{sql:date_format},{sql:round}
select c.pay_month, c.department_id, if(deptavg>totalavg,'higher',if(deptavg=totalavg, 'same','lower')) as comparison 
from 
(select date_format(pay_date, '%Y-%m') as pay_month,department_id, round(avg(amount),2) as deptavg 
from Salary a,Employee b where a.employee_id = b.employee_id group by pay_month,department_id) as c, 
(select round(avg(amount),2) as totalavg, date_format(pay_date, '%Y-%m') as pay_month 
from Salary group by pay_month ) as d where c.pay_month = d.pay_month;