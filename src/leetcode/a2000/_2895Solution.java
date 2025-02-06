package leetcode.a2000;

import java.util.Collections;
import java.util.List;

/**
 * 处理器处理完所有任务所需要的最短时间
 * {greedy},{easy}
 */
public class _2895Solution {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);

        int max = 0;
        int i = 0;
        int j = tasks.size() - 1;
        while (i < processorTime.size()) {

            for (int m = 0; m < 4; m++, j--) {
                max = Math.max(max, processorTime.get(i) + tasks.get(j));
            }
            i++;
        }

        return max;
    }
}
