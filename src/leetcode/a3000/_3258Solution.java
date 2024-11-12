package leetcode.a3000;

/**
 * 满足k约束的子字符串的数量
 * k约束是指字符串中0的个数或者1的个数不超过k个
 * {sliding window}
 */
public class _3258Solution {

    /**
     * 遍历规则
     * 每次向右滑动一个位置，统计以当前r节点为右侧边界的满足k约束的子串的数量
     * @param S
     * @param k
     * @return
     */
    public int countKConstraintSubstrings(String S, int k) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < s.length; i++) {
            cnt[s[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
