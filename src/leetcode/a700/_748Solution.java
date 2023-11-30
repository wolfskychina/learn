package leetcode.a700;
/**
 * 最短补全单词
 */
public class _748Solution {

    /**
     * {easy}
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] pattern = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                pattern[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                pattern[c - 'a']++;
            }
        }

        int minlen = 16;
        int minidx = -1;
        for (int i = 0; i < words.length; i++) {

            int[] tmp = new int[26];
            for (char c : words[i].toCharArray()) {
                tmp[c - 'a']++;
            }
            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if (tmp[j] < pattern[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid && words[i].length() < minlen) {
                minlen = words[i].length();
                minidx = i;
            }

        }

        return words[minidx];

    }
}
