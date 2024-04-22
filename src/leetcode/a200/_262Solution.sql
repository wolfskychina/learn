# 统计订单的取消率
-- {sql:sum},{sql:case when}

select request_at as `Day`, round(sum(case when status = 'cancelled_by_driver' or status = 'cancelled_by_client' then 1
 else 0 end) / count(*), 2)  `Cancellation Rate`
from Trips t
inner join Users u1
on t.client_id = u1. users_id
inner join Users u2
on t.driver_id = u2.users_id
where request_at between "2013-10-01"
  and  "2013-10-03"
  and  u1.banned = 'No' and u2.banned = 'No'
group by request_at

--
Table: Trips

+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| client_id   | int      |
| driver_id   | int      |
| city_id     | int      |
| status      | enum     |
| request_at  | date     |
+-------------+----------+
id is the primary key (column with unique values) for this table.
The table holds all taxi trips. Each trip has a unique id, while client_id and driver_id are foreign keys to the users_id at the Users table.
Status is an ENUM (category) type of ('completed', 'cancelled_by_driver', 'cancelled_by_client').


Table: Users

+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| users_id    | int      |
| banned      | enum     |
| role        | enum     |
+-------------+----------+
users_id is the primary key (column with unique values) for this table.
The table holds all users. Each user has a unique users_id, and role is an ENUM type of ('client', 'driver', 'partner').
banned is an ENUM (category) type of ('Yes', 'No').