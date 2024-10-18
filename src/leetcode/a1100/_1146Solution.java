package leetcode.a1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一种快照数组
 * {design},{binary search}
 */
public class _1146Solution {

    class SnapshotArray {
        // 当前快照编号，初始值为 0
        private int curSnapId;

        // 每个 index 的历史修改记录
        private final Map<Integer, List<int[]>> history = new HashMap<>();

        public SnapshotArray(int length) {
        }

        public void set(int index, int val) {
            history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[] { curSnapId, val });
        }

        public int snap() {
            return curSnapId++;
        }

        public int get(int index, int snapId) {
            if (!history.containsKey(index)) {
                return 0;
            }
            List<int[]> h = history.get(index);
            int j = search(h, snapId);
            return j < 0 ? 0 : h.get(j)[1];
        }

        // 返回最大的下标 i，满足 h[i][0] <= x
        // 如果不存在则返回 -1
        private int search(List<int[]> h, int x) {
            // 开区间 (left, right)
            int left = -1;
            int right = h.size();
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // h[left][0] <= x
                // h[right][0] > x
                int mid = left + (right - left) / 2;
                if (h.get(mid)[0] <= x) {
                    left = mid; // 区间缩小为 (mid, right)
                } else {
                    right = mid; // 区间缩小为 (left, mid)
                }
            }
            // 根据循环不变量，此时 h[left][0] <= x 且 h[left+1][0] = h[right][0] > x
            // 所以 left 是最大的满足 h[left][0] <= x 的下标
            // 如果不存在，则 left 为其初始值 -1
            return left;
        }
    }

}
