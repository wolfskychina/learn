package leetcode.a1700;
/**
 * 生成交替字符串所需要的最少改变的次数
 */
public class _1758Solution {

    public int minOperations(String s) {

        char[] arr = s.toCharArray();
        int odd0 = 0;
        int odd1 = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] == '0')
                odd0++;
            else
                odd1++;
        }
        int even0 = 0, even1 = 0;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] == '0')
                even0++;
            else
                even1++;
        }
        return Math.min(even0 + odd1, even1 + odd0);
    }
}
