package leetcode.a100;
/**
 * 找一个无序数组中，按顺序排列后两个相邻数字相差的最大值
 */
public class _164Solution {
    /**
     * 要求on的时间复杂度，不能用比较排序
     * 只能用计数排序
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        // 首先需要知道数组中，最高位的数字有多少位
        int n = 0;

        int tmp = 0;
        int count =0;
        for(int num:nums){

            count =0;
            tmp = num;
            while(tmp!=0){

                tmp /= 10;
                count ++;
            }

            if(count >n) n = count;

        }

        int m =1;
        int [] c = new int[10];
        int[] b = new int[nums.length];

        for(int k=0;k<n;k++){

            for(int i=0;i<10;i++){
                c[i]=0;
            }

            for(int i=0;i<nums.length;i++){

                c[nums[i]/m%10] ++;
            }

            for(int i=1;i<10;i++){

                c[i] += c[i-1];
            }

            for(int i=nums.length-1;i>=0;i--){

                b[c[nums[i]/m%10]-1] = nums[i];
                c[nums[i]/m%10]--;
            }

            for(int i=0;i<nums.length;i++){
                nums[i] =b[i];
                b[i]=0;
            }

            m *=10;
        }

        n=0;
        for(int i=1;i<nums.length;i++){

            if(nums[i]-nums[i-1]>n) n = nums[i]-nums[i-1];
        }

        return n;

    }


    public static void main(String [] args){

        _164Solution so = new _164Solution();
        int [] nums = {10,8};
        System.out.print(so.maximumGap(nums));
    }
}
