package leetcode.a1000;
/**
 * 找到最近的有相同的x轴或者y轴坐标的点
 * {easy}
 */
public class _1779Solution {
   
    public int nearestValidPoint(int x, int y, int[][] points) {

        double mindis = Double.MAX_VALUE;
        int minidx = -1;
        for(int i=0;i<points.length;i++){

            if(x==points[i][0]||y==points[i][1]){

                double dis = Math.sqrt((points[i][0]-x)*(points[i][0]-x)+(points[i][1]-y)*(points[i][1]-y));
                if(dis<mindis){

                    mindis = dis;
                    minidx = i;
                }
            }
        }
        return minidx;
    }
}
