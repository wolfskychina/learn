package leetcode.a1900;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有的农场块
 * {bfs},{easy}
 */
public class _1992Solution {

    public int[][] findFarmland(int[][] land) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {

                if (land[i][j] == 1) {

                    int m = i;
                    int n = j;
                    for (; m < land.length && land[m][j] == 1; m++) {
                        for (n = j; n < land[0].length && land[m][n] == 1; n++) {
                            land[m][n] = 0;
                        }

                    }
                    list.add(new int[] { i, j, m - 1, n - 1 });
                }
            }
        }
        /*
         * int res[][] = new int[list.size()][4];
         * for(int i=0;i<res.length;i++){
         * res[i] = list.get(i);
         * }
         * 
         * return res;
         */
        return list.toArray(new int[list.size()][]);
    }
}
