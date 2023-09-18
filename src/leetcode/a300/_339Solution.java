package leetcode.a300;

import java.util.List;

/**
 * 嵌套的整数列表，求各个元素数值和嵌套深度乘积的和
 * 简单的递归
 */
public class _339Solution {

    /**
     * 给出的api
     */
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested
        // list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int sum = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        for (NestedInteger nint : nestedList) {

            if (nint.isInteger()) {
                sum += nint.getInteger();
            } else {
                deptFind(depth + 1, nint.getList());
            }

        }

        return sum;

    }

    private void deptFind(int dept, List<NestedInteger> list) {

        for (NestedInteger nint : list) {
            if (nint.isInteger()) {
                sum += dept * nint.getInteger();
            } else {
                deptFind(dept + 1, nint.getList());
            }
        }
    }
}
