package leetcode.a400;

/*
 * 给一个可以随机生成1-7的方法，设计一个可以随机返回1-10的方法
 */
public class _470Solution {

    int[][] map = new int[8][8];
    int k = 1;
    int kk = 1;

    public _470Solution() {
        // 使用1-10等概率出现的数组
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7 && kk <= 40; j++) {
                kk++;
                map[i][j] = k;
                k++;
                if (k == 11)
                    k = 1;
            }
        }
    }

    public int rand10() {

        int i = 7;
        int j = 7;
        // 如果出现无效坐标，则直接忽略
        while (i > 6 || (i == 6 && j > 5)) {
            i = rand7();
            j = rand7();
        }
        return map[i][j];

    }

    public int rand10_2() {
        int col, row, index;
        do {
            col = rand7();
            row = rand7();
            index = col + (row - 1) * 7;
        } while (index > 40);
        return 1 + (index - 1) % 10;
    }

    private int rand7() {
        return 0;
    }
}
