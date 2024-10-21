package leetcode.a2000;

/**
 * 若干操作后所能得到的最大异或和
 * 一次操作是指任意选一个非负整数，然后 nums[i] AND (nums[i] XOR x)
 */
public class _2317Solution {

    public int maximumXOR(int[] nums) {
        var ans = 0;
        for (var num : nums)
            ans |= num;
        return ans;
    }
    /**
     * 提示 1
     * nums[i] 逐位异或任意非负整数，相当于把 nums[i] 修改为任意非负整数。
     * 
     * 提示 2
     * nums[i] 逐位与任意非负整数，相当于把 nums[i] 的某些比特位的值，由 1 修改为 0，但是不能由 0 修改为 1。
     * 
     * 提示 3
     * 考虑逐位构造出 nums 的最大逐位异或和。如果 nums 在某个比特位上有奇数个 1，那么这个比特位异或和的结果就是 1。根据提示 2，只需要保证
     * nums 在这个比特位上有至少一个 1 即可，在这个比特位上我们可以只保留一个 1，其余修改为 0。
     * 
     * 提示 4
     * 通过逐位或运算可以求出 nums 在哪些比特位上有 1。
     * 
     */
}
