package leetcode.a1200;
/**
 * 独一无二的出现次数
 */
public class _1207Solution {
   
    /**
     * {counting sort}
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {

        int count1 [] = new int[2001];
        for(int i:arr){
            count1[i+1000]++;
        }
        int count2 [] = new int[1001];
        for(int i:count1){

            count2[i]++;
        }
        for(int i=1;i<count2.length;i++){
            if(count2[i]>1)
                return false;
        }
        return true;
    }
}
