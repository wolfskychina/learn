-- 每个国家每个月的交易情况，包括所有交易和批准的交易
-- {sql},{DATE_FORMAT()},{IF()}
Table: Transactions

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| country       | varchar |
| state         | enum    |
| amount        | int     |
| trans_date    | date    |
+---------------+---------+
id is the primary key of this table.
The table has information about incoming transactions.
The state column is an enum of type ["approved", "declined"].
 
-- Write an SQL query to find for each month and country, the number of transactions and their total amount, the number of approved transactions and their total amount.
select a.month, a.country , trans_count, IF(approved_count is NULL, 0, approved_count ) as approved_count, trans_total_amount, IF ( approved_total_amount is NULL, 0, approved_total_amount ) as approved_total_amount from 
(select DATE_FORMAT(trans_date, '%Y-%m') AS month ,country,count(*) as trans_count,sum(amount) as trans_total_amount from Transactions group by month,country ) a left join 
(select DATE_FORMAT(trans_date, '%Y-%m') AS month ,country ,count(*) as approved_count ,sum(amount) as approved_total_amount from Transactions where state = 'approved' group by month,country) b on  a.month = b.month and (a.country = b.country or (a.country is null and b.country is null));

-- 在分组后统计的时候增加筛选的条件
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
    COUNT(IF(state = 'approved', 1, NULL)) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(IF(state = 'approved', amount, 0)) AS approved_total_amount
FROM Transactions
GROUP BY month, country