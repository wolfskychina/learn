package leetcode.a400;

public class _482Solution {

    public String licenseKeyFormatting(String s, int k) {

        // s = "5F3Z-2e-9-w"
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = 0;
        while (i >= 0) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c <= 'Z' && c >= 'A')) {
                sb.append(c);
                j++;
            } else if (c >= 'a' && c <= 'z') {
                // sb.append()函数 'A' + c - 'a'默认返回是int类型
                sb.append((char) ('A' + c - 'a'));
                j++;
            }
            if (j == k) {
                sb.append('-');
                j = 0;
            }

            i--;
        }

        // TODO 注意sb可能是空的
        if (sb.length()!=0 && sb.charAt(sb.length() - 1) == '-')
            sb.setLength(sb.length() - 1);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _482Solution so = new _482Solution();
        so.licenseKeyFormatting("5F3Z-2e-9-w", 4);
    }
}
