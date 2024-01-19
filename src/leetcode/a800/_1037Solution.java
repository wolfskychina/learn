package leetcode.a800;
/**
 * 判断3个点是否在一条直线上
 * {easy}
 */
public class _1037Solution {
   
    public boolean isBoomerang(int[][] p) {

        if((p[0][0]==p[1][0]&&p[0][1]==p[1][1])||
            (p[0][0]==p[2][0]&&p[0][1]==p[2][1])||
            (p[1][0]==p[2][0]&&p[1][1]==p[2][1])){
                return false;
        }
    
        if(((p[0][1] - p[1][1]) * (p[0][0]-p[2][0]))
         == ((p[0][1]-p[2][1]) * (p[0][0]-p[1][0])))
            return false;
        else 
            return true;
    }
}
