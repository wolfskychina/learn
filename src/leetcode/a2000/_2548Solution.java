package leetcode.a2000;

import java.util.Arrays;

/**
 * 填满背包的最大价格
 * 贪心但是需要注意精度
 * {greedy},{easy}
 */
public class _2548Solution {

    public double maxPrice(int[][] items, int capacity) {
        
        // 比大小的时候将除法比较转换成乘法比较，避免浮点数作差之后转换成整数
        // 损失精度
        Arrays.sort(items, (a, b) -> b[0] * a[1] - a[0] * b[1]);
        double max = 0;

        for (int[] i : items) {
            if (capacity - i[1] >= 0) {
                capacity -= i[1];
                max += i[0];
            } else {
                max += (double)i[0] * ((double)capacity / (double)i[1]);
                return max;
            }
        }
        return capacity==0?max:-1;
    }

    public static void main(String[] args){

        _2548Solution so = new _2548Solution();
        int[][] items = {{50,1},{10,8}};
        so.maxPrice(items, 5);
    }
}
