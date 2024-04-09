# 寻找表中比上一日气温高的行
-- {sql:date_add()}
select a.id from Weather a , Weather b
where a.recordDate = DATE_ADD(b.recordDate, INTERVAL 1 DAY) and a.temperature > b.temperature;