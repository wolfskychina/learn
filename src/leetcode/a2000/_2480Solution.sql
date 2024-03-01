-- 分子的组成可能 {sql:easy}
select a.symbol as metal , b.symbol as nonmetal from Elements a, Elements b
 where 
a.type = 'Metal' and b.type = 'Nonmetal';