package leetcode.array;
/**
 * 寻找一个数组中的优势元素
 * 出现数量超过数组元素个数一半的元素
 */
public class _169Solution {
   
    /**
     * 摩尔投票算法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }
}
