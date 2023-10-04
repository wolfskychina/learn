package leetcode.a300;
/**
 * 杂志上的字母能否拼成赎金信
 * #EASY
 */
public class _383Solution {
   
    public boolean canConstruct(String ransomNote, String magazine) {

        int [] magStr = new int[26];
        for(char c:magazine.toCharArray()){

            magStr[c-'a']++;
        }

        for(char c:ransomNote.toCharArray()){
            magStr[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(magStr[i]<0)
            return false;
        }

        return true;

    }
}
