package leetcode.a400;
/**
 * 给出圆心的坐标和圆的半径
 * 随机返回圆中一点的坐标
 */
public class _478Solution {

    double x1, x2 = 0;
    double y1, y2 = 0;
    double r;
    double x0, y0;

    public _478Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x1 = x_center - r;
        this.x2 = x_center + r;
        this.y1 = y_center - r;
        this.y2 = y_center + r;
        this.x0 = x_center;
        this.y0 = y_center;
    }

    public double[] randPoint() {

        double x, y;
        do {
            x = x1 + (x2 - x1) * Math.random();
            y = y1 + (y2 - y1) * Math.random();
        } while (Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0)) > r);

        double[] res = { x, y };
        return res;

    }
}
