package leetcode.a1000;
/**
 * 作为子字符串出现在单词中的字符串的数目
 * {easy}
 */
public class _1967Solution {
   
    public int numOfStrings(String[] patterns, String word) {

        int count =0;
        for(String str:patterns){
            if(str.length()>word.length())
                continue;
            if(word.contains(str))
                count++;
        }
        return count;
    }
}
