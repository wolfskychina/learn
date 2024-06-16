package leetcode.a400;
/**
 * 数组中最多的连续的1的个数
 * 考察边界条件
 * {easy}
 */
public class _485Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int i = 0;
        int count = 0;
        int res = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
            i++;
        }
        // TODO可能出现最后没有0全是1的情况
        res = Math.max(res,count);
        return res;

    }

    public static void main(String[] args){
        _485Solution so = new _485Solution();
        int [] array = {1,1,0,1,1,1};
        so.findMaxConsecutiveOnes(array);

    }
}
