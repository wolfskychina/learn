package leetcode.a400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 输出一个数组的所有上升子序列（子序列节点数至少有两个） 
 */
public class _491Solution {

    /**
     * 标准dfs解法，但是比较慢，只战胜了6%
     * {dfs},{backtrace}
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmpList = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                tmpList.add(nums[i]);
                dfs(nums, i + 1, tmpList, set);
                tmpList.remove(0);
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> tmpList, Set<List<Integer>> set) {
        for (int i = start; i < nums.length; i++) {

            if (nums[i] >= tmpList.get(tmpList.size() - 1) && (i == start || nums[i] != nums[i - 1])) {
                tmpList.add(nums[i]);
                if (!set.contains(tmpList)) {
                    List<Integer> list = new LinkedList<>(tmpList);
                    set.add(list);

                }
                dfs(nums, i + 1, tmpList, set);
                tmpList.remove(tmpList.size() - 1);
            }
        }

    }

    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    // 不用Set的去重方法
    /**
     * 一个只有2ms的解法
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences2(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        // 通过两种递归完成解空间的遍历
        // 如果大于等于就选择
        // 进入下一层递归
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }

        // 这个dfs的巧妙之处在于支持平级的跳转
        // 平行跳转到下一个元素
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }


    public static void main(String[] args) {
        _491Solution so = new _491Solution();
        int[] array = { 4, 6, 7, 7 };
        so.findSubsequences(array);
    }
}
