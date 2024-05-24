package leetcode.a300;

/**
 * 区间元素
 * 一个长度为length的数组，初始所有元素大小为0
 * 一个update数组,元组[startidx,endidx,incr]表示将前面数组的区间
 * 元素增加incr，incr可能为负值
 * 输出最后的数组
 */
public class _370Solution {

    /**
     * 考虑每个对每个区间的操作之后，startidx和之前元素差值为incr
     * endidx+1和endidx的元素差值为-incr
     * 只需要记录每个元素和前一个元素的差值即可还原
     * 
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        int[] ans = new int[length];
        for (int[] input : updates) {
            int start = input[0];
            int end = input[1];
            diff[start] += input[2];
            if (end < length - 1) {
                diff[end + 1] -= input[2];
            }
        }
        ans[0] = diff[0];
        for (int i = 1; i < length; i++) {
            // 继承前一个元素大小，加上和前一个元素的差值
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
