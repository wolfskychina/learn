package leetcode.a700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 将字符串分成子串的组合，问最多能划分成多少子串，使得一个子串里面的字母不会存在于别的子串中
 */
public class _763Solution {

    /**
     * 模拟划分，使用队列保存需要扫描的字符，不断的扩展已有字符的最右侧的边界
     * {queue}
     * 
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {

        char[] str = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(1);
            return res;
        }

        int start = 0;

        while (start < str.length) {

            int max = start;

            Queue<Character> queue = new LinkedList<>();
            queue.add(str[start]);
            Set<Character> set = new HashSet<>();
            set.add(str[start]);

            while (!queue.isEmpty()) {

                char c = queue.poll();
                int l = s.length() - 1;
                for (; l > max; l--) {
                    if (str[l] == c)
                        break;
                }
                if (l > max) {
                    // 已知的字符再原字符串中的最右侧位置超出了之前搜索到的边界
                    // 边界扩大，上一轮边界和当前轮边界之间的字符如果之前set中没有，需要
                    // 添加到搜索队列中
                    for (int j = max + 1; j < l; j++) {
                        if (!set.contains(str[j])) {
                            set.add(str[j]);
                            queue.offer(str[j]);
                        }
                    }

                    max = l;

                } // l<=max 边界不增加，也没有新的未搜索字符

            }
            // q每空一次，说明一段符合条件的字段搜索完成
            // max 现在是右边界，下一轮start从max+1开始
            res.add(max - start + 1);
            start = max + 1;
        }

        return res;

    }

    /**
     * {greedy}记录每个字符出现的最右位置
     * 只需要两趟扫描即可获得所有区间
     * @param S
     * @return
     */
    public List<Integer> partitionLabels1(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i; // 每个字母最后出现的下标
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s[i] - 'a']); // 更新当前区间右端点的最大值
            if (end == i) { // 当前区间合并完毕
                ans.add(end - start + 1); // 区间长度加入答案
                start = i + 1; // 下一个区间的左端点
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _763Solution so = new _763Solution();
        so.partitionLabels("ababcbacadefegdehijhklij");
    }
}
