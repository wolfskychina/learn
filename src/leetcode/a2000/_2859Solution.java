package leetcode.a2000;

import java.util.List;
/**
 * 索引中1的数量为k的数字的和
 * {easy}
 */
public class _2859Solution {
   
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int sum =0;
        for(int i=0;i<nums.size();i++){

            // 内置函数更快
            if(Integer.bitCount(i)==k){
                sum+=nums.get(i);
            }           
            
        }
        return sum;
    }

    private int numOfOne(int i){

        int res=0;
        while(i!=0){
            res+=i%2;
            i>>=1;
        }
        return res;
    }
}
