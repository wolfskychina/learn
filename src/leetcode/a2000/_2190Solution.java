package leetcode.a2000;
/**
 * 紧跟key之后出现的最多的数字
 * {easy}
 */
public class _2190Solution {
   
    public int mostFrequent(int[] nums, int key) {

        int count[] = new int[1001];
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==key){
                count[nums[i+1]]++;
            }
        }
        int max =0;
        int maxidx = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
                max = count[i];
                maxidx = i;
            }
        }
        return maxidx;
    }
}
