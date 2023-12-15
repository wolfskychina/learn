package leetcode.a800;

/**
 * 判断二维平面上一个圆形和方形是否有相交的点
 * {graphics}
 */
public class _1401Solution {

    /**
     * 自己的解法需要遍历方形边上的所有点
     */
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 有交点的情况
        // 圆心在方形内侧
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2)
            return true;

        // 方形在圆内侧
        // (x1,y1)
        if ((x1 - xCenter) * (x1 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius)
            return true;
        // (x1,y2)
        if ((x1 - xCenter) * (x1 - xCenter) + (y2 - yCenter) * (y2 - yCenter) <= radius * radius)
            return true;
        // (x2,y1)
        if ((x2 - xCenter) * (x2 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius)
            return true;
        // (x2,y2)
        if ((x2 - xCenter) * (x2 - xCenter) + (y2 - yCenter) * (y2 - yCenter) <= radius * radius)
            return true;

        // 方形在边界上某一点到圆心的距离小于等于半径
        for (int i = x1; i <= x2; i++) {
            if ((i - xCenter) * (i - xCenter) + (y2 - yCenter) * (y2 - yCenter) <= radius * radius)
                return true;
            if ((i - xCenter) * (i - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius)
                return true;
        }
        for (int i = y1; i <= y2; i++) {
            if ((i - yCenter) * (i - yCenter) + (x1 - xCenter) * (x1 - xCenter) <= radius * radius)
                return true;
            if ((i - yCenter) * (i - yCenter) + (x2 - xCenter) * (x2 - xCenter) <= radius * radius)
                return true;
        }

        return false;

    }

    /**
     * 按照矩形的四条边将二维空间分割成9个象限
     * 分别考虑圆心在这9个象限的情况，只需要判断9次
     * TODO 
     */
    public boolean checkOverlap1(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        /* 圆心在矩形内部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 圆心在矩形上部 */
        if (x1 <= xCenter && xCenter <= x2 && y2 <= yCenter && yCenter <= y2 + radius) {
            return true;
        }
        /* 圆心在矩形下部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 - radius <= yCenter && yCenter <= y1) {
            return true;
        }
         /* 圆心在矩形左部 */
        if (x1 - radius <= xCenter && xCenter <= x1 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
         /* 圆心在矩形右部 */
        if (x2 <= xCenter && xCenter <= x2 + radius && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 矩形左上角 */
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius)  {
            return true;
        }
        /* 矩形左下角 */
        if (distance(xCenter, yCenter, x1, y1) <= radius * radius) {
            return true;
        }
        /* 矩形右上角 */
        if (distance(xCenter, yCenter, x2, y2) <= radius * radius) {
            return true;
        }
        /* 矩形右下角 */
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        /* 无交点 */
        return false;
    }

    public long distance(int ux, int uy, int vx, int vy) {
        return (long)Math.pow(ux - vx, 2) + (long)Math.pow(uy - vy, 2);
    }
}
