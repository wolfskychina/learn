package leetcode.a600;

import java.util.Arrays;

/**
 * 判断一个是否能够一个给定的边列表中，
 * 一共能组成多少的三角形
 */
public class _611Solution {

    /**
     * 普通的on3的解法，比较慢
     * {sorting}
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] > nums[k])
                        num++;
                    else
                        break;
                }
            }
        }

        return num;
    }

    /**
     * 优化的on3的解法，比较快
     * @param nums
     * @return
     */
    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0;i<n;i++){
           for(int j=i-1,k=0;k<j;j--){
               while(k<j&&nums[k]+nums[j]<=nums[i])k++;
               ans+=j-k;
           }
        }
    return ans;
    }
}
