package leetcode.a1000;

/**
 * 两个长度分别为firstLen和secondLen的非重叠子数组的和的最大值
 * 
 * {prefix sum} TODO 原理简单但是细节很容易搞错
 */
public class _1031Solution {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int pre[] = new int[nums.length];
        int post[] = new int[nums.length];
        int winsum = 0;
        int i = 0;
        for (; i < secondLen; i++) {
            winsum += nums[i];
        }
        pre[i - 1] = winsum;
        while (i < nums.length) {

            winsum += nums[i] - nums[i - secondLen];
            pre[i] = Math.max(pre[i - 1], winsum);
            i++;
        }
        winsum = 0;
        i = nums.length - 1;
        for (; i >= nums.length - secondLen; i--) {

            winsum += nums[i];
        }
        post[i + 1] = winsum;
        while (i >= 0) {
            winsum += nums[i] - nums[i + secondLen];
            post[i] = Math.max(post[i + 1], winsum);
            i--;
        }

        i = 0;
        winsum = 0;
        for (; i < firstLen; i++) {
            winsum += nums[i];
        }
        int res = 0;
        while (i <= nums.length) {
            res = Math.max(res,
                    Math.max(i - firstLen - 1 >= 0 ? pre[i - firstLen - 1] : 0, i < post.length ? post[i] : 0)
                            + winsum);
            // 判断是否下一轮会产生新的窗口，有可能本轮窗口需要比较但是不会产生下一轮新窗口
            if(i<nums.length)
                winsum += nums[i] - nums[i - firstLen];
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        _1031Solution so = new _1031Solution();
        int[] nums = { 12, 8, 12, 18, 19, 10, 17, 20, 6, 8, 13, 1, 19, 11, 5 };
        so.maxSumTwoNoOverlap(nums, 3, 6);
    }
}
