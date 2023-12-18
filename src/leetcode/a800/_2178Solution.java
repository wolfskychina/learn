package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * 一个数能够拆分出的最多的正偶数的和
 */
public class _2178Solution {
   
    /**
     * 首先必须是偶数才能拆成偶数之和
     * 因为不能重复，按照2,4,6,8...i的顺序去拆
     * 直到剩下的值小于i，将剩下的值加到i上面即可
     * {greedy}
     * @param finalSum
     * @return
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 > 0) return List.of();
        var ans = new ArrayList<Long>();
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        int back = ans.size() - 1;
        ans.set(back, ans.get(back) + finalSum);
        return ans;

    }

    public static void main(String[] args){
        _2178Solution so = new _2178Solution();
        so.maximumEvenSplit(10000l);
    }
}
