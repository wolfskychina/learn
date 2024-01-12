package leetcode.a800;
/**
 * 拼车方案是否可行
 * 对于一个capacity空座的车和沿途上下车旅客的方案
 */
public class _1094Solution {
   
    /**
     * {prefix sum}
     */
    public boolean carPooling(int[][] trips, int capacity) {

        int slice[] = new int[1001];
        for(int[] trip:trips){
            slice[trip[1]]+=trip[0];
            slice[trip[2]]-=trip[0];
        }

        for(int i=1;i<slice.length;i++){
            slice[i]+=slice[i-1];
        }

        for(int i:slice){
            if(i>capacity)
                return false;
        }
        return true;
    }
}
