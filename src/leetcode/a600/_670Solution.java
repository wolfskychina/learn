package leetcode.a600;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个整数，最多交换两个数位上的值，能够得到的最大值
 */
public class _670Solution {

    /**
     * {greedy},{reverse pair}
     * 
     * @param num
     * @return
     */
    public int maximumSwap(int num) {

        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        int max = 0;
        int i = list.size() - 1;
        int j = i - 1;
        boolean found = false;
        // 从左往右找第一个不在原位上的最大值，如果有最大值有多个，找最右边的那个
        for (i = list.size() - 1; i >= 0; i--) {

            max = i;
            for (j = i - 1; j >= 0; j--) {
                // 如果最大值不在原位上且有多个，要最右边的那个
                if ((max == i && list.get(max) < list.get(j)) || (max != i && list.get(max) <= list.get(j))) {
                    max = j;
                }
            }
            if (max != i) {
                found = true;
                break;
            }

        }

        if (found) {
            int tmp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, tmp);

        }

        int res = 0;
        for (int k = list.size() - 1; k >= 0; k--) {

            res = res * 10 + list.get(k);

        }

        return res;

    }

    /**
     * 从右到左找能交换的最大值
     * 从左到右找最左边能够和最大值交换的值
     * 但是可以通过一趟从右往左的遍历找到
     * @param num
     * @return
     */
    public int maximumSwap1(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int maxIdx = s.length - 1;
        int p = -1, q = 0;
        for (int i = s.length - 2; i >= 0; i--) {
            // 等于的时候不改变，相等的最大数需要保留最右侧的
            if (s[i] > s[maxIdx]) { // s[i] 是目前最大数字
                maxIdx = i;
            } else if (s[i] < s[maxIdx]) { // s[i] 右边有比它大的
                p = i;
                q = maxIdx; // 更新 p 和 q
            }
        }
        if (p == -1) { // 这意味着 s 是降序的
            return num;
        }
        char temp = s[p];
        s[p] = s[q];
        s[q] = temp; // 交换 s[p] 和 s[q]
        return Integer.parseInt(new String(s));

    }
}
