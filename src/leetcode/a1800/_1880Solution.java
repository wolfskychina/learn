package leetcode.a1800;
/**
 * 检查两个某个单词是否等于两个单词之和
 * {easy}
 */
public class _1880Solution {
    
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        int first = compute(firstWord);
        int secound =compute(secondWord);
        int tar = compute(targetWord);
        return first  + secound == tar;
    }

    private int compute(String str){
        int res= 0;
        for(char c:str.toCharArray()){

            res = res*10+(c-'a');
        }
        return res;
    }
}
