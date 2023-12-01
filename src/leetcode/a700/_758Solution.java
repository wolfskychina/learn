package leetcode.a700;

/**
 * 给指定的单词加粗
 * 同616问题
 */
public class _758Solution {
    // same as 616
    public String boldWords(String[] words, String s) {

        int len = s.length();
        boolean[] needadd = new boolean[len];
        for (String word : words) {
            int i = s.indexOf(word);
            int wlen = word.length();
            while (i != -1) {
                for (int j = i; j < i + wlen; j++) {
                    needadd[j] = true;
                }
                i = s.indexOf(word, i + 1);
            }
        }

        // 因为有保存每个字符是否加粗，所以连续需要加粗的就可以一起跳过
        StringBuilder ans = new StringBuilder();
        int left = 0;
        while (left < len) {
            if (needadd[left]) {
                ans.append("<b>");
                while (left < len && needadd[left]) {
                    ans.append(s.charAt(left));
                    left++;
                }
                ans.append("</b>");
            } else {
                ans.append(s.charAt(left));
                left++;
            }
        }
        return ans.toString();
    }
}
