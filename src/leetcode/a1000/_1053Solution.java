package leetcode.a1000;

/**
 * 将数组中的一对元素交换位置，使得新的数组的排列是
 * 小于原数组顺序的最大值
 * {greedy},{hard},{classic}
 * 
 * 例子 1,9,4,6,7 交换7和9
 * 1 9 3 2 7  交换2和3
 * 1 9 3 1 2 7 交换3和2
 */
public class _1053Solution {

    /**
     * 这个题虽然是贪心，但是隐含了很多等价转换原则
     * @param arr
     * @return
     */
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int left = -1, right = 0;

        // 左边的值能不变就不变
        // 所以从右往左找，第一个能够交换的值就是left的值
        // 从右往左找，找出第一个满足 A[i] > A[i+1] 的数
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        // 如果没有这个数，就返回
        if (left == -1) {
            return arr;
        }

        // 在A[i] 右边找仅小于 A[i] 的数
        // 如果这个数出现了多次，取最左边的值
        int max = 0;
        for (int i = left + 1; i < n; i++) {
            // 比较max的时候不能选择等于的值
            if (arr[i] < arr[left] && max < arr[i]) {
                max = arr[i];
                right = i;
            }
        }

        // 交换
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;

        return arr;
    }
}
