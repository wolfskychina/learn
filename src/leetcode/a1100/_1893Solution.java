package leetcode.a1100;

/**
 * 检查是否区间内的所有整数都被字段覆盖了
 * {easy}
 */
public class _1893Solution {
   
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean [] cover = new boolean[right-left+1];
        for(int[] range:ranges){

            if(range[0]>right||range[1]<left)
                 continue;
            int l = Math.max(left,range[0]);
            int r = Math.min(right,range[1]);
            for(int i=l;i<=r;i++){
                cover[i-left]=true;
            }

        }

        for(boolean f:cover){
            if(!f) return false;
        }
        return true;

    }
}
