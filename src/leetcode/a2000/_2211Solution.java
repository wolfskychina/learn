package leetcode.a2000;

/**
 * 统计道路上的碰撞次数
 * {stack},{two pointers}
 */
public class _2211Solution {

    /**
     * 模拟栈
     * 栈里面只记录未碰撞的R和已经碰撞的最右侧的S
     * 如果遇到和栈顶的R碰撞，就一直出栈
     * @param directions
     * @return
     */
    public int countCollisions(String directions) {

        char[] d = directions.toCharArray();

        int i = 0;
        int res = 0;
        for (int j = 0; j < directions.length(); j++) {

            d[i] = d[j];
            if (d[i] == 'R') {

                i++;

            } else if (d[i] == 'S') {
                while (i > 0 && d[i - 1] == 'R') {
                    // 出栈操作
                    i--;
                    res++;
                }
                // 将碰撞点入栈做标记
                d[i] = 'S';
                i++;

            } else {

                if (i > 0 && d[i - 1] == 'S') {
                    res++;
                    // i--;
                } else if (i > 0 && d[i - 1] == 'R') {
                    res += 2;
                    d[i - 1] = 'S';
                    while (i - 2 >= 0 && d[i - 2] == 'R') {
                        i--;
                        res++;
                    }
                    d[i - 1] = 'S';
                    i++;
                } else {
                    i++;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {

        _2211Solution so = new _2211Solution();
        String directions = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        so.countCollisions(directions);
    }
}
