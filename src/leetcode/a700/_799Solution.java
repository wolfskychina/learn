package leetcode.a700;
/**
 * 香槟塔，当往一个香槟塔里面倒N杯酒之后
 * 第i行第j列的杯子里有多少酒
 */
public class _799Solution {
   
    /**
     * 统计所有流经某个杯子的酒的总数，最多只有1杯被留下来
     * {dp}
     * @param poured
     * @param query_row
     * @param query_glass
     * @return
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
