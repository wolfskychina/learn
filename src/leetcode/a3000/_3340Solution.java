package leetcode.a3000;

/**
 * 检查是否是平衡字符串
 * {easy}
 */
public class _3340Solution {

    public boolean isBalanced(String num) {

        int flag = -1;
        int sum = 0;
        for (char c : num.toCharArray()) {
            flag *= -1;
            sum += flag * (c - '0');
        }
        return sum == 0;
    }
}
