package leetcode.a1100;
/**
 * 二维空间中最少遍历所有节点的步数
 * {easy}
 */
public class _1266Solution {
   
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum=0;
        for(int i=1;i<points.length;i++){

            int difx = Math.abs(points[i][0]-points[i-1][0]);
            int dify = Math.abs(points[i][1]-points[i-1][1]);

            sum+=difx>dify?difx:dify;

        }
        return sum;
    }
}
