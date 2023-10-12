package leetcode.a400;

import java.util.HashMap;
import java.util.Map;

/**
 * 423. Reconstruct Original Digits from English
 */
public class _423Solution {

    public String originalDigits(String s) {

        Map<Character, char[]> map = new HashMap<>();
        char [] six = {'s','i','x'};
        map.put('x', six);
        char [] eight = {'e','i','g','h','t'};
        map.put('g',eight);
        char [] zero = {'z','e','r','o'};
        map.put('z',zero);
        char [] two = {'t','w','o'};
        map.put('z',two);
        char[] four = {'f','o','u','r'};
        map.put('u',four);
        char[] one = {'o','n','e'};
        map.put('o',one);
        char[] three = {'t','h','r','e','e'};
        map.put('t', three);
        char[] five = {'f','i','v','e'};
        map.put('f',five);
        char[] seven = {'s','e','v','e','n'};
        map.put('s',seven);
        char[] nine ={'n','i','n','e'};
        map.put('i',nine);

        char[] seq = {'x','g','z','w','u','o','t','f','s','i'};
        

        int [] origin = new int [26];

        for(int i=0;i<s.length();i++){

            origin[s.charAt(i)-'a'] ++;
        }

        for(int i=0;i<seq.length;i++){
           
            int times  = origin[seq[i]-'a'];
            char [] arr = map.get(seq[i]);
            // found times * 
            while(times!=0){
                for(int j=0;j<arr.length;j++){
                    origin[arr[i]-'a']--;
                }
            }

        }



        

    }
   
    
}
