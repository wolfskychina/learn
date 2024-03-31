package leetcode.a2000;

import java.util.Arrays;

/**
 * 能否删除一个字符使得其他的字符出现的频率完全一样
 * 
 */
public class _2423Solution {

    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++)
            cnt[word.charAt(i) - 'a']++;

        Arrays.sort(cnt);
        int start = 0;
        while (cnt[start] == 0)
            start++;

        for (int i = start; i < 26; i++) {
            cnt[i]--;
            if (same(cnt, start))
                return true;
            cnt[i]++;
        }

        return false;
    }

    private boolean same(int[] nums, int start) {
        while (nums[start] == 0)
            start++;

        int num = nums[start];
        for (int i = start; i < nums.length; i++)
            if (num != nums[i])
                return false;

        return true;
    }

}
