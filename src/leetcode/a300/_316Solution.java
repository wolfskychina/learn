package leetcode.a300;

public class _316Solution {

    /**
     * 每次使s(0,i)字母序列最小不符合贪心规则，所以这个每次局部最优解的方法是错误的
     * 
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        if (s == null)
            return null;
        if (s.equals(""))
            return s;
        String pre = s.substring(0, 1);

        for (int i = 1; i < s.length(); i++) {

            if (!pre.contains("" + s.charAt(i))) {
                pre = pre + s.charAt(i);
            } else {
                String newStr = pre.replace("" + s.charAt(i), "") + s.charAt(i);
                if (pre.compareTo(newStr) > 0) {
                    pre = newStr;
                }

            }
        }

        return pre;
    }

    /**
     * 单调栈
     */
    public String removeDuplicateLetters2(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _316Solution so = new _316Solution();
        String in = "bcabc";
        so.removeDuplicateLetters(in);

    }

}
