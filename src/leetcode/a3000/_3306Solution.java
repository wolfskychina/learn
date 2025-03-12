package leetcode.a3000;

/**
 * 元音辅音字符串计数
 * 同3305，测试数据集更大
 * {sliding window}
 */
public class _3306Solution {

    /**
     * 使用数组统计字符出现频率，更快
     * @param word
     * @param k
     * @return
     */
    public long countOfSubstrings(String word, int k) {
        boolean isVow[] = new boolean[128];
        int vow[] = { 'a', 'e', 'i', 'o', 'u' }, f[] = new int[128];
        for (int c : vow) {
            isVow[c] = true;
        }
        int vcount = 0, ccount = 0, extraLeft = 0;
        long ans = 0;
        char car[] = word.toCharArray();
        for (int i = 0, j = -1, n = car.length; i < n; i++) {
            f[car[i]]++;
            if (isVow[car[i]]) {
                if (f[car[i]] == 1)
                    vcount++;
            } else
                ccount++;
            while (j < i && (ccount > k)) {
                f[car[++j]]--;
                if (isVow[car[j]]) {
                    if (f[car[j]] == 0)
                        vcount--;
                } else {
                    ccount--;
                }
                extraLeft = 0;
            }
            while (ccount == k && vcount == 5 && isVow[car[j + 1]] && f[car[j + 1]] > 1) {
                f[car[++j]]--;
                extraLeft++;
            }

            if (vcount == 5 && ccount == k) {
                ans += 1 + extraLeft;
            }
        }
        return ans;
    }
}
