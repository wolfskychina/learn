package leetcode.a2000;

/**
 * 由T和F两种字符组成的字符串中包含k个T或者k个F的最长子串的长度是多少
 */
public class _2024Solution {
  
    /**
     * {sliding window}
     * T和F的ascii码倒数第二位不同
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] s = answerKey.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int right = 0; right < s.length; right++) {
            cnt[s[right] >> 1 & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s[left++] >> 1 & 1]--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
