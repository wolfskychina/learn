package leetcode.a800;
/**
 * 数组1和-1之间的0的最大数量
 * {easy}
 */
public class _2511Solution {
   
    public int captureForts(int[] forts) {

        int l=0;
        int max =0;
        while(l<forts.length){

            while(l<forts.length&&forts[l]!=0){
                l++;
            }
            int low = l-1;
            if(l==forts.length) break;

            while(l<forts.length&&forts[l]==0){
                l++;
            }
            if(l==forts.length) break;

            if(low>=0 && forts[l]!=forts[low]) {
                max = Math.max(max,l-1-low);
            }
        }

        return max;
    }
}
