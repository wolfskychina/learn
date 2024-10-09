package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 商品折扣后的最终价格
 * {monotonic stack}
 */
public class _1475Solution {
   
    public int[] finalPrices(int[] ps) {
        int n = ps.length;
        int[] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && ps[d.peekLast()] >= ps[i]) {
                int idx = d.pollLast();
                ans[idx] = ps[idx] - ps[i];
            }
            d.addLast(i); ans[i] = ps[i];
        }
        return ans;
    }

    public static void main(String[] args){
        _1475Solution so = new _1475Solution();
        int[] prices = {10,1,1,6};
        so.finalPrices(prices);
    }
}
