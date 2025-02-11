package leetcode.a3000;

/**
 * 允许对字符串的任意字符的值总共+1或者-1操作不超过k次
 * 满足距离约束且字典序最小的字符串
 */
public class _3106Solution {

    /**
     * 从左往右，能变成a就以最小的代价变成a，如果不能就减去尽可能多的大小
     * {greedy}
     * @param s
     * @param k
     * @return
     */
    public String getSmallestString(String s, int k) {

        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length && k != 0; i++) {

            int add = 1 + ('z' - ss[i]);
            int min = Math.min(ss[i] - 'a', add);

            if (min <= k) {
                ss[i] = 'a';
                k -= min;
            } else {
                ss[i] -= k;
                break;
            }

        }

        return new String(ss);
    }

    public static void main(String[] args) {
        _3106Solution so = new _3106Solution();
        so.getSmallestString("xaxcd", 4);
    }
}
