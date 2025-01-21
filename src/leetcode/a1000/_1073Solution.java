package leetcode.a1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO 负二进制数加法
 * 比较抽象，用-1来表示欠一个该数位的大小
 * {math},{bit manuplation}
 */
public class _1073Solution {

    public int[] addNegabinary(int[] arr1, int[] arr2) {

        int i = arr1.length - 1, j = arr2.length - 1;
        List<Integer> ans = new ArrayList<>();
        for (int c = 0; i >= 0 || j >= 0 || c != 0; --i, --j) {
            int a = i < 0 ? 0 : arr1[i];
            int b = j < 0 ? 0 : arr2[j];
            int x = a + b + c;
            c = 0;
            // 负进位其实就是下一个不产生进位而是欠一个
            // 等到下下位再进行处理
            if (x >= 2) {
                x -= 2;
                c = -1;
            } else if (x == -1) {
                x = 1;
                c = 1;
            }
            ans.add(x);
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
