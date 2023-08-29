package leetcode.a300;

/**
 * 判断一个单词数组的排列顺序是否满足pattern的形式
 */
public class _290Solution {
    /**
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] slist = s.split(" ");
        if (pattern.length() != slist.length) return false;

        String[] plist = new String[26];
        char[] pchar = pattern.toCharArray();

        for (int i = 0; i < slist.length; i++) {
            if (plist[pchar[i] - 'a'] == null) {
                plist[pchar[i] - 'a'] = slist[i];
            } else {
                // 字符串比较方法
                if (!plist[pchar[i] - 'a'].equals(slist[i]))
                    return false;
            }

        }

        // 校验pattern本身abba，a和b不能相同
        // 因为是pattern和s是双向映射
        // 所以pattern本身a和b不能相同
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                if (plist[i] == null || plist[j] == null) continue;
                if (plist[i].equals(plist[j])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _290Solution so = new _290Solution();

    }
}
