package leetcode.a1000;
/**
 * 检查是否所有字符出现次数均相等
 * {easy}
 */
public class _1941Solution {
   
    public boolean areOccurrencesEqual(String s) {

        int count[] = new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        int only = 0;
        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            if(only==0)
                only =count[i];
            else if(count[i]!=only)
                return false;
        }
        return true;
    }
}
