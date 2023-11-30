package leetcode.a700;
/**
 * 小于n的满足逐位非递减整数的最大值
 */
public class _738Solution {
   
    /**
     * {greedy}
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] arr = (N + "").toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for(int j = idx + 1;j < arr.length;j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

}
