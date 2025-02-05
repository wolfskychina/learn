package leetcode.a2000;

/**
 * 将数字字符串划分成最少的子串，使得每个子串表示的数字大小都不超过k
 * {greedy}
 */
public class _2522Solution {

    public int minimumPartition(String s, int k) {
        char[] ss = s.toCharArray();
        int i = 0;
        int tmp = 0;
        int res = 0;
        while (i < ss.length) {

            tmp = 0;
            // TODO 注意在比较的时候可能出现int越界的问题
            while (i < ss.length && (long)10 * tmp + ss[i] - '0' <= k) {
                tmp = 10 * tmp + ss[i] - '0';
                i++;
            }
            if (i < ss.length && tmp == 0)
                return -1;

            res++;
        }

        return res;
    }

    public static void main(String [] args){
        _2522Solution so = new _2522Solution();
        String s = "165462";
        so.minimumPartition(s, 60);
    }
}
