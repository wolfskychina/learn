package leetcode.a1100;
/**
 * 统计最大组的数目
 */
public class _1399Solution {

    /**
     * {easy}
     * @param n
     * @return
     */
    public int countLargestGroup(int n) {

        int count[] = new int[37];
        for (int i = 1; i <= n; i++) {
            count[sum(i)]++;
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        int res = 0;
        for (int i : count) {
            if (i == max)
                res++;
        }
        return res;
    }

    private int sum(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        return res;
    }

    public int countLargestGroup1(int n) {
        int[] cnt = new int[9 * 4 + 1];
        int len = 0;
        r: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        cnt[i + j + k + l]++;
                        if (len++ == n) {
                            break r;
                        }
                    }
                }
            }
        }
        if (n == 10000)
            cnt[1]++;
        int ans = 0, max = cnt[1];
        for (int i = 1; i < 37; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                ans = 1;
            } else if (max == cnt[i]) {
                ans++;
            }
        }
        return ans;
    }
}
