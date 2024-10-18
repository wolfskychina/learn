-- 查询净现金 {sql:easy}
select a.id,a.year, if(npv is null, 0,npv) as npv from Queries a left join NPV b on a.id =b.id and a.year = b.year;