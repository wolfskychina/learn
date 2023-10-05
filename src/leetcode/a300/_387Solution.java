package leetcode.a300;
/**
 * 返回字符串的第一个非重复字符
 */
public class _387Solution {

        public int firstUniqChar(String s) {
            int freq [] = new int[26];
            int len = s.length();
            for(int i = 0; i < len; i ++)
            {
                   
                         freq [s.charAt(i) - 'a'] ++;
             }   
            for(int i = 0; i < len; i ++)
            {
                    if(freq [s.charAt(i) - 'a'] == 1)
                    {return i;}
             }  
            
            return -1;
        }

}
