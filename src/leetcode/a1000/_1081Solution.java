package leetcode.a1000;

/**
 * 包含字符串中所有不同字符的字符顺序最小的子序列
 * {monotonic stack}
 * 
 */
public class _1081Solution {

    /**
     * 考察基于比较的排序的本质，字符两两之间的大小顺序
     * @param s
     * @return
     */
    public String smallestSubsequence(String s) {

        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        // sb同时充当单调栈的作用
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // vis[]标记一个字符是否在单调栈sb中
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    // num[]>0说明后续还有相同字符可以遍历
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        // 删掉这个之前的字符，后来需要后还要进行判断
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            // 如果当前字符已经在单调栈中出现过，那么什么都不做直接跳过
            // 这个操作没有考虑清楚为什么没有问题
            // 记录还没遍历到的各个字符的个数
            num[ch - 'a'] -= 1;
        }
        return sb.toString();

    }
}
