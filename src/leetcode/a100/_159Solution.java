package leetcode.a100;
/**
 * 至多包含两个不同字符的最长子串
 * {two pointers}
 */
public class _159Solution {
   
    public int lengthOfLongestSubstringTwoDistinct(String s) {        
        int count = 0;
        int start = 0, end = 0;
        int[] freq = new int[128];
        int max = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(freq[c] == 0){
                count++;
            }
            freq[c]++;
            while(count > 2){
                char d = s.charAt(start);
                freq[d]--;
                if(freq[d] == 0){
                    count--;
                }
                start++;
            }
            max = Math.max(end - start + 1, max);
            end++;
        }
        return max;
    }
}
