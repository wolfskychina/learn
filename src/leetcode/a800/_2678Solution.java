package leetcode.a800;
/**
 * 统计老年人的数量
 */
public class _2678Solution {
   
    /**
     * {easy}
     * @param details
     * @return
     */
    public int countSeniors(String[] details) {
        int count =0;
        for(String str:details){
            if(Integer.valueOf(str.substring(11,13))>60){
                count++;
            }
       }

       return count;
    }
}
