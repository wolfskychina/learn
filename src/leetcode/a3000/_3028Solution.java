package leetcode.a3000;

/**
 * 边界上的蚂蚁
 * {easy}
 */
public class _3028Solution {

    public int returnToBoundaryCount(int[] nums) {

        int pos = 0;
        int count = 0;
        for (int i : nums) {
            pos += i;
            if (pos == 0)
                count++;
        }
        return count;
    }
}
