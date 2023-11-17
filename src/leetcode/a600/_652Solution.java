package leetcode.a600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.TreeNode;

/**
 * 找出二叉树中所有相同的子树
 * 相同的子树指结构相同且所有节点的值均相同
 * {TODO}
 */
public class _652Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    String dfs(TreeNode root) {
        if (root == null)
            return " ";
        StringBuilder sb = new StringBuilder();
        // 按照先根遍历拼接特征值
        // 如果按照中根遍历顺序，可能会产生结构不相同但是特征值相同
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2)
            ans.add(root);
        return key;
    }

}
