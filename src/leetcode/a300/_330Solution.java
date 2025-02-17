package leetcode.a300;

/**
 * 给定一个数组，求至少往数组中补充多少个数，
 * 能使得数组中的所有数字自由组合形成的和，
 * 能够覆盖1-n之间的所有数字
 * 同2952题 {greedy},{construction},{classic}
 * TODO 注意中间计算结果可能溢出
 */
public class _330Solution {

    /**
     * 想象成为砝码称重问题
     * 
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        // x-1是目前能够覆盖到的最大的数
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) { // 能连续覆盖的重量还没到n，有两种情况：断码(缺砝码)，或者还有砝码没加
            if (index < length && nums[index] <= x) {
                x += nums[index++];
                // 上面判断语句可能不好理解，若现有砝码1, 4, 6, n为10，当一次循环后砝码1已计入x,x=2，但是nums[1]=4>2;
                // 这说明断码了，我们需要的是重量为x=2的砝码，所以加一个，现在能称的重量就能覆盖到原来的2倍=4了（不到4）
                // 然后nums[1]=4就等于4，4的砝码我们刚好有，加进来，现在能称的重量就能覆盖到原来的2倍=8了（不到8）
                // 然后nums[2]=6<8，这个不是必需的砝码，加进来，现在能称的重量就能覆盖到8+6=14了（不到14）
            } else {
                x *= 2; // 加一个现在刚好覆盖不到的重量的砝码，覆盖范围翻倍
                patches++; // 计数+1
            }
        }
        return patches;
    }

}
