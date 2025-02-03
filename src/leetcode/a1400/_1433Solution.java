package leetcode.a1400;

import java.util.Arrays;

/**
 * 检查一个字符串是否超过另一个字符串
 * 超过指两个字符串各自的某种排列，能够使得对应位置的字符全部s1[i]<=s2[i]
 * 或者全部s1[i]>=s2[i]
 */
public class _1433Solution {

    /**
     * 排序后贪心比较
     * {greedy}
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkIfCanBreak1(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean b1 = false;
        boolean b2 = false;
        for (int i = 0; i < c1.length; i++) {

            if (c1[i] > c2[i])
                b1 = true;
            else if (c1[i] < c2[i])
                b2 = true;

            if (b1 && b2)
                return false;
        }
        return true;
    }

    /**
     * 不排序，使用计数
     * {counting}
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] cnt1 = count(s1);
        int[] cnt2 = count(s2);

        int[] cnt11 = new int[26];
        int[] cnt22 = new int[26];
        System.arraycopy(cnt1, 0, cnt11, 0, 26);
        System.arraycopy(cnt2, 0, cnt22, 0, 26);
        return bigger(cnt1, cnt2) || bigger(cnt22, cnt11);
    }

    private int[] count(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        return cnt;
    }

    private boolean bigger(int[] cnt1, int[] cnt2) {
        int idx1 = 0;
        int idx2 = 0;
        for (; idx1 < cnt1.length;) {
            if (cnt1[idx1] == 0) {
                idx1++;
                continue;
            }

            // compare
            if (cnt2[idx2] == 0) {
                idx2++;
                if (idx2 > idx1) {
                    return false;
                }
            } else {
                int value = Math.min(cnt1[idx1], cnt2[idx2]);
                cnt1[idx1] -= value;
                cnt2[idx2] -= value;
            }
        }
        return true;
    }
}
