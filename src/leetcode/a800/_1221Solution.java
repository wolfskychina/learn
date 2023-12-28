package leetcode.a800;
/**
 * 平衡字符串能够拆成的最多的平衡子串
 */
public class _1221Solution {
   
    /**
     * {easy},{greedy}
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {

        int count =0;
        int rnum = 0;
        int lnum=0;
        int idx =0;
        while(idx<s.length()){
            if(s.charAt(idx++) == 'L') lnum++;
            else rnum++;
            if(lnum==rnum){
                count++;
                lnum=0;
                rnum=0;
            }

        }
        return count;
    }
}
