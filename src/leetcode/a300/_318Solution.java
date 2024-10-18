package leetcode.a300;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 一个字符串数组，求数组中任意两个没有相同元素的字符串的长度相乘的最大值
 * {bit manipulation}
 */
public class _318Solution {

    /**
     * 利用mask数组保存字符串的特征码
     * 如果两个特征码&操作==0，那么说明没有相同字符
     * 32位长度的整形能够保存26位小写字符
     * 
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;

    }

    /**
     * 优化的方案，如果两个字符串组成的字符相同，那么他们的masks掩码特征相同
     * 所以可以只保存长度最长的那个字符串的长度
     * 
     * @param words
     * @return
     */
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int mask = 0;
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }

}
