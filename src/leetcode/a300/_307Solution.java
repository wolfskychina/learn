package leetcode.a300;
/**
 * 给定一个数组，设计一组api，能够返回
 * 数组区间[i,j]之间的元素和
 * 并且能够修改元素的值
 */
public class _307Solution {
    int[] sum ;

    public _307Solution(int[] nums) {
        sum = new int[nums.length+1];
        int k =1;
        for(int i :nums){
            sum[k] = sum[k-1]+i;
            k++;
        }
    }
    
    public void update(int index, int val) {
        int old = sum[index+1]-sum[index];
        int d = val-old;
        for(int i =index+1;i<sum.length;i++){
            sum[i] +=d;
        }

    }
    
    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];

    } 

    /**
     * 树状数组
     * 高效计算数列的前缀和， 区间和
     */
    class NumArray {
        private int[] tree;
        private int[] nums;
    
        public NumArray(int[] nums) {
            this.tree = new int[nums.length + 1];
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }
    
        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }
    
        public int sumRange(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }
    
        private int lowBit(int x) {
            return x & -x;
        }
    
        private void add(int index, int val) {
            while (index < tree.length) {
                tree[index] += val;
                index += lowBit(index);
            }
        }
    
        private int prefixSum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= lowBit(index);
            }
            return sum;
        }
    }
   
}
