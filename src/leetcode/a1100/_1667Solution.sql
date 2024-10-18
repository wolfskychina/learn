-- TODO {sql:concat()},{sql:upper()},{sql:left()},{sql:right()},{sql:lower()}
-- sql大小写字符转换
select user_id, CONCAT(UPPER(left(name, 1)), LOWER(RIGHT(name, length(name) - 1))) as name
from Users
order by user_id
