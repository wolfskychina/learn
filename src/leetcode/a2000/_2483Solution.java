package leetcode.a2000;

/**
 * 商店关门带价最小的一天
 * {prefix sum} 
 */
public class _2483Solution {

    public int bestClosingTime(String customers) {
        char[] cu = customers.toCharArray();
        int[] post = new int[cu.length];
        post[post.length - 1] = cu[post.length - 1] == 'Y' ? 1 : 0;
        for (int i = post.length - 2; i >= 0; i--) {
            if (cu[i] == 'Y')
                post[i] = post[i + 1] + 1;
            else
                post[i] = post[i + 1];
        }
        int[] prefix = new int[cu.length + 1];
        prefix[0] = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < post.length; i++) {

            if (min > prefix[i] + post[i]) {
                min = prefix[i] + post[i];
                res = i;
            }
            prefix[i + 1] = prefix[i] + (cu[i] == 'N' ? 1 : 0);
        }
        if (min > prefix[prefix.length - 1]) {
            min = prefix[prefix.length - 1];
            res = prefix.length - 1;
        }
        return res;

    }

    public static void main(String[] args) {
        _2483Solution so = new _2483Solution();
        String str = "YYNY";
        so.bestClosingTime(str);
    }
}
