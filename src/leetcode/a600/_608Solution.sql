-- 标记每一个节点是否是根节点、中间结点和叶子节点
{sql:union}

Table: Tree
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| p_id        | int  |
+-------------+------+
id is the column with unique values for this table.
Each row of this table contains information about the id of a node and the id of its parent node in a tree.
The given structure is always a valid tree.
 

Each node in the tree can be one of three types:

"Leaf": if the node is a leaf node.
"Root": if the node is the root of the tree.
"Inner": If the node is neither a leaf node nor a root node.

--
select id, 'Root' as type from Tree where p_id is null union
select id, 'Inner' as type from Tree where p_id is not null and id  in (select distinct p_id as id from Tree where p_id is not null) union
select id , 'Leaf' as type from Tree where p_id is not null and id not in (select distinct p_id as id from Tree where p_id is not null);