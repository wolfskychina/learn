package leetcode.a2000;

/**
 * 银行中的激光束数量
 * {easy}
 */
public class _2125Solution {

    public int numberOfBeams(String[] bank) {

        int i = 0;
        int res = 0;
        while (i < bank.length) {

            while (i < bank.length && !bank[i].contains("1")) {
                i++;
            }
            if (i == bank.length)
                break;
            String m = bank[i];
            i++;
            while (i < bank.length && !bank[i].contains("1")) {
                i++;
            }
            if (i == bank.length)
                break;
            String n = bank[i];
            res += numof(m) * numof(n);
        }

        return res;
    }

    private int numof(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                res++;
        }
        return res;
    }
}
