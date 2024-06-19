package leetcode.a400;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给定一些矩形，从这些矩形的范围内等概率的随机取整数点
 * {random}
 */
public class _497Solution {

    int[][] sides;
    int ridx = -1;
    int[][] rects;

    /**
     * 按照矩形点的数量分配概率,但是无法通过某些测试案例
     * 
     * @param rects
     */
    public _497Solution(int[][] rects) {
        this.rects = rects;

        sides = new int[rects.length][2];
        int num = 0;
        for (int i = 0; i < rects.length; i++) {

            num = (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
            sides[i][0] = ridx + 1;
            sides[i][1] = ridx + num;
            ridx += num;
        }

    }

    public int[] pick() {

        int p = (int) Math.random() * (ridx + 1);
        int i = 0;
        while (i < sides.length && sides[i][1] < p) {
            i++;
        }
        int x1 = rects[i][0];
        int y1 = rects[i][1];
        int x2 = rects[i][2];
        int y2 = rects[i][3];

        int x = x1 + (int) Math.random() * (x2 - x1 + 1);
        int y = y1 + (int) Math.random() * (y2 - y1 + 1);
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;

    }

    /**
     * {binary search},{prefix sum}
     */
    class Solution {
        Random rand;
        List<Integer> arr;
        int[][] rects;

        public Solution(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<Integer>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[] { a + da, b + db };
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
