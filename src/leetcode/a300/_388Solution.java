package leetcode.a300;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 统计字符串表示的多文件目录中，最长的文件目录的长度
 * TODO 
 */
public class _388Solution {

    /**
     * 遇到相等或者更小的深度说明一个路径遍历完了，返回到上一层（可能返回多次）
     * 如果深度比之前加一，说明还在同一个路径上，如果是文件夹就入栈
     * 如果是文件就计算长度
     * 需要的变量比较多
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过当前的换行符 */
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

}
