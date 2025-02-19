package leetcode.a1200;

import java.util.HashMap;
import java.util.Map;

/**
 * 包含最多maxLetter个不重复字符的子串出现的最大次数
 * {String},{sliding window}
 */
public class _1297Solution {

    /**
     * 满足条件的长的串重复它的满足条件的子串也一定重复
     * 所以只需要考虑满足条件的最短子串即可
     * 
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> freqMap = new HashMap<>(); // 哈希表用于记录子字符串的频率
        int maxFreq = 0; // 最大频率初始值为0

        // 遍历字符串，确保子字符串长度2为minSize
        for (int i = 0; i <= n - minSize; i++) {
            String window = s.substring(i, i + minSize); // 获取当前窗口的子字符串
            int[] count = new int[26]; // 记录每个字符出现次数的数组
            int uniqueNum = 0; // 当前子字符串中不同字符的数量

            // 统计当前子字符串中字符的出现次数
            for (int j = 0; j < minSize; j++) {
                if (count[window.charAt(j) - 'a'] == 0) {
                    uniqueNum++; // 新出现的字符
                }
                count[window.charAt(j) - 'a']++; // 更新字符计数
            }

            // 检查当前子字符串是否符合条件
            if (uniqueNum <= maxLetters) {
                String key = window;
                int freq = freqMap.getOrDefault(key, 0) + 1; // 更新子字符串的出现频率
                freqMap.put(key, freq); // 更新哈希表
                maxFreq = Math.max(maxFreq, freq); // 更新最大频率
            }
        }

        return maxFreq;
    }
}
