package leetcode.a500;
/**
 * 判断一个单词是否是合法的首字母大小写
 * 合法的情况：
 * 1.全大写
 * 2.全小写
 * 3.首字母大写，其他全小写
 */
public class _520Solution {

    public boolean detectCapitalUse(String word) {

        if (word == null || word.length() == 0)
            return false;
        if (word.length() == 1)
            return true;

        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {

            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z')
                    return false;
            }
            return true;
        } else if (word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z')
                    return false;
            }
            return true;
        } else {
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) < 'A' || word.charAt(i) > 'Z')
                    return false;
            }
            return true;
        }

    }
}
