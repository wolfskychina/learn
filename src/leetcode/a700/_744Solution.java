package leetcode.a700;
/**
 * 排好序的字符数组中，寻找比目标字母大的最小字母
 */
public class _744Solution {

    /**
     * {binary search}
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0;
        int r = letters.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (l < letters.length && letters[l] > target)
            return letters[l];
        else
            return letters[0];

    }
}
