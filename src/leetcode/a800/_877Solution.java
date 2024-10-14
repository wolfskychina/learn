package leetcode.a800;

/**
 * 超级鸡蛋掉落问题
 * 给k个鸡蛋，至少要判断多少次才能从n层楼中找到最大安全高度
 * {hard},{dp}
 */
public class _877Solution {

    /**
     * 递推关系难以考虑到
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        int[] f = new int[k + 1];
        for (int i = 1;; i++) {
            for (int j = k; j > 0; j--) {
                f[j] += f[j - 1] + 1;
            }
            if (f[k] >= n) {
                return i;
            }
        }
    }

}
