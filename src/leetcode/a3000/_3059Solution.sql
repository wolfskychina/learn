-- 不同邮箱的用户数量
-- {sql:substring_index()},{sql:regexp}

Input: 
Emails table:
+-----+-----------------------+
| id  | email                 |
+-----+-----------------------+
| 336 | hwkiy@test.edu        |
| 489 | adcmaf@outlook.com    |
| 449 | vrzmwyum@yahoo.com    |
| 95  | tof@test.edu          |
| 320 | jxhbagkpm@example.org |
| 411 | zxcf@outlook.com      |
+----+------------------------+
Output: 
+--------------+-------+
| email_domain | count |
+--------------+-------+
| outlook.com  | 2     |
| yahoo.com    | 1     |
+--------------+-------+


SELECT SUBSTRING_INDEX(email,'@',-1) email_domain, COUNT(0) count
FROM Emails
WHERE email like '%.com'
-- WHERE email REGEXP '.com$'
GROUP BY email_domain
ORDER BY email_domain