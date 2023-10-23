package leetcode.a400;

public class _465Solution {

    public int minTransfers(int[][] transactions) {

        int[][] m = new int[12][12];

        // initial matrix
        for (int i = 0; i < transactions.length; i++) {
            m[transactions[i][0]][transactions[i][1]] = transactions[i][2];
        }

        // 先ij和ji互相处理一下,减少后续迭代的次数
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

            }
        }
        boolean unchanged = false;
        // 不断的
        while (unchanged != true) {

            unchanged = true;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {

                    if (m[i][j] != 0 && m[j][i] != 0) {
                        unchanged = false;

                        if (m[i][j] >= m[j][i]) {
                            m[i][j] -= m[j][i];
                            m[j][i] = 0;
                        }

                        else {
                            m[j][i] -= m[i][j];
                            m[i][j] = 0;
                        }
                    }

                    for (int k = 0; k < 12; k++) {

                        if (m[i][k] != 0 && m[k][j] != 0) {

                            if (m[i][k] >= m[k][j]) {

                                m[i][k] -= m[k][j];
                                m[i][j] += m[k][j];
                                m[k][j] = 0;

                            } else {
                                m[k][j] -= m[i][k];
                                m[i][j] += m[i][k];
                                m[i][k] = 0;

                            }

                            unchanged = false;
                        }
                    }
                }
            }

        }

        int res = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (m[i][j] != 0)
                    res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {

        _465Solution so = new _465Solution();
        int[][] input = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
        so.minTransfers(input);

    }
}
