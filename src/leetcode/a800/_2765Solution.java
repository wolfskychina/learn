package leetcode.a800;
/**
 * 最长交替子数组
 * {easy}
 */
public class _2765Solution {
   
    /**
     * 成对考虑，需要注意边界条件，当长度为偶数的时候
     * @param nums
     * @return
     */
    public int alternatingSubarray(int[] nums) {
        int l1 =0;
        int l2 =1;
        int max=0;
        while(l2<nums.length){
            while(l2<nums.length&&nums[l1]!=nums[l2]-1){
                l1++;
                l2++;
            }
            if(l2==nums.length) break;
            int tmp =2;
            int ll1 = l1+2;
            int ll2 = l2+2;
            // 这个地方需要考虑边界条件
            while(ll1<nums.length){
                if(ll2<nums.length&&nums[ll1]==nums[ll1-2]&&
                nums[ll2]==nums[ll2-2]){
                    ll1+=2;
                    ll2+=2;
                    tmp+=2;
                }else if(nums[ll1]==nums[ll1-2]){
                    tmp++;
                    break;
                }else{
                    break;
                }
            }
            max = Math.max(max, tmp);
            l1++;
            l2 = l1+1;

        }
        return max==0?-1:max;

    }

    public int alternatingSubarray1(int[] nums) {
        int ans = -1;
        int i = 0, n = nums.length;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                i++; // 直接跳过
                continue;
            }
            int i0 = i; // 记录这一组的开始位置
            i += 2; // i 和 i+1 已经满足要求，从 i+2 开始判断
            while (i < n && nums[i] == nums[i - 2]) {
                i++;
            }
            // 从 i0 到 i-1 是满足题目要求的（并且无法再延长的）子数组
            ans = Math.max(ans, i - i0);
            i--;
        }
        return ans;
    }
}
