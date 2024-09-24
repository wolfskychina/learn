package leetcode.a1000;
/**
 * 形成字符串的最短路径
 * 通过不断的拼接source中的子序列，最终组成target字符串所需要的最少拼接次数
 * 如果无法拼接成target，返回-1
 * {two pointers}
 */
public class _1055Solution {

    public int shortestWay(String source, String target) {

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int idxT = 0;
        int num = 0;
        while (idxT < target.length()) {

            boolean found = false;
            for (int i = 0; idxT < target.length() && i < s.length; i++) {

                if (s[i] == t[idxT]) {
                    found = true;
                    idxT++;
                }
            }
            if (found == false)
                return -1;
            num++;
        }
        return num;

    }

}
