package leetcode.a700;
/**
 * 将数字的每一位180度反转后，是否是不同的好数
 * 
 */
public class _788Solution {

    // 0,1,8反转了一定是好数
    // 2,5,6,9反转一定是不一样的好数
    // 剩下的反转了不是好数
    // 因此一个数反转了如果是不一样的好数，2,5,6,9一定至少有一个
    // 0.1.8有没有无所谓，剩下的数字不能出现
    static int[] check = { 0, 0, 1, -1, -1, 1, 1, -1, 0, 1 };

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }

}
