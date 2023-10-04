package leetcode.a300;
/**
 * 将一个数组里元素的顺序打乱
 * 确保每一个元素的位置都是等概率随机的
 */
public class _384Solution {
   
    int [] num;
    int [] idx;

    public _384Solution(int[] nums) {
        this.num =new int[nums.length];
        this.idx = new int[nums.length];
        for(int i=0;i<num.length;i++){
            num[i] = nums[i];
            idx[i] =i;
        }

    }
    
    public int[] reset() {

        return num;

    }
    
    public int[] shuffle() {

        for(int i=0;i<idx.length;i++){

            int ch = (int)(Math.random()*idx.length);
            int tmp;
            tmp = idx[i];
            idx[i] = idx[ch];
            idx[ch] = tmp;
        }

        int res [] = new int[idx.length];
        for(int i=0;i<res.length;i++){
            res[i] = num[idx[i]];
        }

        return res;

    }
}
