package leetcode.a2000;
/**
 * 找出叠涂元素
 */
public class _2661Solution {


    /**
     * {index} 建立反向查找索引
     * @param arr
     * @param mat
     * @return
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int[] m = new int[mat.length];
        int[] n = new int[mat[0].length];
        int[][] map = new int[arr.length + 1][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                map[mat[i][j]][0] = i;
                map[mat[i][j]][1] = j;
            }
        }

        int i = 0;
        while (i < arr.length) {

            m[map[arr[i]][0]]++;
            n[map[arr[i]][1]]++;

            if (m[map[arr[i]][0]] == mat[0].length ||
                    n[map[arr[i]][1]] == mat.length)
                return i;

            i++;
        }

        return i;
    }
}
