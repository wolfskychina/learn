package leetcode.a2000;

/**
 * 相邻值的按位异或
 * {xor},{bit manuplation}
 */
public class _2683Solution {

    public boolean doesValidArrayExist(int[] derived) {
        int xorValue = 0;
        for (int num : derived) {
            xorValue ^= num;
        }
        return xorValue == 0;
    }

    public static void main(String[] args) {

        _2683Solution so = new _2683Solution();
        int[] nums = { 0, 0, 1 };
        so.doesValidArrayExist(nums);
    }
}
