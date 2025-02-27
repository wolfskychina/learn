package leetcode.a2000;

/**
 * 设计一个支持在光标处添加删除字符和光标左右移动的文本编辑器
 * {design},{stack},{classic}
 */
public class _2296Solution {

    /**
     * 使用StringBuilder来模拟栈
     */
    class TextEditor {
        private final StringBuilder left = new StringBuilder(); // 光标左侧字符
        private final StringBuilder right = new StringBuilder(); // 光标右侧字符

        public void addText(String text) {
            left.append(text); // 入栈
        }

        public int deleteText(int k) {
            k = Math.min(k, left.length());
            left.setLength(left.length() - k); // 出栈
            return k;
        }

        public String cursorLeft(int k) {
            while (k > 0 && !left.isEmpty()) {
                right.append(left.charAt(left.length() - 1)); // 左手倒右手
                left.setLength(left.length() - 1);
                k--;
            }
            return text();
        }

        public String cursorRight(int k) {
            while (k > 0 && !right.isEmpty()) {
                left.append(right.charAt(right.length() - 1)); // 右手倒左手
                right.setLength(right.length() - 1);
                k--;
            }
            return text();
        }

        private String text() {
            // 光标左边至多 10 个字符
            return left.substring(Math.max(left.length() - 10, 0));
        }
    }
}
