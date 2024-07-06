package leetcode.a700;

/**
 * 求数组中乘积小于k的子数组的数量
 */
public class _713Soluton {

    /**
     * {two pointers},{greedy},{sliding window}
     * 因为乘积太大了，所以无法使用前缀乘积
     * 设opt为以j位置为结尾的满足乘积小于k的最左侧的坐标
     * 根据乘积的性质，opt[j+1]一定>=opt[j],从而实现opt的向右滑动
     * 只需要遍历j即可,时间复杂度为on,opt的大小也是从左向右，最多on次
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int[] opt = new int[nums.length];
        int pro = 0;
        if (nums[0] < k) {
            opt[0] = 0;
            pro = nums[0];
        } else {
            opt[0] = 1;
            pro = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int j = opt[i - 1];
            while (j < i && pro * nums[i] >= k) {
                pro = pro / nums[j];
                j++;
            }
            if (j < i) {
                opt[i] = j;
                pro *= nums[i];
            } else if (j == i) {
                if (nums[i] < k) {
                    opt[i] = i;
                    pro = nums[i];
                } else {
                    opt[i] = i + 1;
                    pro = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < opt.length; i++) {
            res += i - opt[i] + 1;
        }
        return res;
    }

    /**
     * 经过观察，对于nums的每个结尾元素的遍历中，上一轮最左侧的j的位置，只在当前轮计算时有用
     * 下一轮就被更新为本轮中的最左侧的i值
     * 所以不需要保存j的数组，而是每轮计算完之后直接计算以i坐标元素结尾的最长子数组的长度即可
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {

        int opt = 0;
        int pro = 0;
        int res =0;
        if (nums[0] < k) {
            opt = 0;
            pro = nums[0];
            res+=1;
        } else {
            opt= 1;
            pro = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int j = opt;
            while (j < i && pro * nums[i] >= k) {
                pro = pro / nums[j];
                j++;
            }
            if (j < i) {
                opt = j;
                pro *= nums[i];
            
            } else if (j == i) {
                if (nums[i] < k) {
                    opt = i;
                    pro = nums[i];
                } else {
                    opt = i + 1;
                    pro = 1;
                }
            }

            res += i-opt+1;
        }
        
        return res;
    }

    /**
     * 另外一种简洁的写法
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        _713Soluton so = new _713Soluton();
        int[] nums = { 1,1,1 };
        so.numSubarrayProductLessThanK(nums, 1);
    }
}
