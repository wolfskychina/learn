package leetcode.a300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import leetcode.util.TreeNode;
/**
 * 对一颗二叉树逐列自上而下的遍历，左右相邻接点间距一致
 */
public class _314Solution {

    /**
     * 先层次遍历，标记节点的相对坐标，利用TreeMap的特性从小到大输出
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // 先根遍历，计算度，存放到TreeMap中
        Map<Integer, List<Integer>> map = new TreeMap<>();
        if (root != null)
            layerTravserse(map, root, 0);
        List<List<Integer>> res = new ArrayList<>();

        // 按照key大小输出TreeMap到res
        /*
         * for(Map.Entry<Integer,List<Integer>> en:map){
         * List<Integer> list = en.getValue();
         * res.add(list);
         * 
         * }
         */
        map.forEach((key, value) -> res.add(value));

        return res;

    }

    private void layerTravserse(Map<Integer, List<Integer>> map, TreeNode p, int index) {

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> iq = new LinkedList<>();
        if (p == null)
            return;
        queue.offer(p);
        iq.offer(0);
        while (!queue.isEmpty()) {

            TreeNode n = queue.poll();
            int i = iq.poll();

            // map.getOrDefault(index, new ArrayList<Integer>()).add(p.val);
            List<Integer> v = map.get(i);
            if (v == null) {
                List<Integer> list = new ArrayList<>();
                list.add(n.val);
                map.put(i, list);
            } else {
                v.add(n.val);
            }

            if(n.left!=null) {
                queue.offer(n.left);
                iq.offer(i-1);
            }
            if(n.right!=null){
                queue.offer(n.right);
                iq.offer(i+1);
            }

        }

    }

}
