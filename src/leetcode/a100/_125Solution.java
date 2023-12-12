package leetcode.a100;

import java.util.ArrayList;
import java.util.List;
/**
 * 判断一个加工过的字符串是不是回文串
 * {easy}
 */
public class _125Solution {
   
    public boolean isPalindrome(String s) {

        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){

            if((c>='a'&&c<='z')||(c>='0'&&c<='9'))
                list.add(c);
            else if(c>='A' && c<='Z')
                list.add((char)('a'+ c-'A'));
        }

        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(list.size()-1-i))
                return false;
        }
        return true;

    }
}
