package leetcode.a800;
/**
 * 反转单词前缀
 * {easy}
 */
public class _2000Solution {
   
    public String reversePrefix(String word, char ch) {
        int i=0;
        for(;i<word.length();i++){
            if(ch==word.charAt(i))
                break;
        }
        if(i==word.length())
            return word;
        StringBuilder sb = new StringBuilder();
        return sb.append(word.substring(0, i+1)).reverse().append(word.substring(i+1)).toString();
    }
}
