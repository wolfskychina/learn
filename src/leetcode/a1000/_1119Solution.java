package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;
/**
 * 删除字符串中的元音字符
 * {easy}
 */
public class _1119Solution {
   
    public String removeVowels(String s) {
        char [] arr = s.toCharArray();
        int i=0;
        int j=0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while(j<arr.length){
            if(!set.contains(arr[j])){
                arr[i++]=arr[j];
            }
            j++;
        }
        return new String(arr, 0, i);
    }
}
