package leetcode.a700;

import java.util.HashSet;
import java.util.Set;
/**
 * 将字符串s按照order里面的字母相对顺序进行重新排序
 */
public class _791Solution {
   
    /**
     * 注意order里面的字符不一定是s里面的所有出现过的字符
     * {string}
     * @param order
     * @param s
     * @return
     */
    public String customSortString(String order, String s) {

        int count[] = new int[26];
        for(char c:s.toCharArray()){

            count[c-'a'] ++;
        }

        Set<Character> set = new HashSet<>();
        for(int i=0;i<26;i++){
            set.add((char)(i+'a'));
        }
        StringBuilder sb = new StringBuilder();
        for(char c:order.toCharArray()){
            set.remove(c);
            for(int i=0;i<count[c-'a'];i++){
                sb.append(c);
            }
        }
        for(char c:set){
            for(int i=0;i<count[c-'a'];i++){
                sb.append(c);
            } 
        }
        return sb.toString();
        
    }
}
