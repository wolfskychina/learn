package leetcode.a1100;

import java.util.HashSet;
import java.util.Set;
/**
 * 统计一致字符串的数目
 * {easy}
 */
public class _1684Solution {
   
    public int countConsistentStrings(String allowed, String[] words) {

        Set<Character> set = new HashSet<>();
        for(char c:allowed.toCharArray()){
            set.add(c);
        }
        int count=0;
        for(String str:words){
            boolean ifallow = true;
            for(char c:str.toCharArray()){
                if(!set.contains(c)){
                    ifallow = false;
                    break;
                }
            }
            if(ifallow)
                count++;
        }
        return count;
    }
}
