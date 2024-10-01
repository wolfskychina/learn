package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中[left,right]子数组中value值出现的次数
 * {binary search},
 */
public class _2080Solution {

    class RangeFreqQuery {
        List<List<Integer>> all = new ArrayList<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i <= 10000; i++) {
                all.add(new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                // 下标是按顺序加入的，所以是有序的，所以后面可以直接进行二分查找
                all.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (all.get(value).size() == 0)
                return 0;
            // 当前值对应的下标集合
            List<Integer> now = all.get(value);
            // 第一次二分找左端点下标
            int a = binarySearch(now, 0, now.size() - 1, left);
            // 不存在这样的左端点
            if (now.get(a) > right || now.get(a) < left)
                return 0;

            // 第二次二分，找右端点的下标
            int b = binarySearch(now, a, now.size() - 1, right);
            // 没有等于，只有大于的情况
            if (now.get(b) > right) {
                b--;
            }
            return b - a + 1;
        }

        // 找到大于等于target的第一个位置
        public int binarySearch(List<Integer> nums, int l, int r, int target) {
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (nums.get(mid) < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
