package leetcode.a800;
/**
 * 两个矩形是否重叠
 * 矩形的边都是水平或者垂直的
 */
public class _836Solution {

    /**
     * 正向思考，重叠的条件
     * 需要比较的次数比较多
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        return ((x1 > x3 && x1 < x4) || (x2 > x3 && x2 < x4) || (x3 > x1 && x3 < x2) || (x4 > x1 && x4 < x2))
                && ((y1 > y3 && y1 < y4) || (y2 > y3 && y2 < y4) || (y3 > y1 && y3 < y2) || (y4 > y1 && y4 < y2));

    }

    /**
     * 逆向思考
     * 保证两个矩形完全不想交
     * 只需要一个矩形在另外一个矩形的四个方向
     * 比较的次数更少
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        return !(rec1[2] <= rec2[0] || // left
                rec1[3] <= rec2[1] || // bottom
                rec1[0] >= rec2[2] || // right
                rec1[1] >= rec2[3]); // top
    }

}
