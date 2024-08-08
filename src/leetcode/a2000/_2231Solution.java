package leetcode.a2000;

import java.util.PriorityQueue;

/**
 * 数字的奇偶相同的数字单独交换后所能得到的最大数字
 */
public class _2231Solution {

    /**
     * 基于堆
     * 
     * @param num
     * @return
     */
    public int largestInteger(int num) {
        PriorityQueue<Integer> one = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> two = new PriorityQueue<>((a, b) -> (b - a));
        char[] n = String.valueOf(num).toCharArray();
        for (char c : n) {
            int t = c - '0';
            if (t % 2 == 1) {
                one.offer(t);
            } else {
                two.offer(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : n) {
            int t = c - '0';
            if (t % 2 == 1) {
                sb.append(one.poll());
            } else {
                sb.append(two.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 奇偶独立的冒泡排序
     * 
     * @param num
     * @return
     */
    public int largestInteger1(int num) {
        String str = String.valueOf(num);
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length - 1; i++) {
            for (int j = i + 1; j < chs.length; j++) {
                if ((chs[i] - chs[j]) % 2 == 0 && chs[j] > chs[i]) {
                    char t = chs[i];
                    chs[i] = chs[j];
                    chs[j] = t;
                }
            }
        }
        int res = 0;
        for (char ch : chs) {
            res = res * 10 + ch - '0';
        }
        return res;
    }
}
