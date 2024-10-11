package leetcode.a400;

/**
 * 从一个数字字符串中删除k个字符，使得剩下的字符组成的数字最小
 */
public class _402Solution {

    /**
     * {greedy},{monotonic stack}
     * 单调上升的序列一定不能删除
     * 
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {

        int length = num.length(), index_stack = 0, index_chars = 0;
        char[] chars = num.toCharArray();
        char[] stack = new char[length + 1];
        stack[0] = '0';
        for (int i = 0; i < k; i++) {
            // 如果保持单调性就入栈
            while (index_chars < length && stack[index_stack] <= chars[index_chars]) {
                stack[++index_stack] = chars[index_chars++];
            }
            // 如果遇到比栈顶更小的就出栈
            index_stack--;
        }

        while (index_chars < length) {

            stack[++index_stack] = chars[index_chars];
            index_chars++;
        }

        int left = 0;

        // 去掉前导0
        while (left < index_stack && stack[left] == '0')
            left++;

        return new String(stack, left, index_stack - left + 1);

    }

    public static void main(String[] args) {

        _402Solution so = new _402Solution();
        so.removeKdigits("1173", 2);

    }
}
