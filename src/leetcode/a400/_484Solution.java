package leetcode.a400;
/**
 * 根据相邻位的大小关系确定一个最小的排列组合
 */
public class _484Solution {

    // 注意细节有的地方如增减特性变化的时候需要回退一格
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
            j--;

        }

        return res;

    }

    public static void main(String[] args) {

        _484Solution so = new _484Solution();
        so.findPermutation("DDIIDI");
    }
}
