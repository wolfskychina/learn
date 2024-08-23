package leetcode.a2000;

/**
 * 同1151类似，这次数组是循环数组
 * 如果1分成两段在数组的首尾，也符合要求
 */
public class _2134Solution {

    /**
     * 问题转换为1151相同的，使得1都在中间和使得0都在中间的情况中
     * 所需交换的最小次数
     * 只需要使用1151的方法，分别统计0和1的最小交换次数即可
     * {slding window}
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {

        return Math.min(minSwapsTar(nums, 1), minSwapsTar(nums, 0));
    }

    public int minSwapsTar(int[] data, int tar) {

        int countX = 0;
        for (int i : data) {
            if (i == tar)
                countX++;
        }
        if (countX == 0 || countX == 1)
            return 0;

        int maxX = 0;
        int num = 0;
        for (int i = 0; i < countX; i++) {
            if (data[i] == tar)
                num++;
        }
        maxX = Math.max(maxX, num);
        int l = 0;
        int r = countX;
        while (r < data.length) {
            if (data[l] == tar)
                num--;
            if (data[r] == tar)
                num++;
            maxX = Math.max(maxX, num);
            l++;
            r++;
        }

        return countX - maxX;
    }
}
