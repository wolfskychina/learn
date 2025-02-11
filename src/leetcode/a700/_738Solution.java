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
        // 除非本身就是符合条件的，否则必定是某一位-1然后
        for (int i = 0; i < arr.length - 1; i++) {
            // 左侧当前的最大值
            // 如果有多个相等的最大值，保存最左侧的
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            // 看有没有相邻的逆序对，只要有，那么就可以高位-1
            // 低位全部变9
            // 相邻逆序对的位置和大小都不重要
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
