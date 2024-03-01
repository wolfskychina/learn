-- 字段字符串拼接 {sql:concat()},{sql:substring()}
select t.person_id, concat(t.name, "(", substring(profession, 1, 1), ")") as name
    from Person t
        order by t.person_id desc;