package leetcode.a700;
/**
 * 删除得分游戏，选取数组中大小为i的值，那么能够得到所有个数*i的分数，同时会
 * 删除所有i-1和i+1的元素（如果有的话），问选取的方案中，得分最高是多少？
 */
public class _740Solution {
   
    int[] cnts = new int[10010];

    /**
     * {dp} dp[i][0]为大小为i的元素不选取的情况下，能够得到的最大值，
     * 1为选取的情况下获得的最大值
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums) {
            cnts[x]++;
            max = Math.max(max, x);
        }
        // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
        int[][] f = new int[max + 1][2]; 
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * cnts[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }

    /**
     * 将dp压缩为一维
     * @param nums
     * @return
     */
    public int deleteAndEarn1(int[] nums) {
        int max = 0;
        for (int x : nums) {
            cnts[x]++;
            max = Math.max(max, x);
        }
        // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
        int[] f = new int[2]; 
        for (int i = 1; i <= max; i++) {
            int f0 = f[0];
            int f1 = f[1];
            f[1] = f0 + i * cnts[i];
            f[0] = Math.max(f1, f0);
        }
        return Math.max(f[0], f[1]);
    }


}
