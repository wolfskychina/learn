package leetcode.a300;

/**
 *
 * 数组各元素除自己之外的乘积
 * 首尾两次相乘，避免乘自己
 * 或者全乘起来除以元素自己，注意元素为0的情况
 */
public class _238Solution {

    public int[] productExceptSelf(int[] nums) {
        int [] out = new int[nums.length];
        int n = nums.length;
        out[0] = 1;
        for(int i =1;i<n;i++){
            out[i] = out[i-1]*nums[i-1];
        }
        int rightM =1;
        for(int j = n -1;j>=0;j--){
            out[j] = out[j] * rightM;
            rightM = rightM * nums[j];
        }
        return out;
    }

}
