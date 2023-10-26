package leetcode.a400;

/**
 * 481. Magical String
 * 字符串生成的时候1或者2重复的次数和字符串从前往后遍历到的位的数字一致
 * s = "1221121221221121122……"
 */
public class _481Solution {

    /**
     * 模拟生成到n位字符串
     * 
     * @param n
     * @return
     */
    public int magicalString(int n) {

        if (n <= 3)
            return 1;

        // "122"
        int numOf1 = 1;
        int i = 2;
        int j = 3;
        boolean if1 = true;
        char[] sb = new char[n];
        sb[0]='1';
        sb[1]='2';
        sb[2]='2';

        while (j < n) {

            int repeats = sb[i] == '1' ? 1 : 2;
            if (j + repeats < n) {

                if (if1) {
                    for (int k = 0; k < repeats; k++) {
                        sb[k+j] = '1';
                    }
                    numOf1 += repeats;
                    if1 = false;
                } else {
                    for (int k = 0; k < repeats; k++) {
                        sb[k+j] = '2';
                    }
                    if1 = true;

                }

                i++;
                j += repeats;

            } else {

                if (if1) {
                    numOf1 += n - j;
                }
                j += repeats;
                break;
            }
        }

        return numOf1;

    }

    /**
     * 官方构造字符串的解法，更为简洁
     * 
     * @param n
     * @return
     */
    public int magicalString1(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++res;
                }
                ++j;
                --size;
            }
            ++i;
        }
        return res;
    }
}
