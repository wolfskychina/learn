Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
Output: 
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

-- sql:{sql:limit}
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET   N = N-1;
  RETURN (
      # Write your MySQL query statement below.
    
      SELECT DISTINCT(salary) from Employee order by salary DESC
      LIMIT 1 OFFSET N
      # LIMIT N, 1 limit子句双参数的两种形式，n表示偏移量
  );
END