Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id is the primary key column for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.


Write an SQL query to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.

-- sql:
select email as Email from (select email, count(*) as num from Person group by email having num>1) as a;