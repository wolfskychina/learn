package leetcode.a1700;
/**
 * 交替合并字符串
 */
public class _1768Solution {
   
    /**
     * {easy}
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {

        int i=0;
        int j =0;
        StringBuilder sb = new StringBuilder();
        while(i<word1.length()&&j<word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));

        }
        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
