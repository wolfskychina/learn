package leetcode.a500;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _524Solution {

    /**
     * 按照长度排序后逐个判断是不是子序列,速度比较慢
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }

        });

        for(String str:dictionary){

            if(str.length()>s.length()){
                break;
            }else if(str.equals(s)){
                return str;
            }else{

                int i=0;
                int j=0;
                while(i<str.length()&&j<s.length()){

                    if(str.charAt(i) == s.charAt(j)){
                        i++;
                    }
                    j++;
                }
                if(i==str.length()) return str;
            }
        }

        return "";
    }
}
