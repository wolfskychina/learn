package leetcode.a1000;
/**
 * 拥有最多人口的年份
 * {easy}
 */
public class _1854Solution {
   
    public int maximumPopulation(int[][] logs) {
        int count[] = new int[101];
        for(int [] log:logs){
            
            for(int i=log[0];i<log[1];i++){
                count[i-1950]++;
            }
        }
        int maxYear =0;
        int maxidx = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>maxYear){
                maxYear = count[i];
                maxidx = i;
            }
        }
        return maxidx+1950;
    }
}
