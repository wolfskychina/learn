package leetcode.a600;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到有序数组中最接近x的k个元素，当两个元素到x的距离相同时，位于前端的元素优先
 */
public class _658Solution {

    /**
     * {merge}
     * {two pointers}
     * 
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int re[] = new int[arr.length];
        for (int i = 0; i < re.length; i++) {
            re[i] = arr[i] - x;
            if (re[i] < 0)
                re[i] = -re[i];
        }
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < re.length; i++) {
            if (re[i] < min) {
                min = re[i];
                idx = i;
            }
        }

        // merge procedure
        int l = idx;
        int r = idx + 1;
        for (int i = 0; i < k; i++) {

            if ((l >= 0 && r < re.length && re[l] <= re[r]) || r == re.length)
                l--;
            else
                r++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            res.add(arr[i]);
        }

        return res;

    }

    public static void main(String[] args) {

        _658Solution so = new _658Solution();
        int[] arr = { 1, 2 };
        so.findClosestElements(arr, 1, 1);
    }
}
