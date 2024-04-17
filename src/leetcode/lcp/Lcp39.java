package leetcode.lcp;
/**
 * 无人机方阵
 * {counting}
 */
public class Lcp39 {
   
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int res = 0;
        int[] array =  new int[10001];
        

        for (int[] arr : source) {
            for (int i = 0; i < arr.length; i++) {
                array[arr[i]]++;
            }
        }

        for (int[] arr : target) {
            for (int i = 0; i < arr.length; i++) {
                array[arr[i]]--;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                res -= array[i];
            }
        }
        return res;
    }
}
