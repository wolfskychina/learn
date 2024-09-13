-- 筛选文字超过140个字符或者#符和@符号超过3个的帖子
-- {sql:replace()},{sql:length()}
SELECT 
    tweet_id 
FROM
    Tweets 
WHERE
    LENGTH(content) > 140 OR -- It includes more than 3 hashtags.
    (LENGTH(content) - LENGTH(REPLACE(content, '#', ''))) > 3 OR -- It includes more than 3 hashtags.
    (LENGTH(content) - LENGTH(REPLACE(content, '@', ''))) > 3 -- It has more than 3 mentions. 
ORDER BY
    tweet_id