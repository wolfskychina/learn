package leetcode.a800;

import java.util.Arrays;

/**
 * 有序队列
 * 每次可以从字符串的前k个字符中选一个移动至队尾，允许无限次操作
 * 问能够获得的字符串序最小的字符串
 * {sorting}
 */
public class _899Solution {

    /**
     * 考察对基于比较的排序的本质的理解
     * 只要允许2个级以上都能保证能够排序
     * 只要前两个就能冒泡排序
     * 
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {

        if (k == 1) {
            String min = s;
            for (int i = 1; i < s.length(); i++) {
                String str = s.substring(i) + s.substring(0, i);
                if (min.compareTo(str) > 0) {
                    min = str;
                }
            }
            return min;
        }

        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        return new String(ss);

    }
}
