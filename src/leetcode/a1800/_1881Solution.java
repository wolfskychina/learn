package leetcode.a1800;

/**
 * 往字符串表示的数字中插入一个x后能够形成的最大值
 * 原始数字可能是负值
 * {greedy}
 * @param n
 * @param x
 * @return
 */
public class _1881Solution {
   
    /**
     * 注意字符相等的情况也要继续往下比较
     * 536 x=3的情况 5363比5336更大
     * @param n
     * @param x
     * @return
     */
    public String maxValue(String n, int x) {
        int i = 0;
        if (n.startsWith("-")) {
            i = 1;

            while (i < n.length() && n.charAt(i) - '0' <= x) {
                i++;

            }

        } else {

            while (i < n.length() && n.charAt(i) - '0' >= x) {
                i++;
            }

        }

        return n.substring(0, i) + (char) (x + '0') + n.substring(i);

    }
}
}
