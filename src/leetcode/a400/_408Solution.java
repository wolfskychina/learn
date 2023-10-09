package leetcode.a400;
/**
 * 判断一个缩写字符串是不是另一个原串的k8s形式的缩写
 */
public class _408Solution {

    public boolean validWordAbbreviation(String word, String abbr) {

        int i = 0;
        int j = 0;
        int nword = word.length();
        int nabbr = abbr.length();
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();
        while (i < nword && j < nabbr) {
            if (w[i] == a[j]) {
                i++;
                j++;
                continue;
            }
            if ((a[j] >= 'a' && a[j] <= 'z') ||
                    a[j] == '0') {
                return false;
            }
            int tmp = j;
            // tmp<nabbr 很容易越界
            while (tmp < nabbr && a[tmp] >= '0' && a[tmp] <= '9') {
                tmp++;
            }
            int len = Integer.parseInt(abbr.substring(j, tmp));
            j = tmp;
            i += len;

        }

        if (i == nword && j == nabbr) {
            return true;
        } else {
            return false;
        }

    }
}
