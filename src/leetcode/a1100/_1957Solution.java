package leetcode.a1100;

/**
 * 删除长度超过3的相同字符组成的子串
 * {easy}
 */
public class _1957Solution {

    public String makeFancyString(String s) {

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        while (r < arr.length) {

            while (r < arr.length && arr[l] == arr[r]) {
                r++;
            }
            for (int i = 0; i < Math.min(2, r - l); i++) {
                sb.append(arr[l]);
            }
            l = r;
        }
        return sb.toString();
    }
}
