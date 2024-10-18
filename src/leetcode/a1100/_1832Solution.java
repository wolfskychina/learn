package leetcode.a1100;
/**
 * 句子是否为全字母句子
 */
public class _1832Solution {
   
    public boolean checkIfPangram(String sentence) {

        int [] arr = new int[26];
        for(char c:sentence.toCharArray()){

            arr[c-'a']++;
        }
        for(int i=0;i<26;i++){

            if(arr[i]==0) 
                return false;
        }

        return true;
    }
}
