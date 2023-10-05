package leetcode.a300;
/**
 * 两个字符串s,t， 其中t是由s打乱顺序后插入一个字符形成的
 * 求这个插入的字符
 */
public class _389Solution {
   
    public char findTheDifference(String s, String t) {
        int pattern[] = new int[26];
        for(char c:s.toCharArray()){
            pattern[c-'a']++;
        }

        for(char c:t.toCharArray()){
            pattern[c-'a'] --;
            if(pattern[c-'a'] ==-1)
                return c;
        }

        return 'a';

    }
}
