package leetcode.a600;
/**
 * 统计二进制字符串中，0和1次数相同且0和1聚集出现的子串的个数
 */
public class _696Solution {

    /**
     * {two pointers}
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {

        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                continue;
            res++;
            int ii = i - 1;
            int j = i + 2;
            while (ii >= 0 && j < arr.length && arr[ii] == arr[ii + 1] && arr[j] == arr[j - 1]) {
                res++;
                ii--;
                j++;
            }

        }

        return res;
    }
}
