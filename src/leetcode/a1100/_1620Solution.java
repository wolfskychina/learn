package leetcode.a1100;
/**
 * 网络信号最好的坐标
 * {brute force}
 */
public class _1620Solution {
   
    public int[] bestCoordinate(int[][] towers, int radius) {
        int cx = 0,cy = 0,maxPower = 0;
        int maxX = 0, maxY = 0,minX = 51,minY = 51;
        for (int i = 0; i < towers.length; i++) {
            minX = Math.min(minX, towers[i][0]);
            maxX = Math.max(maxX, towers[i][0]);
            minY = Math.min(minY, towers[i][1]);
            maxY = Math.max(maxY, towers[i][1]);
        }
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int power = getPower(towers, radius, i, j);
                if (power > maxPower){
                    cx = i;
                    cy = j;
                    maxPower = power;
                }
            }
        }
        return new int[]{cx,cy};
    }

    private int getPower(int[][] towers, int radius, int x, int y) {
        int power = 0;
        for (int i = 0; i < towers.length; i++) {
            int a = x - towers[i][0];
            int b = y - towers[i][1];
            int ab = a * a + b * b;
            if (ab <= radius * radius)
                power += towers[i][2] / (1 + Math.sqrt(ab));
        }
        return power;
    }
}
