package leetcode.a900;

import java.util.HashMap;
import java.util.Map;
/**
 * 判断单词在外星文词典中是否有序
 */
public class _953Solution {

    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        int n = 0;
        for (char c : order.toCharArray()) {
            map.put(c, n++);
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i].startsWith(words[i - 1]))
                continue;
            if (words[i - 1].startsWith(words[i]))
                return false;
            if (compare(words[i - 1], words[i],map) > 0)
                return false;
        }
        return true;
    }

    private int compare(String str1, String str2,Map<Character,Integer> map) {
        if (str1.equals(str2))
            return 0;

        if (str1.startsWith(str2))
            return -1;
        if (str2.startsWith(str1))
            return 1;

        int n = Math.min(str1.length(),str2.length());
        for(int i=0;i<n;i++){
            int c1 = map.get(str1.charAt(i));
            int c2 = map.get(str2.charAt(i));
            if(c1==c2) continue;
            if(c1<c2) return -1;
            return 1;

        }
        return 0;
    }

    /**
     * 模拟hashmap更快
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted1(String[] words, String order) {
        int n = order.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean flag = false;
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                if(arr[words[i].charAt(j) - 'a'] < arr[words[i - 1].charAt(j) - 'a'])return false;
                else if(arr[words[i].charAt(j) - 'a'] > arr[words[i - 1].charAt(j) - 'a']){
                    flag = true;
                    break;
                }
                // 字符相等的情况下继续循环比较
            }
            if(!flag){
                if(words[i].length() < words[i - 1].length())return false;
            }
        }
        return true;
    }
}
