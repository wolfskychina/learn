package leetcode.a1000;

import java.util.Arrays;
/**
 * 高度检查器
 * 有多少数字不在排序后应该在的位置上
 */
public class _1051Solution {
   
    public int heightChecker(int[] heights) {

        int[] copy = heights.clone();
        int count=0;
        Arrays.sort(heights);
        for(int i=0;i<copy.length;i++){
            if(copy[i]!=heights[i])
                count++;
        }
        return count;
    }

    /**
     * 基数排序，统计每个数应该在的区间
     * {counting sorting}
     * @param heights
     * @return
     */
    public int heightChecker1(int[] heights) {
        int[] helpers = new int[101];
        // 先进行词频统计
        for (int height : heights) {
            helpers[height]++;
        }
        // 进行前缀和统计
        for (int i = 2; i < 101; i++) {
            helpers[i] += helpers[i - 1];
        }
        int count = 0;
        int hLen = heights.length;
        for (int i = 0; i < hLen; i++) {
            // 不在这个数应该在的区间
            if (helpers[heights[i]] < i + 1 || helpers[heights[i] - 1] > i) {
                count++;
            }
        }
        return count;
    }
}
