-- 查找回答率最高的问题
Table: SurveyLog
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| action      | ENUM |
| question_id | int  |
| answer_id   | int  |
| q_num       | int  |
| timestamp   | int  |
+-------------+------+
This table may contain duplicate rows.
action is an ENUM (category) of the type: "show", "answer", or "skip".
Each row of this table indicates the user with ID = id has taken an action with the question question_id at time timestamp.
If the action taken by the user is "answer", answer_id will contain the id of that answer, otherwise, it will be null.
q_num is the numeral order of the question in the current session.


# Write your MySQL query statement below
select question_id as survey_log from (select a.ansNum/b.totalNum as rate, a.question_id as question_id from (select count(*) as ansNum ,question_id from SurveyLog where action = 'answer' group by question_id ) as a,
(select count(*) as totalNum ,question_id from SurveyLog group by question_id ) as b where a.question_id = b.question_id order by rate desc, question_id asc) as c limit 1;