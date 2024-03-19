package leetcode.a2000;

import java.util.List;
/**
 * 一排直线上停若干车之后，占用的停车空间，车可能有重叠
 * {easy}
 * {prefix sum}
 */
public class _2848Solution {

    public int numberOfPoints(List<List<Integer>> nums) {

        int count[] = new int[102];

        for (List<Integer> list : nums) {

            count[list.get(0)]++;
            // 注意因为在车尾的下一个节点标记，所以count的空间要大一个
            count[list.get(1) + 1]--;
        }
        int tmp = 0;
        int num = 0;
        for (int i = 1; i < count.length - 1; i++) {

            tmp += count[i];
            if (tmp > 0)
                num++;
        }
        return num;

    }
}
