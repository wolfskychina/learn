package leetcode.a2000;
/**
 * 反转两次的数字是否和原数字相等,去掉头部的0
 * {easy}
 */
public class _2119Solution {
   
    public boolean isSameAfterReversals(int num) {

        if(num==0)  return true;
        if(num%10==0) return false;
        return true;
    }
}
