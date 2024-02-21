package leetcode.a800;
/**
 * 统计数组中相等且索引之积可以被k整除的数对的数量
 * {easy}
 */
public class _2176Solution {
   
      public int countPairs(int[] nums, int k) {

        int count=0;
        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                if(nums[i]==nums[j]&&(i*j)%k==0)
                    count++;
            }
        }

        return count;
    }
}
