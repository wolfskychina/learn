package leetcode.a600;
/**
 * 24点游戏
 * 4个原始数字是可以换位置的
 */
public class _679Solution {

    public boolean judgePoint24(int[] cards) {

        int num[][] = new int[4][2];
        for (int i = 0; i < num.length; i++) {
            num[i][0] = cards[i];
            num[i][1] = 1;
        }

        for (int i = 0; i < 3; i++) {

            // 四种运算
            for (int j = 1; j <= 4; j++) {
                if (compute4(num, i, j))
                    return true;
            }

        }
        return false;
    }

    private boolean compute4(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int[][] newnum = new int[num.length - 1][2];
        for (int k = 0; k < i; k++) {
            newnum[k] = num[k];
        }
        for (int k = i + 1; k < newnum.length; k++) {
            newnum[k] = num[k + 1];
        }

        newnum[i] = dealtwonum(num[i], num[i + 1], j);

        for (int k = 0; k < 2; k++) {

            // 四种运算
            for (int q = 1; q <= 4; q++) {
                if (compute3(newnum, k, q))
                    return true;
            }

        }
        return false;
    }

    private boolean compute3(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int[][] newnum = new int[num.length - 1][2];
        for (int k = 0; k < i; k++) {
            newnum[k] = num[k];
        }
        for (int k = i + 1; k < newnum.length; k++) {
            newnum[k] = num[k + 1];
        }

        newnum[i] = dealtwonum(num[i], num[i + 1], j);

        // 四种运算
        for (int q = 1; q <= 4; q++) {
            if (compute2(newnum, 0, q))
                return true;
        }

        return false;
    }

    private boolean compute2(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int newnum[] = dealtwonum(num[i], num[i + 1], j);
        if (newnum[0] / newnum[1] == 24)
            return true;
        return false;
    }

    private int[] dealtwonum(int[] a, int[] b, int i) {

        int[] res = new int[2];
        if (i == 1) {
            res[0] = a[0] * b[1] + a[1] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 2) {
            res[0] = a[0] * b[1] - a[1] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 3) {
            res[0] = a[0] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 4) {
            res[0] = a[0] * b[1];
            res[1] = a[1] * b[0];
            return res;
        }
        return res;
    }
}
