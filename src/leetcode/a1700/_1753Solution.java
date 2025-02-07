package leetcode.a1700;

/**
 * 移除石子的最大得分
 * 三组石子，每次如果有两组不为0，可以各去掉一个石子，得1分
 * 问能够取得得最大得分
 * {greedy},{TODO}
 */
public class _1753Solution {

    public int maximumScore(int a, int b, int c) {

        int max = Math.max(a, b);
        max = Math.max(max, c);
        int sum = a + b + c;
        if (max > sum - max) {
            return sum - max;
        } else {
            return sum / 2;
        }
    }

    /**
     * 首先a,b,c进行升序排序
     * 如果c>=a+b，很容易知道我们最多只能把a,b的石头全部匹配完，因此返回a+b即可
     * 如果a+b>c，为了让石头尽可能多匹配几次。我们先让a和b去匹配，
     * 一旦a+b的和小于c的时候，就可以用c把他们全部匹配掉。
     */
}
