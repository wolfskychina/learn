package leetcode.a1600;

import java.util.Arrays;

/**
 * 任意两个符合到x轴的投影之间没有其他点的点的最远间隔距离
 * {easy}
 */
public class _1637Solution {
   
    public int maxWidthOfVerticalArea(int[][] points) {

        int[] a = new int[points.length];
        for(int i=0;i<points.length;i++){
            a[i]=points[i][0];
        }
        Arrays.sort(a);
        int max =0;
        for(int i=0;i<a.length-1;i++){
            max = Math.max(max,a[i+1]-a[i]);
        }
        return max;

    }
}
