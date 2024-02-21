package leetcode.a1000;

/**
 * 两个数组间的距离值
 * {easy}
 */
public class _1385Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {

            for (int j : arr2) {

                if (Math.abs(i - j) <= d) {
                    count++;
                    break;
                }
            }

        }

        return arr1.length - count;
    }
}
