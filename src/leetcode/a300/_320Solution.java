package leetcode.a300;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个字符串的所有带数字的缩写
 */
public class _320Solution {

    List<String> res = new ArrayList<>();

    /**
     * backtrck，轮流生成字符和数字缩写
     */
    public List<String> generateAbbreviations(String word) {

        for (int i = 1; i <= word.length(); i++) {

            formList(word, i, word.substring(0, i), 1);

            formList(word, i, "" + i, 2);
        }

        return res;

    }

    private void formList(String word, int start, String prefix, int flag) {

        if (start == word.length()) {
            res.add(prefix);
        }

        for (int i = start; i < word.length(); i++) {
            if (flag == 1) {
                // 上一轮是字母，这一轮需要是数字
                formList(word, i + 1, prefix + (i - start + 1), 2);

            } else {
                formList(word, i + 1, prefix + word.substring(start, i + 1), 1);
            }
        }
    }

    /**
     * 另外一种更快的方式，每一位进行扩增
     * 标记到目前累计的未转化成缩写的数字位数
     * @param word
     * @return
     */
    public List<String> generateAbbreviations2(String word) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length(); // keep the length of builder
        if (i == word.length()) {
            if (k != 0)
                builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0)
                builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len); // reset builder to the original state
    }

    /**
     * 解法3：将每个字符是否缩写抽象成为数字bit的0和1
     * 问题转换为将所有word.length位的二级制数转换成对应的缩写形式
     * @param word
     * @return
     */
    public List<String> generateAbbreviations3(String word) {
        List<String> ans = new ArrayList<>();
        for (int x = 0; x < (1 << word.length()); ++x) // loop through all possible x
            ans.add(abbr(word, x));
        return ans;
    }

    // build the abbreviation for word from number x
    private String abbr(String word, int x) {
        StringBuilder builder = new StringBuilder();
        int k = 0, n = word.length(); // k is the count of consecutive ones in x
        for (int i = 0; i < n; ++i, x >>= 1) {
            if ((x & 1) == 0) { // bit is zero, we keep word.charAt(i)
                if (k != 0) { // we have abbreviated k characters
                    builder.append(k);
                    k = 0; // reset the counter k
                }
                builder.append(word.charAt(i));
            }
            else // bit is one, increase k
                ++k;
        }
        if (k != 0) builder.append(k); //don't forget to append the last k if non zero
        return builder.toString();
    }

    public static void main(String[] args) {
        _320Solution so = new _320Solution();
        so.generateAbbreviations("word");

    }
}
