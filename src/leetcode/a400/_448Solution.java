package leetcode.a400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _448Solution {
  
    /**
     * 将元素归位
     * 性能不是很好
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // nums in 1...len-1
        for(int i=0;i<nums.length;i++){

            if(nums[i] == i+1){
                continue;
            }
            while(nums[i] != i+1 && nums[nums[i]-1]!=nums[i]){
                // 注意这里交换元素
                int tmp =nums[i];
                nums[i] =nums[nums[i]-1];
                // 不能直接用nums[nums[i]-1]，因为nums[i]值已经变了 
                nums[tmp-1] = tmp; 

            }

        }
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }

        return res;
    }

    /**
     * 非常巧妙的利用nums[i]原来的数值来存储i+1出现的次数
     * 因为取值为1-n,所以只要发现一个x大小的数，就给（x-1）%n的位置加上n
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            // 只要大于n，说明该数值出现过
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args){

        _448Solution so = new _448Solution();
        int[] array = {4,3,2,7,8,2,3,1};
        so.findDisappearedNumbers(array);
    }
}
