package leetcode.a2000;

/**
 * 将s修改为字典序最小的回文串
 * 只能执行最少的修改操作
 * {easy}
 */
public class _2697Solution {

    public String makeSmallestPalindrome(String s) {

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[arr.length - 1 - i])
                continue;
            if (arr[i] < arr[arr.length - 1 - i]) {
                arr[arr.length - 1 - i] = arr[i];
            } else {
                arr[i] = arr[arr.length - 1 - i];
            }
        }

        return new String(arr);
    }
}
