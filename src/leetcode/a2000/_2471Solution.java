package leetcode.a2000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 逐层排序二叉树所需要的最少交换次数
 * {binary tree}
 */
public class _2471Solution {

    /**
     * 置换环的概念，能够保证最少的交换次数
     * 
     * @param root
     * @return
     */
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size], temp = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                arr[i] = temp[i] = cur.val;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.sort(temp);
            for (int i = 0; i < arr.length; i++)
                map.put(temp[i], i);
            for (int i = 0; i < arr.length; i++) {
                // TODO 置换环的概念 关键是能够保证花费最少交换次数
                while (arr[i] != temp[i]) {
                    // map是正确顺序中的位置
                    int j = map.get(arr[i]);
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    ans++;
                }
            }
        }
        return ans;
    }
}
