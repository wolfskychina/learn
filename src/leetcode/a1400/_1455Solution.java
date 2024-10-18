package leetcode.a1400;
/**
 * 关键词是否是句子中单词的前缀
 * {easy}
 */
public class _1455Solution {
   
    public int isPrefixOfWord(String sentence, String searchWord) {

        String [] sen = sentence.split(" ");
        int i=1;
        for(String str:sen){

            if(str.startsWith(searchWord))
                return i;
            i++;
        }
        return -1;
    }
}
