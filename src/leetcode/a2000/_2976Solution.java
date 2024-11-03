package leetcode.a2000;

/**
 * 单词转换的最小成本
 * {graph},{floyd-warshall}
 */
public class _2976Solution {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        long[][] matrix = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                matrix[i][j] = Long.MAX_VALUE;
            }
        }

        for (int i = 0; i < original.length; i++) {
            matrix[original[i] - 'a'][changed[i] - 'a'] = Math.min(matrix[original[i] - 'a'][changed[i] - 'a'],
                    cost[i]);
        }

        for (int k = 0; k < 26; k++) {

            for (int i = 0; i < 26; i++) {
                if (matrix[i][k] == Long.MAX_VALUE)
                    continue;
                for (int j = 0; j < 26; j++) {
                    if (matrix[k][j] == Long.MAX_VALUE)
                        continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        char[] ss = source.toCharArray();
        char[] tt = target.toCharArray();
        long res = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == tt[i])
                continue;
            if (matrix[ss[i] - 'a'][tt[i] - 'a'] == Long.MAX_VALUE)
                return -1;
            else
                res += matrix[ss[i] - 'a'][tt[i] - 'a'];
        }

        return res;
    }
}
