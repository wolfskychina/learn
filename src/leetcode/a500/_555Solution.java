package leetcode.a500;

/**
 * 一组字符串，对于每个字符串允许按照原顺序或者反转后拼接
 * 成环，最后一个字符串下一个是第一个字符串
 * 然后将拼接成的字符串从任意位置断开
 * 求能够生成的最大字典序的字符串
 * TODO
 */
public class _555Solution {

    /**
     * 因为切点必定在其中一个字符串中，所以对于除了这个被切开的字符串
     * 其他的字符串均不切开，那么其他字符串最终的顺序就是他本身最大的顺序
     * 根据这一特点，只需要假定从每一个字符串中间切开，遍历正反方向所有切点
     * {greedy},{circled}
     * 
     * @param strs
     * @return
     */
    public String splitLoopedString(String[] strs) {
        for (int i = 0; i != strs.length; ++i) {
            String str = strs[i];
            String rev = new StringBuffer(str).reverse().toString();
            if (rev.compareTo(str) > 0)
                strs[i] = rev;
        }
        String ans = "";
        for (int i = 0; i != strs.length; ++i) {
            String str = strs[i];
            String rev = new StringBuffer(str).reverse().toString();
            String other = "";
            for (int j = i + 1; j != strs.length; ++j)
                other += strs[j];
            for (int j = 0; j != i; ++j)
                other += strs[j];
            for (int j = 0; j != str.length(); ++j) {
                String cur = str.substring(j) + other + str.substring(0, j);
                if (cur.compareTo(ans) > 0)
                    ans = cur;
                String cur1 = rev.substring(j) + other + rev.substring(0, j);
                if (cur1.compareTo(ans) > 0)
                    ans = cur1;
            }

        }
        return ans;
    }
}
