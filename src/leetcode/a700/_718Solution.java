package leetcode.a700;
/**
 * 两个数组中最长相同子数组的长度
 */
public class _718Solution {
   
    /**
     * {dp}
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {

        int m=nums1.length;
        int n=nums2.length;
        int [][] dp = new int [m+1][n+1];

        int res =0;
        // 注意让i和j从1开始，表示第i个数结尾，避免处理0
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }else{
                    dp[i][j] =0;
                }
            }
        }

    return res;
        

    }

    public static void main(String[] args){

        _718Solution so = new _718Solution();
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        so.findLength(nums1, nums2);
    }
}
