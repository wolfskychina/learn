package leetcode.a2000;

/**
 * 统计道路上的碰撞次数
 * {stack}
 */
public class _2211Solution {

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
                    i--;
                    res++;
                }
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
