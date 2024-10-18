package leetcode.a1100;

/**
 * 找出数组游戏的赢家
 * 不断将第一个元素和其他的元素比较，连续赢k次的是最后的赢家
 * 
 */
public class _1535Solution {
   
    public int getWinner(int[] arr, int k) {
        int mx = arr[0];
        int win = 0;
        for (int i = 1; i < arr.length && win < k; i++) {
            if (arr[i] > mx) { 
                mx = arr[i];
                win = 0;
            }
            win++; 
        }
        return mx;
    }
}
