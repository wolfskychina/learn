-- 连续的空位
-- {sql:abs},{sql:left join},{sql:distinct}
Cinema =
| seat_id | free |
| ------- | ---- |
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |

select distinct a.seat_id from cinema a join cinema b  
on abs(a.seat_id - b.seat_id) = 1  
and a.free = true and b.free = true order by a.seat_id ;