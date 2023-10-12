package leetcode.a400;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * 数组中任意两个值的异或的最大值
 * TODO
 */
public class _421Solution {

    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    /**
     * 异或操作隐藏的性质，如果一个高位通过异或能够为1，那么最终最大的异或数字
     * 中，这一位一定是1。 反证，如果最终最大的异或数字该位为0，那么其他位即使全是1
     * 其和也不会超过该位是1的情况（ie, 128> 64+32+16+...)
     * 
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 30-k 个二进制位为止的部分
                // 只需将其右移 k 位
                // 初始只保留最左侧的一位
                seen.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }

    // 字典树的根节点
    Trie root = new Trie();
    // 最高位的二进制位编号为 30
    // static final int HIGH_BIT = 30;

    /**
     * 将所有nums加到二叉trie树中
     * 然后对于每一个num，逐位计算xor值并在trie树中遍历
     * xor能得到1就选择能得到1的分支继续，如果不能就选择得到0的分支
     * 每次能够得到num和数组中其余元素xor得到的最大值
     * 空间换时间
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

}

class Trie {
    // 左子树指向表示 0 的子节点
    Trie left = null;
    // 右子树指向表示 1 的子节点
    Trie right = null;
}
