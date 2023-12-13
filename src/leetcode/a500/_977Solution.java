package leetcode.a500;
/**
 * 有序数组的平方
 * 初始数组按照非递减排序
 * 将数组中的每个元素做平方，然后将结果按照非递减排序
 */
public class _977Solution {
   
    /**
     * 模拟归并{easy}
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {

        int i=0;
        while(i<nums.length && nums[i]<0){
            i++;
        }
        int l =i-1;
        int res[] = new int[nums.length];
        int k=0;
        while(l>=0&&i<nums.length){
            if(-nums[l]<nums[i]){
                res[k++] = nums[l]*nums[l];
                l--;
            }else{
                res[k++]= nums[i]*nums[i];
                i++;
            }
        }
        while(l>=0){
            res[k++] = nums[l]*nums[l];
            l--;
        }
        while(i<nums.length){
            res[k++] = nums[i]*nums[i];
            i++;
        }

        return res;
    }
}
