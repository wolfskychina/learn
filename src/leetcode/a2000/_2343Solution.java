package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * 裁剪数字后查询第k小的数字
 * query表示将所有数字保留右侧q[1]位数字进行排序后的第q[0]大的数字
 * {offline},{Radix Sort},TODO 离线算法
 */
public class _2343Solution {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        var qid = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(qid, (i, j) -> queries[i][1] - queries[j][1]);

        var m = nums[0].length();
        var idx = new ArrayList<>(Arrays.asList(IntStream.range(0, nums.length).boxed().toArray(Integer[]::new)));

        var ans = new int[queries.length];
        var p = 1;
        for (var qi : qid) {
            var q = queries[qi];
            while (p <= q[1]) {
                final var pp = p++;
                Collections.sort(idx, (i, j) -> nums[i].charAt(m - pp) - nums[j].charAt(m - pp)); // 稳定排序
            }
            ans[qi] = idx.get(q[0] - 1);
        }
        return ans;
    }
}
