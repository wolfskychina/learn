package leetcode.a2000;
/**
 * 最多单词的句子
 * {easy}
 */
public class _2114Solution {
   
    public int mostWordsFound(String[] sentences) {

        int max = 0;
        for(String str:sentences){

            String[] arr = str.split(" ");
            max = Math.max(max,arr.length);
        }

        return max;
    }
}
