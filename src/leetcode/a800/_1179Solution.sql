-- 行转列{sql:transform},{sql:sum},{sql:case when then }
Department table:
+------+---------+-------+
| id   | revenue | month |
+------+---------+-------+
| 1    | 8000    | Jan   |
| 2    | 9000    | Jan   |
| 3    | 10000   | Feb   |
| 1    | 7000    | Feb   |
| 1    | 6000    | Mar   |
+------+---------+-------+
Output: 
+------+-------------+-------------+-------------+-----+-------------+
| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
+------+-------------+-------------+-------------+-----+-------------+
| 1    | 8000        | 7000        | 6000        | ... | null        |
| 2    | 9000        | null        | null        | ... | null        |
| 3    | null        | 10000       | null        | ... | null        |
+------+-------------+-------------+-------------+-----+-------------+


SELECT ID,
SUM(CASE WHEN MONTH='JAN' THEN REVENUE END) AS JAN_REVENUE,
SUM(CASE WHEN MONTH='FEB' THEN REVENUE END) AS FEB_REVENUE,
SUM(CASE WHEN MONTH='MAR' THEN REVENUE END) AS MAR_REVENUE,
SUM(CASE WHEN MONTH='APR' THEN REVENUE END) AS APR_REVENUE,
SUM(CASE WHEN MONTH='MAY' THEN REVENUE END) AS MAY_REVENUE,
SUM(CASE WHEN MONTH='JUN' THEN REVENUE END) AS JUN_REVENUE,
SUM(CASE WHEN MONTH='JUL' THEN REVENUE END) AS JUL_REVENUE,
SUM(CASE WHEN MONTH='AUG' THEN REVENUE END) AS AUG_REVENUE,
SUM(CASE WHEN MONTH='SEP' THEN REVENUE END) AS SEP_REVENUE,
SUM(CASE WHEN MONTH='OCT' THEN REVENUE END) AS OCT_REVENUE,
SUM(CASE WHEN MONTH='NOV' THEN REVENUE END) AS NOV_REVENUE,
SUM(CASE WHEN MONTH='DEC' THEN REVENUE END) AS DEC_REVENUE
FROM DEPARTMENT
GROUP BY ID