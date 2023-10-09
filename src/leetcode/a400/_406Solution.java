package leetcode.a400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照双重条件重建队列
 * (xi,yi) xi表示高度, yi表示在i之前的所有元素中，高度大于等于xi的元素个数
 */
public class _406Solution {

    /**
     * 按照高度从大到小插入队列符合贪心规则
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 按照不同高度，从高到低排序
        // 同样高度，按照前面不矮于自己的元素个数从小到大排序
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        List<int[]> ans = new ArrayList<>();
        // 先插入高度最高的，这样后续插入高度矮的节点，
        // 对原来高度更高的节点的第二个位置参数(左边大于等于节点高度的数)没有任何影响
        for (int[] p : people)
        // 类似于插入排序，会将后面的元素往后移动，单趟o(n)复杂度
            ans.add(p[1], p);
        return ans.toArray(new int[0][0]);
    }

}
