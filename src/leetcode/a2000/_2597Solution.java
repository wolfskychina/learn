package leetcode.a2000;

/**
 * 美丽子集的数目
 * 子集里面的所有数字的差的绝对值都不等于k，这种子集叫美丽子集
 * 求数组美丽子集的数量
 * {backtrack},{counting}
 */
public class _2597Solution {

    private int[] nums;
    private int[] cnt = new int[1001];
    private int ans = -1;
    private int k;

    /**
     * 也是一种counting，不过只需要维持当前已经选中数的累计数量即可
     * @param nums
     * @param k
     * @return
     */
    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ++ans;
            return;
        }
        dfs(i + 1);
        boolean ok1 = nums[i] + k >= cnt.length || cnt[nums[i] + k] == 0;
        boolean ok2 = nums[i] - k < 0 || cnt[nums[i] - k] == 0;
        if (ok1 && ok2) {
            ++cnt[nums[i]];
            dfs(i + 1);
            --cnt[nums[i]];
        }
    }
}
