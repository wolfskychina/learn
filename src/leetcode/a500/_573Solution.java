package leetcode.a500;

/**
 * 松鼠模拟，松鼠最少走多少步能够将所有坚果采集到树上
 */
public class _573Solution {

    /**
     * {manhattan distance},{matrix}
     * @param height
     * @param width
     * @param tree
     * @param squirrel
     * @param nuts
     * @return
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        // 计算所有坚果到树的曼哈顿距离Li，相加
        // 同时计算松鼠到该坚果的曼哈顿距离Si，记录(Si-Li)最小的值，保留最小值的坚果的坐标
        // 如果先采集第一个坚果，那么总距离为：S1+L1+L2*2+L3*2+...Ln*2
        // 先采集第二个坚果，的总距离为: S2+L1*2+L2+L3*2...+Ln*2
        // 先采集第i个坚果的，总距离为：Si+L1*2+L2*2+...+Li+...Ln*2
        // 将所有的距离减去L1*2+L2*2+...+Ln*2 不影响距离的大小
        // 则总距离分别为：S1-L1, S2-L2...Si-Li,所以只要求Si-Li即可
        int disNuts = 0;
        int min = Integer.MAX_VALUE;
        int[] minNut = new int[2];
        for (int i = 0; i < nuts.length; i++) {

            int tmp1 = computeDis(nuts[i], tree);
            disNuts += tmp1;
            int tmp2 = computeDis(nuts[i], squirrel);
            if (tmp2 - tmp1 < min) {
                min = tmp2 - tmp1;
                minNut = nuts[i];
            }

        }
        // 所有见过到树的距离的和*2-记录坚果到树的距离+松鼠到坚果的距离，即最小距离
        return disNuts * 2 - computeDis(minNut, tree) + computeDis(minNut, squirrel);

    }

    private int computeDis(int[] a, int[] b) {

        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
