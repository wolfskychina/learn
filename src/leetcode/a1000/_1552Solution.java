package leetcode.a1000;

import java.util.Arrays;
/**
 * 将m个小球放到一维数组标记的位置上
 * 求所有放置位置中，使得其中两个小球的最近距离的最大值是多少
 */
public class _1552Solution {

    /**
     * {binary search}
     * 将两个小球之间的最小距离k作为变量
     * 如果一种方案小球之间的最小距离为k，那么将其他距离大于k的小球
     * 重新按照最小距离k放置（如果可能的话），最小距离不会改变
     * 在放置的时候，采用贪心的方式，将第一个球放到最左侧的篮子里面
     * 将剩余的小球从k距离之后的第一个篮子，以此类推。如果m个小球都能放下
     * 说明最小距离为k是可以的。那么增大k的大小，否则减少k的大小。
     * 知道找到满足要求的最大的k。
     * 
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
                if(cnt==m) return true;
            }
        }
        return false;
    }
}
