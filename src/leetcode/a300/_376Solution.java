package leetcode.a300;

/**
 * 求整数序列中最长的起伏子序列
 */
public class _376Solution {

    /**
     * 容易想到的dp解法，定义len[i]为以第i个元素结尾的子数组的最长起伏子序列长度
     * 只击败了10%的元素
     * 需要记录选择第i个元素最长的起伏方向
     * 
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 1)
            return 1;

        char sts[] = new char[nums.length];
        sts[0] = '?';
        int[] len = new int[nums.length];
        len[0] = 1;
        for (int i = 1; i < nums.length; i++) {

            len[i] = 1;
            sts[i] = '?';

            for (int j = 0; j < i; j++) {

                if ((sts[j] == '+' || sts[j] == '?') && nums[j] > nums[i] &&
                        len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    sts[i] = '-';
                    continue;
                }
                if ((sts[j] == '-' || sts[j] == '?') && nums[j] < nums[i] &&
                        len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    sts[i] = '+';
                    continue;
                }

            }
        }
        int res = 1;
        for (int i : len) {
            res = Math.max(res, i);
        }
        return res;

    }

    /**
     * 其实就是求解数组里面起伏转折边的次数
     * 连续上升或者持平都可以忽略
     * 
     * @param nums
     * @return
     */
    public int wiggleMaxLength1(int[] nums) {

        int trans = 0;
        int dir = 0;
        if (nums.length == 1)
            return 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1])
                continue;

            // 注意首条边的产生dir==0的情况
            if ((dir == 1 || dir == 0) && nums[i] < nums[i - 1]) {
                dir = -1;
                trans++;
                continue;
            }
            if ((dir == -1 || dir == 0) && nums[i] > nums[i - 1]) {
                dir = 1;
                trans++;
                continue;
            }
        }

        return trans + 1;
    }

}
