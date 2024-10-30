package leetcode.a1600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 一个偶数位的数字字符串，允许两种操作
 * 1.奇数位上的数字全部加a，超出9之后保留个位数
 * 2.字符串向右移动b位，队尾填充到头部
 * 问任意执行以上操作所形成的字符串中，字符顺序最小的字符串
 * {string}
 */
public class _1625Solution {

    /**
     * 容易被误导为某种贪心规则,实际上需要对解空间搜索
     * 细节很容易出错
     * {bfs}
     * @param s
     * @param a
     * @param b
     * @return
     */
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        char[] ss = s.toCharArray();

        Queue<char[]> q = new ArrayDeque<>();
        set.add(new String(ss));
        q.offer(ss);
        while (!q.isEmpty()) {

            char[] cur = q.poll();
            char[] next1 = increase(cur, a);
            char[] next2 = shift(cur, b);
            String n1 = new String(next1);
            String n2 = new String(next2);
            if (!set.contains(n1)) {
                set.add(n1);
                q.offer(next1);
            }
            if (!set.contains(n2)) {
                set.add(n2);
                q.offer(next2);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (o1,o2)->o1.compareTo(o2));
        return new String(list.get(0));
    }

    private char[] increase(char[] s, int a) {
        char[] res = Arrays.copyOf(s,s.length);
        for (int i = 1; i < s.length; i += 2) {
            res[i] = (char) ('0'+ (s[i] - '0' + a) % 10);
        }
        return res;
    }

    private char[] shift(char[] s, int b) {
        char[] res = new char[s.length];
        for (int i = 0; i < res.length; i++) {
            res[(i+b)%s.length] = s[i];
        }
        return res;
    }

    public static void main(String[] args) {
        _1625Solution so = new _1625Solution();
        so.findLexSmallestString("5525", 9, 2);
    }
}
