package leetcode.a300;

import java.util.List;
/**
 * 多层嵌套序列的加权和
 * 权重为最大深度-当前深度
 */
public class _364Solution {

    /**
     * 给出的api
     */
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger();

        public Integer getInteger();

        public void setInteger(int value);

        public void add(NestedInteger ni);

        public List<NestedInteger> getList();
    }

    int maxH = 0;
    int sum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {

        for (NestedInteger i : nestedList) {
            if(!i.isInteger()&&i.getList().isEmpty())
                continue;
            // 保证纯嵌套list的时候，能够正确统计深度
            maxH = Math.max(maxH, 1);
            if (!i.isInteger()) {
                findMaxHeight(2, i.getList());
            }

        }

        for (NestedInteger i : nestedList) {
        
            if (!i.isInteger()) {
                getWeightSum(2, i.getList());
            } else {
                sum += i.getInteger() * maxH;
            }

        }

        return sum;

    }

    private void getWeightSum(int h, List<NestedInteger> list) {

        for (NestedInteger i : list) {

            if (!i.isInteger()) {
                getWeightSum(h + 1, i.getList());
            } else {
                sum += i.getInteger() * (maxH - h + 1);
            }

        }

    }

    private void findMaxHeight(int h, List<NestedInteger> list) {
        if(list.isEmpty())
                return;
        maxH = Math.max(maxH, h);
        for (NestedInteger i : list) {
            if (!i.isInteger()) {
                findMaxHeight(h + 1, i.getList());
            }
        }
    }
}
