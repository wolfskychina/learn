-- 有订阅但是无流量的帐户数

SELECT COUNT(account_id)  accounts_count
FROM Subscriptions 
WHERE   end_date>='2021-01-01' 
        AND start_date<='2021-12-31' #订阅的开始和结束日期的范围包含2021年
        AND account_id NOT IN (
            SELECT account_id  #在2021年有过会话的账户id
            FROM Streams
            WHERE LEFT(stream_date,4)=2021
        ) 