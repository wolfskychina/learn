package leetcode.a2000;

import java.util.Arrays;

/**
 * 子字符串的最少划分，要求每个子串里面都不能有重复的字符
 * {greedy}
 */
public class _2405Solution {
   
    public int partitionString(String s) {
        
        char ss[] = s.toCharArray();
        int count[] = new int[26];
        int res =1;
        for(int i=0;i<ss.length;i++){
            if(count[ss[i]-'a']>0){
                res++;
                Arrays.fill(count,0);
            }
            count[ss[i]-'a']++;
           
        }
        return res;
    }

    /**
     * 优化使用一个整数来保存26个字符是否出现过
     * 更快
     * {bit manuplation}
     * @param s
     * @return
     */
    public int partitionString1(String s) {
        int ans = 1;
        int visited = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if ((visited & (1 << index)) != 0) {
                ans++;
                visited = 0;
            }
            visited |= 1 << index;
        }
        return ans;       
    }
}
