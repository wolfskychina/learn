package leetcode.a2000;

/**
 * 从原字符串s构造连续字符不超过repeatLimit的最大字符串
 * {greedy}
 */
public class _2182Solution {

    /**
     * 自己的解法
     * 
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString(String s, int repeatLimit) {

        int count[] = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {

            while (true) {
                if (count[i] <= repeatLimit) {
                    while (count[i] != 0) {
                        sb.append((char) ('a' + i));
                        count[i]--;
                    }
                    break;
                } else {
                    for (int j = 0; j < repeatLimit; j++) {
                        sb.append((char) ('a' + i));
                    }
                    count[i] -= repeatLimit;
                    boolean found = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if (count[j] > 0) {
                            found = true;
                            count[j]--;
                            sb.append((char) ('a' + j));
                            break;
                        }
                    }
                    if (!found) {
                        return sb.toString();
                    }
                }
            }

        }

        return sb.toString();

    }

    /**
     * 另一种相同思路的解法，更加简洁
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString1(String s, int repeatLimit) {
        int[] sChars = new int[26];
        for (byte b : s.getBytes()) {
            sChars[b - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int k = i - 1;
            while (true) {
                for (int j = 0; j < repeatLimit && sChars[i] > 0; j++) {
                    sChars[i]--;
                    builder.append((char) (i + 'a'));
                }
                if (sChars[i] == 0) {
                    break;
                }
                while (k >= 0 && sChars[k] == 0) {
                    k--;
                }
                if (k < 0) {
                    break;
                }
                sChars[k]--;
                builder.append((char) (k + 'a'));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        _2182Solution so = new _2182Solution();
        String s = "robnsdvpuxbapuqgopqvxdrchivlifeepy";
        so.repeatLimitedString(s, 2);
    }
}
