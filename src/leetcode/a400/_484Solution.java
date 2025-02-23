package leetcode.a400;
/**
 * 根据给出的相邻位的大小关系确定一个满足要求的从1-n的最小的排列
 */
public class _484Solution {

    // 注意细节有的地方如增减特性变化的时候需要回退一格
    /**
     * {greedy}
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {

        // s == I or D
        int[] res = new int[s.length() + 1];
        int i = 0;
        int hightest = 1;
        int j = 0;
        while (i < s.length()) {
            int tmpNum = 0;

            while (i < s.length() && s.charAt(i) == 'D') {
                hightest++;
                i++;
                tmpNum++;
            }
            int l = hightest;
            for (int k = 0; k < tmpNum + 1; k++, l--) {
                res[j++] = l;
            }
            while (i < s.length() && s.charAt(i) == 'I') {
                hightest++;
                res[j++] = hightest;
                i++;
            }
            // 回退一格，如果后续发生反转，最后一个填充的值需要跟后面的比大小
            // 而后面会是递减序列，当前填充的值是最小可能值，没法继续填充
            // 需要撤销这个值，相当于把这个值移动到后面递减序列的最后一个
            j--;

        }

        return res;

    }

    public static void main(String[] args) {

        _484Solution so = new _484Solution();
        so.findPermutation("DDIIDI");
    }
}
