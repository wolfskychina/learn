package leetcode.a400;

import java.util.List;
/**
 * 判断一个多边形是不是凸多边形
 * {math}
 * TODO
 */
public class _469Solution {

    /**
     * 利用向量的叉乘判断
     * 如果有叉乘正负不相同，说明有凹包
     * @param points
     * @return
     */
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur, pre = 0;
        for (int i = 0; i < n; i++) {
            cur = crossProduct(points.get((i + 1) % n).get(0) - points.get(i).get(0),
                    points.get((i + 1) % n).get(1) - points.get(i).get(1),
                    points.get((i + 2) % n).get(0) - points.get(i).get(0),
                    points.get((i + 2) % n).get(1) - points.get(i).get(1));
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;

    }

    private long crossProduct(long x1, long y1, long x2, long y2) {
        return x1 * y2 - x2 * y1;
    }
}
