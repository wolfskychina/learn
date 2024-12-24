package leetcode.a2000;

/**
 * 含最多k个可整除元素的不同子数组的个数
 * 不同子数组不只是索引位置不同，组成元素大小不能相同
 */
public class _2261Solution {

    /**
     * 前缀和的解法
     * 错误的解法，相同的子数组但是不同位置会被重复计算
     * 
     * @param nums
     * @param k
     * @param p
     * @return
     */
    public int countDistinct(int[] nums, int k, int p) {
        int count[] = new int[nums.length + 1];
        int res = 0;

        for (int i = 1; i < count.length; i++) {

            count[i] += nums[i - 1] % p == 0 ? 1 : 0;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = i + 1; j < count.length; j++) {
                if (count[j] - count[i] <= k)
                    res++;
            }
        }
        return res;

    }

    int ans = 0;

    class Trie {
        Trie[] children = new Trie[201];
    }

    public boolean insert(int target, Trie node) {
        if (node.children[target] == null) {
            node.children[target] = new Trie();
            return true;
        } else {
            return false;
        }
    }

    Trie root = new Trie();

    /**
     * 使用Trie树来去重
     * 
     * @param nums
     * @param k
     * @param p
     * @return
     */
    public int countDistinct1(int[] nums, int k, int p) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = 0;

            Trie r = root;
            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) {
                    temp++;
                }
                // 超出长度就不能遍历了
                if (temp > k) {
                    break;
                }

                // 能插入说明发现一个新独特的子数组
                if (insert(nums[j], r)) {
                    res++;
                }
                
                // 不能插入说明之前已经有相同的子数组，非独特
                // 但是需要继续走循环
                r = r.children[nums[j]]; 

            }
        }
        return res;
    }

}
