package leetcode.a3000;
/**
 * 统计前后缀的下标对
 * {easy}
 */
public class _3042Solution {
   
    public int countPrefixSuffixPairs(String[] words) {

        int count=0;
        for(int i=0;i<words.length-1;i++){
    
            for(int j=i+1;j<words.length;j++){
    
                if(words[j].startsWith(words[i])&&words[j].endsWith(words[i]))
                    count++;
            }
        }
    
        return count;
    
        }
}
