package leetcode.a800;
/**
 * 亲密字符串
 * 一个字符串能否通过交换一对字符的位置变成另外一个字符串
 * 两个字符串有可能是相同的，需要判断的条件比较多
 */
public class _859Solution {

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length())
            return false;
        char[] ss = s.toCharArray();
        char[] gg = goal.toCharArray();
        int[] c = new int[2];
        int i = 0;
        int same[] = new int[26];
        for (int j = 0; j < ss.length; j++) {
            if (ss[j] != gg[j]) {
                if (i == 2)
                    return false;
                c[i] = j;
                i++;
            } else {
                same[ss[j] - 'a']++;
            }
        }
        if (i == 0) {
            for (int a : same) {
                if (a > 1)
                    return true;
            }
            return false;
        }

        if (ss[c[0]] == gg[c[1]] && ss[c[1]] == gg[c[0]])
            return true;
        return false;

    }
}
