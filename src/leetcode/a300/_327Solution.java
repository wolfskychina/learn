package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个整数数组 nums 以及两个整数 lower 和 upper 
 * 求数组中，值位于范围 [lower, upper]（包含 lower 和 upper）之内的 区间和的个数
 * {merge sort},{prefix sum}
 */
public class _327Solution {

    /**
     * 根据区间和等于k（325题）的解法简单修改
     * 取决于lower和upper的区间大小
     * o(n2)的时间复杂度
     * 有的测试用例超时了
     * 
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Long, List<Integer>> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        long preSum = 0;
        // 0 出现的位置在 -1 位置处
        List<Integer> list0 = new ArrayList<>();
        list0.add(-1);
        preSumIndex.put(0L, list0);
        // 特殊的情况，某个单独的前缀和构成了k大小
        // 这个时候不是两个前缀和的差，而是一个前缀和的值
        // 除了这种特殊情况，其他的和a+b=sum两数之和原理相同
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];

            // 检查一下是否需要更新答案
            // 如果lower和upper相距比较远的话，会比较慢
            for (int j = lower; j <= upper; j++) {

                if (preSumIndex.containsKey(preSum - j)) {

                    ans += preSumIndex.get(preSum - j).size();
                    // break;
                }
            }

            // 所有的前缀和哪怕相等都要记录坐标
            if (!preSumIndex.containsKey(preSum)) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                preSumIndex.put(preSum, tmpList);
            } else {
                preSumIndex.get(preSum).add(i);
            }

        }
        return ans;
    }

    /**
     * 运用归并排序
     * 将前缀数组进行归并排序，前缀数组的顺序并不会影响可能的区间和的数量
     * 每一趟归并的时候，左右两组前缀和的差的可能，所有趟加起来正好遍历了所有前缀和的差得可能
     * 
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = sum[p1++];
                    } else {
                        sorted[p++] = sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        _327Solution so = new _327Solution();
        // so.countRangeSum(a, -57577, 18133);
    }
}
