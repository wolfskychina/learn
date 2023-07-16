# 删掉email列重复的行，保留最小的id
# 最快的方法
delete from Person where id not in(
    select t.id from (
        select min(id) as id from Person group by email
    ) t
)
# 不好的方法，临时表的记录数被指数放大
DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND
p1.Id > p2.Id