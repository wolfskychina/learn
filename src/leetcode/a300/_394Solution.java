package leetcode.a300;
/**
 * 将3[a]2[bc]类似形式的字符串解析成纯字符串
 * 数字代表[]内的字符串重复的次数
 */
public class _394Solution {

    // 每次递归都使用最新的全局变量
    int idx = 0;

    /**
     * 纯模拟,很容易做错，容易落掉处理每层最后的]符号
     * @param s
     * @return
     */
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();

        while (idx < s.length()) {

            while (idx < s.length() && s.charAt(idx) >= 'a' &&
                    s.charAt(idx) <= 'z') {
                sb.append(s.charAt(idx));
                idx++;
            }
            int num = 0;
            // check if to the end ]
            if (idx < s.length() && s.charAt(idx) != ']') {

                while (idx < s.length() && s.charAt(idx) >= '0' &&
                        s.charAt(idx) <= '9') {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                if (num != 0) {
                    // escape the [
                    idx++;
                    String str = decodeString(s);
                    for (int i = 0; i < num; i++) {
                        sb.append(str);
                    }
                    // escape the ]
                    idx++;
                }

            } else {
                // meet the ] ,end this layer
                break;
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {

        _394Solution so = new _394Solution();
        System.out.println(so.decodeString("2[abc]3[cd]ef"));
    }
}
