package leetcode.a1400;

/**
 * 将s中所有的字符重新组合后，能否构造k个回文串
 * {palindrome},{greedy}
 */
public class _1400Solutoin {

    /**
     * 实际上只和s的总长度以及出现次数为奇数的字符的个数相关
     * @param s
     * @param k
     * @return
     */
    public boolean canConstruct(String s, int k) {

        int count[] = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // int sum2 =0;
        int sum1 = 0;
        for (int i = 0; i < 26; i++) {
            // sum2+=count[i]/2;
            sum1 += count[i] % 2;
        }
        if (s.length() < k)
            return false;
        if (sum1 > k)
            return false;

        return true;

    }

    public static void main(String[] args) {

        _1400Solutoin so = new _1400Solutoin();
        so.canConstruct("ibzkwaxxaggkiwjbeysz", 15);
    }
}
