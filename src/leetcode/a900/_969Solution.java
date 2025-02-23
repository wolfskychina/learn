package leetcode.a900;

import java.util.ArrayList;
import java.util.List;

/**
 * 煎饼排序
 * 对一个数组，每次只能让前i个数字反转
 * 返回一个反转顺序，使得操作之后数组变得有序
 * {classic},{greedy},{sort}
 */
public class _969Solution {

    /**
     * 可以每次通过一对反转使得当前数组中最大数放到最后面
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, n - 1);
            ret.add(index + 1);
            ret.add(n);
        }
        return ret;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
