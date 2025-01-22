package leetcode.a1400;

import java.util.Arrays;

/**
 * 允许最多去掉数组中的k个元素，使得最后数组中能够剩余的不同的数字类型最少
 * {greedy},{math},{counting},{sort}
 */
public class _1481Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 统计出现次数为i的数字的个数
        int count[] = new int[100001];
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        int total=0;
        while (j < arr.length) {
            while (j < arr.length && arr[i] == arr[j]) {
                j++;
            }
            total++;
            count[j - i]++;
            i = j;
        }
        int res = 0;
        for (int m = 1; m < count.length; m++) {
            if (k - count[m] * m >= 0) {
                k -= count[m] * m;
                res += count[m];
            } else {
                res += k / m;
                break;
            }
        }

        return total - res;
    }

    public static void main(String[] args){

        _1481Solution so = new _1481Solution();
        int [] arr = {4,3,1,1,3,3,2};
        so.findLeastNumOfUniqueInts(arr,3 );
    }
}
