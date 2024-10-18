package leetcode.a1700;
/**
 * 找到星型图的中心节点
 * {easy}
 */
public class _1791Solution {
   
    public int findCenter(int[][] edges) {

        if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
}
