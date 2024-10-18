-- 用户注册的确认率
-- {sql:leftjoin}
select s.user_id,if(confirmation_rate is null, 0.00,confirmation_rate) as confirmation_rate from Signups as s left join
(
select a.user_id , round(confirmsum/totalsum,2) as confirmation_rate from 
(select user_id, count(*) as confirmsum from Confirmations where action = 'confirmed' group by user_id ) a ,
 (select user_id, count(*) as totalsum from Confirmations b group by user_id ) b where a.user_id = b.user_id ) c 
 
 on s.user_id = c.user_id;