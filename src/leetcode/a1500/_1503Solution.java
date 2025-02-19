package leetcode.a1500;

/**
 * 全部蚂蚁掉下树枝的时刻
 * 树枝上的蚂蚁往左或者往右移动
 * 碰面后就调转方向移动
 * 问最后一只蚂蚁掉下树枝的时刻
 * {brain teaser},{easy}
 * @param n
 * @param left
 * @param right
 * @return
 */
public class _1503Solution {
   
    /**
     * 碰面后掉头和没有掉头是一样的
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int maxLeft = 0;
        for(int i:left){
            maxLeft = Math.max(i,maxLeft);
        }
        int minRight = Integer.MAX_VALUE;
        for(int i:right){
            minRight = Math.min(i,minRight);
        }
        return Math.max(maxLeft,n-minRight);
    }
}
