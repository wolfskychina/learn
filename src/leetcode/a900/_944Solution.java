package leetcode.a900;
/**
 * 删列造序
 * {easy}
 */
public class _944Solution {
   
    public int minDeletionSize(String[] strs) {
        int count=0;
        for(int i=0;i<strs[0].length();i++){

            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i))
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
