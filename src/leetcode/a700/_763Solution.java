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
            // max 现在是右边界，下一轮start从max+1开始
            res.add(max - start + 1);
            start = max + 1;
        }

        return res;

    }

    public static void main(String[] args){
        _763Solution so = new _763Solution();
        so.partitionLabels("ababcbacadefegdehijhklij");
    }
}
