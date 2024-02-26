-- 编制比赛的主客场对阵表
select a.team_name as home_team, b.team_name as away_team 
from Teams a , Teams b where a.team_name != b.team_name;