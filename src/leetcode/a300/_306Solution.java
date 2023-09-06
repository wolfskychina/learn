package leetcode.a300;

/**
 * 判断一个字符串是不是斐波那契数拼出来的
 */
public class _306Solution {

    /**
     * 回溯，速度不是很快
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        boolean res = false;

        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {

                // i，j双指针
                String str1 = num.substring(0, i);
                String str2 = num.substring(i, j);
                // 跳过数字以0开头的情况
                if ((str1.length() > 1 && str1.startsWith("0")) || (str2.length() > 1 && str2.startsWith("0"))) {
                    continue;
                }
                Long sum = Long.parseLong(str1) + Long.parseLong(str2);
                // 计算sum的位数
                int bits = countbits(sum);
                String sumStr = String.valueOf(sum);
                if (num.substring(j).startsWith(sumStr)) { // 登记新的ij的位置，开始新一轮的递归
                    if (j + bits == num.length())
                        return true;
                    res = res || find(Long.parseLong(str2), sum, j + bits, num);
                }
            }
        }

        return res;
    }

    /**
     * i，j为新的a和b的
     */
    private boolean find(Long a, Long b, int start, String num) {

        Long sum = a + b;
        int bits = countbits(sum);
        if (start + bits > num.length()) {
            return false;
        }
        if (start + bits == num.length()) {
            return sum == Long.parseLong(num.substring(start));
        }

        // 需要继续迭代
        return find(b, sum, start + bits, num);

    }

    private int countbits(Long num) {
        int bits = 1;
        while (num > 9) {

            num = num / 10;
            bits++;
        }
        return bits;

    }

    /**
     * 更快的解法，基于v和sum的大小比较，不需要计算sum的位数
     */
    public boolean isAdditiveNumber2(String num) {
        return dfs(num.toCharArray(), 0, 0, 0, 0);
    }

    private boolean dfs(char[] cs, int start, long prev1, long prev2, int count) {
        if (start == cs.length) {
            return count >= 3;
        }

        long v = 0;
        for (int i = start; i < cs.length; i++) {
            if (i != start && cs[start] == '0')
                break;
            v = v * 10 + cs[i] - '0';
            if (count >= 2) {
                long sum = prev1 + prev2;
                if (v > sum)
                    break;
                else if (v < sum)
                    continue;
            }

            if (dfs(cs, i + 1, prev2, v, count + 1) == true)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        _306Solution so = new _306Solution();
        so.isAdditiveNumber("123");

    }
}
