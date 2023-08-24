package leetcode.a300;

import java.util.ArrayList;
import java.util.List;
/**
 * 寻找数组中出现次数超过3分之1的数
 */
public class _229Solution {
    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0;
        int candidate2=0;
        int count1=0;
        int count2=0;
        for(int num:nums){
            if(num==candidate1){
                //匹配candidate1，投票++
                count1++;
            }else if(num==candidate2){
                //匹配candidate2，投票++
                count2++;
            }else if(count1==0){
                //不匹配且candidate1投票数为0
                candidate1=num;
                count1=1;
            }else if(count2==0){
                //不匹配且candidate2投票数为0
                candidate2=num;
                count2=1;
            }else{
                //不匹配且candidate1、2投票数均不为0
                count1--;
                count2--;
            }
        }
        List < Integer > res=new ArrayList<>();
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==candidate1){
                count1++;
            }
            if(num==candidate2){
                count2++;
            }
        }
        int length=nums.length;
        if(count1>length/3.0){
            res.add(candidate1);
        }
        if(count2>length/3.0){
            if(candidate1!=candidate2){
                res.add(candidate2);
            }
        }
        return res;
    }
}
