-- 统计所有15年投资额至少有两人相同，且不存在两个人在同一个城市的所有行的16年投资的总额
-- {sql:intersection},{sql:in}
Table: Insurance
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
pid is the primary key (column with unique values) for this table.
Each row of this table contains information about one policy where:
pid is the policyholders policy ID.
tiv_2015 is the total investment value in 2015 and tiv_2016 is the total investment value in 2016.
lat is the latitude of the policy holder's city. It's guaranteed that lat is not NULL.
lon is the longitude of the policy holder's city. It's guaranteed that lon is not NULL.

select round(sum(a.tiv_2016),2) as tiv_2016 from Insurance as a
 where 
 a.pid in 
 (select pid from (select pid,count(*) as num from Insurance group by lat,lon having num=1) as b ) 
 and a.tiv_2015 in 
 (select tiv_2015 from (select tiv_2015,count(*) as num from Insurance group by tiv_2015 having num>1) as c );