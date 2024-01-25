package leetcode.a800;

import java.util.HashSet;
import java.util.Set;

/**
 * 唯一的摩尔斯电码的数量
 * {easy}
 */
public class _804Solution {
   
    private static String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();
        for(String str:words){
            StringBuilder sb = new StringBuilder();
            for(char c:str.toCharArray()){
                sb.append(map[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
