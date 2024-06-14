package leetcode.a400;

/**
 * 根据一组转账关系，求如果不按照该关系进行转账
 * 最少能通过多少次转账使得最终的账务和原转账之后相同
 */
public class _465Solution {

    /**
     * 没有考虑有多棵树的情况
     * 例如，可以优化为1,2,3之间转账之后账平、4,5之间转账账平
     * 但是实际上4，5之间原来没有资金往来
     * 
     * @param transactions
     * @return
     */
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

    /**
     * 只要节点的任意子集组合中，所有的子集内部的转账关系最后都平账
     * 那么总的结果也是平账, 那么这种子集的划分法就构成一类的解
     * 所以需要遍历所有的这些子集的组合，寻找能够全部平账的子集组合中边最少的
     * 而第一个解法无法求解出多于一个非单元素集合的情况，无法指向没有债务关系的对手
     * @param args
     */
    public int minTransfers2(int[][] transactions) {
        final int n = 12;
        int[] cnt = new int[n];
        for (int[] d : transactions) {
            cnt[d[0]] -= d[2];
            cnt[d[1]] += d[2];
        }
        // 一个集合中对于每个节点都可以选择是否加入
        // 那么集合中可能的节点组合有2的n次方种
        final int m = 1 << n;

        // f是所有解空间
        int[] f = new int[m];
        for (int i = 1; i < m; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j)
                // 从右往左第j位的节点是否在群中
                if ((i >> j & 1) > 0)
                    sum += cnt[j];
            // 看该群内部是否能够平账，如果不能就不是候选值
            if (sum != 0)
                // 编码i表示的组合方式不能平账，无效
                f[i] = Integer.MAX_VALUE / 2; // 防止溢出
            else {
                // f[i]最大转账次数也不超过边数-1
                f[i] = Integer.bitCount(i) - 1;
                // 遍历子群, 每次找到一个新子群比较重要
                // TODO  j = (j-1)&i 不断执行这个操作，能够得到i中所有
                // 等于1的位的组合方式的数字
                for (int j = (i - 1) & i; j > 0; j = (j - 1) & i)
                    f[i] = Math.min(f[i], f[j] + f[i ^ j]);
            }
        }
        // f[m-1]， m-1表示的元素组合是全部的人都在集合中
        return f[m - 1];
    }

    public static void main(String[] args) {

        _465Solution so = new _465Solution();
        int[][] input = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
        so.minTransfers(input);

    }
}
