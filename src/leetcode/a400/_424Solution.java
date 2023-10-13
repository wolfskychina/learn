package leetcode.a400;

public class _424Solution {

    public int characterReplacement(String s, int k) {
        int max = 1;
        if (null == s || s.isEmpty())
            return 0;

        char[] carray = s.toCharArray();
        int i = 0;
        int j = 1;
        char currentC = carray[0];
        int starNum = 0;
        for (; j < carray.length; j++) {
            if (currentC == carray[j]) {
                max = Math.max(max, j - i + 1);
                continue;
            }

            if (currentC != carray[j] && starNum < k) {
                carray[j] = '*';
                starNum++;
                max = Math.max(max, j - i + 1);
                continue;
            }

            // found the last continues *
            int p = j - 1;
            starNum = 0;
            while ( p >= 0) {
                int pp =p;
                while (p>=0&&carray[p] == '*' && carray[j] == s.charAt(p)) {

                    carray[p] = carray[j];
                    p--;
                }
                while (p>=0&&carray[p] == carray[j]) {
                    p--;
                }
                while (p>=0 && carray[p] != carray[j] && starNum < k) {
                    carray[p] = '*';
                    starNum++;
                    p--;
                }
                if(pp ==p) break;

            }

            i = p + 1;
            currentC = carray[j];
            max = Math.max(max, j - i + 1);

        }

        return max;
    }

    public static void main(String[] args) {

        _424Solution so = new _424Solution();
        so.characterReplacement("ABAA", 0);
    }
}
