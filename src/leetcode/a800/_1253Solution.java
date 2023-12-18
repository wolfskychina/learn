package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * 重新构建2行的二进制矩阵
 */
public class _1253Solution {

    /**
     * {greedy}
     * @param upper
     * @param lower
     * @param colsum
     * @return
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        int sum2 = 0;
        for (int i : colsum) {
            sum += i;
            if (i == 2)
                sum2 += 1;
        }
        // 不光需要校验1的数量，还要校验某一列的和为2的列的数量是否大于uppser
        // 和lower里面更小的数，否则无法分配足够的给和为2的列
        if (sum != upper + lower || sum2 > Math.min(upper, lower))
            return res;
        List<Integer> uplist = new ArrayList<>();
        List<Integer> lowlist = new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            uplist.add(0);
            lowlist.add(0);
        }
        res.add(uplist);
        res.add(lowlist);

        // 先填充值为2的
        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == 2) {
                uplist.set(i, 1);
                lowlist.set(i, 1);
                upper--;
                lower--;
            }
        }

        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == 1) {
                if (upper != 0) {
                    uplist.set(i, 1);
                    lowlist.set(i, 0);
                    upper--;
                } else {
                    uplist.set(i, 0);
                    lowlist.set(i, 1);
                    lower--;
                }
            } else if (colsum[i] == 0) {
                uplist.set(i, 0);
                lowlist.set(i, 0);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _1253Solution so = new _1253Solution();
        int[] array = { 1, 1, 1 };
        so.reconstructMatrix(2, 1, array);
    }
}
