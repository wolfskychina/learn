-- 每台机器的进程的平均处理时间
-- {sql:round} {sql:avg}
Table: Activity

+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| machine_id     | int     |
| process_id     | int     |
| activity_type  | enum    |
| timestamp      | float   |
+----------------+---------+

select a.machine_id as machine_id , round(avg(b.timestamp-a.timestamp),3) as processing_time from Activity a,Activity b where a.activity_type = 'start' and b.activity_type = 'end' and a.machine_id = b.machine_id and a.process_id = b.process_id group by machine_id;