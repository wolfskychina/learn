package leetcode.a1600;

/**
 * 使字符串平衡的最少删除次数
 * 最少删除多少个字符使得字符串变成a全部在b的前面
 */
public class _1653Solution {

    /**
     * 经典lis最长上升子序列问题
     * {LIS},{dp}
     * 
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {

        char[] ss = s.toCharArray();
        int dp0 = 0;
        int dp1 = 0;
        for (char c : ss) {

            if (c == 'a') {

                dp0++;
            } else {
                dp1 = Math.max(dp0, dp1) + 1;
            }

        }

        return ss.length - Math.max(dp0, dp1);
    }
}
