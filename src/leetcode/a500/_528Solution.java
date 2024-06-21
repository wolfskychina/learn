package leetcode.a500;

/**
 * 整数数组，数组中的值代表出现的可能性权重
 * 要求按照权重的概率返回数组的各个索引
 * {prefix sum},{binary search}
 */
public class _528Solution {

    int[] prefix;
    int[] w;
    int num;

    public _528Solution(int[] w) {
        this.w = w;
        prefix = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            prefix[i + 1] = prefix[i] + w[i];
        }
        num = prefix[prefix.length - 1];

    }

    public int pickIndex() {

        int re = (int) (num * Math.random()) + 1;
        int l = 0;
        int r = prefix.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (prefix[mid] < re) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return r - 1;
    }
}
