package leetcode.a800;
/**
 * 检查字符串能否由字符串数组中的字符串依次拼接而成
 * {easy}
 */
public class _1961Solution {
   
    public boolean isPrefixString(String s, String[] words) {

        int len = s.length();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(sb.length()<len&&i<words.length){

            sb.append(words[i]);
            i++;
        }
        if(sb.length()!=len||!sb.toString().equals(s))
            return false;
        return true;

    }
}
