package leetcode.a1700;

/**
 * 能否仅执行一次字符交换就能使两个字符串相等
 * {easy}
 */
public class _1790Solution {

    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        int count = 0;
        int idx1 = 0;
        int idx2 = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] != arr2[i]) {

                if (count == 0) {
                    idx1 = i;
                    count++;
                } else if (count == 1) {
                    idx2 = i;
                    count++;
                } else {
                    return false;
                }
            }

        }
        if (count != 2)
            return false;

        return arr1[idx1] == arr2[idx2] && arr1[idx2] == arr2[idx1];

    }
}
