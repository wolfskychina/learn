package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 字符串前后半的元音字符总数是否相同
 * {easy}
 */
public class _1704Solution {
   
    
    Set<Character> set;

    public _1704Solution(){

        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

    }
    public boolean halvesAreAlike(String s) {

        char[] arr = s.toCharArray();
        int count1 =0;
        int count2 = 0;
        for(int i=0;i<arr.length/2;i++){
            if(set.contains(arr[i]))
                count1++;
            if(set.contains(arr[arr.length-1-i]))
                count2++;
        }
        return count1==count2;

    }
}
