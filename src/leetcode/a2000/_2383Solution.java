package leetcode.a2000;

/**
 * 赢得比赛所需要的最少训练次数
 * {easy}
 */
public class _2383Solution {

    public int minNumberOfHours(int eng, int exp, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; ++i) {
            int e = energy[i];
            if (eng <= e) {
                ans += e + 1 - eng;
                eng = e + 1; // 补到刚好超过
            }
            eng -= e;
            e = experience[i];
            if (exp <= e) {
                ans += e + 1 - exp;
                exp = e + 1;// 补到刚好超过
            }
            exp += e;
        }
        return ans;
    }

    public static void main(String[] args) {

        _2383Solution so = new _2383Solution();
        int[] energy = { 1, 4, 3, 2 };
        int[] exp = { 2, 6, 3, 1 };
        so.minNumberOfHours(5, 3, energy, exp);
    }
}
