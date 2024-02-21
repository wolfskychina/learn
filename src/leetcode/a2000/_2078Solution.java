package leetcode.a2000;
/**
 * 两栋颜色不同且间隔最远的房子的距离
 * {easy}
 */
public class _2078Solution {
   
    public int maxDistance(int[] colors) {

        for(int len =colors.length-1;len>=1;len--){

            for(int i=0;i+len<colors.length;i++){

                if(colors[i]!=colors[i+len])
                    return len;
            }
        }

        return 1;
    }
}
