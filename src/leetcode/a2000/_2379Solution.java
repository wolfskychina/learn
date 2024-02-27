package leetcode.a2000;
/**
 * 得到k个连续黑块所需要的最少涂色次数
 * {easy}
 */
public class _2379Solution {

    public int minimumRecolors(String blocks, int k) {

        int left = 0;
        int right = 0;
        int numOfB = 0;
        int maxB = 0;
        char arr[] = blocks.toCharArray();
        for (int i = 0; i < k; i++) {
            if (arr[right++] == 'B') {
                numOfB++;
            }
        }
        maxB = numOfB;
        while (right < arr.length) {

            if (arr[left] == 'B')
                numOfB--;
            if (arr[right] == 'B')
                numOfB++;
            left++;
            right++;
            maxB = Math.max(maxB, numOfB);
        }

        return k - maxB;
    }

    public static void main(String[] args){

        _2379Solution so = new _2379Solution();
        String str = "WBBWWBBWBW";
        so.minimumRecolors(str, 7);
    }
}
