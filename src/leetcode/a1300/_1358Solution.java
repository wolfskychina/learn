package leetcode.a1300;
/**
 * 包含所有三种字符的子串的数量
 * {two pointers}
 */
public class _1358Solution {
   
    /**
     * 关键在于避免重复计算子数组
     * 左侧指针只向右移动，保证遍历到的子数组不会重复
     */
    public int numberOfSubstrings(String s) {
        int answer=0;
        //abc 的计数
        int[] count=new int[3];
        //窗口左沿
        int start=0;
        //窗口右沿
        for(int end=0;end<s.length();end++){
            char charAtEnd=s.charAt(end);
            count[charAtEnd-'a']++;
            while(count[0]>=1 && count[1]>=1 && count[2]>=1){
                answer+=s.length()-end;
                char charAtStart=s.charAt(start);
                count[charAtStart-'a']--;
                start++;
            } 
        }
        return answer;
    }
}
