package leetcode.a500;

import java.util.ArrayList;
import java.util.List;
/**
 * n的各位数字组成的下一个更大的数字，如果不存在
 * 返回-1
 */
public class _556Solutoin {

    /**
     * {digit encoding},{sequence}
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        int[] num = new int[list.size()];
        int i = num.length - 1;
        for (Integer digit : list) {
            num[i--] = digit;
        }
        int k = num.length - 1;
        while (k - 1 >= 0 && num[k - 1] >= num[k]) {
            k--;
        }
        k--;
        if (k == -1)
            return -1;
        int j = num.length - 1;
        while (num[j] <= num[k])
            j--;
        int tmp = num[k];
        num[k] = num[j];
        num[j] = tmp;
        int l = k + 1;
        int r = num.length - 1;
        while (l < r) {

            tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }

        if (num.length == 10) {
            int m = Integer.MAX_VALUE;
            int compare[] = new int[10];
            int idx = 9;
            while (m != 0) {

                compare[idx--] = m % 10;
                m = m / 10;
            }
            for (i = 0; i < 10; i++) {
                if (num[i] < compare[i])
                    break;
                if (num[i] > compare[i])
                    return -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {

        _556Solutoin so = new _556Solutoin();
        so.nextGreaterElement(2138476986);
    }

}
