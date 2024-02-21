package leetcode.a900;
/**
 * 仅仅反转字符串中的英文字母
 * {easy}
 */
public class _917Solution {

    public String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while (i < arr.length && j >= 0 && i < j) {
            while (i < arr.length && (arr[i] < 'A' || (arr[i] > 'Z' && arr[i] < 'a') || arr[i] > 'z')) {
                i++;
            }
            while (j >= 0 && (arr[j] < 'A' || (arr[j] > 'Z' && arr[j] < 'a') || arr[j] > 'z')) {
                j--;
            }
            if (i < arr.length && j >= 0 && i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                i++;
                j--;
            }
        }

        return new String(arr);
    }
}
