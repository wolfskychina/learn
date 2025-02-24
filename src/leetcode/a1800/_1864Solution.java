package leetcode.a1800;

/**
 * 将二进制字符串构造成01交替出现的形式所需要的最少交换次数
 * 任意两位都可以交换
 * {greedy}
 */
public class _1864Solution {

    /**
     * 分情况讨论，分支条件比较多
     * 因为只有两种字符，所以只需要考虑1种字符的最少移动即可
     * @param s
     * @return
     */
    public int minSwaps(String s) {

        int num0 = 0;
        int num1 = 0;
        int num11 = 0;
        int num12 = 0;

        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                num0++;

            } else {
                num1++;
                if (idx % 2 == 0)
                    num11++;
                else
                    num12++;
            }

            idx++;
        }

        // 按照字符串的长度的奇偶性分情况讨论
        if (s.length() % 2 == 0 && num0 != num1) {
            return -1;
        }
        if (s.length() % 2 == 0) {
            return Math.min(num11, num12);
        }
        if (s.length() % 2 == 1 && Math.abs(num1 - num0) != 1) {
            return -1;
        }

        if(num1>num0)
        return s.length() / 2 + 1 - num11;
        else 
        return s.length() / 2 - num12;

    }

    public static void main(String[] args){
        _1864Solution so = new _1864Solution();
        so.minSwaps("1100110");
    }
}
