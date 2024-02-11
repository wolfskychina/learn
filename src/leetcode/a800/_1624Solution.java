package leetcode.a800;

import java.util.Arrays;

/**
 * 字符串两个相同字符之间的最长字符串的长度
 * {easy}
 */
public class _1624Solution {

    /**
     * 有点复杂了
     * 
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {

        int leftidx[] = new int[26];
        int rightidx[] = new int[26];

        Arrays.fill(leftidx, Integer.MAX_VALUE);
        Arrays.fill(rightidx, Integer.MIN_VALUE);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            leftidx[arr[i] - 'a'] = Math.min(leftidx[arr[i] - 'a'], i);
            rightidx[arr[i] - 'a'] = Math.max(rightidx[arr[i] - 'a'], i);
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (leftidx[i] != Integer.MAX_VALUE && rightidx[i] != Integer.MIN_VALUE)
                max = Math.max(max, rightidx[i] - leftidx[i] - 1);
        }

        return max;
    }

    /**
     * 只需要遍历一次即可，只标记每个字符第一次出现的位置，除第一次出现之外都只和第一次进行长度比较，
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters1(String s) {
        int[] char2Index = new int[26];
        Arrays.fill(char2Index, -1);
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a', index = char2Index[idx];
            if (index != -1)
                maxLen = Math.max(maxLen, i - index - 1);
            else
                char2Index[idx] = i;
        }
        return maxLen;
    }
}
