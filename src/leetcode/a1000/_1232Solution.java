package leetcode.a1000;
/**
 * 判断一组点是否在一条直线上
 * {easy}
 */
public class _1232Solution {
   
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2) return true;
        int l = coordinates[1][0]-coordinates[0][0];
        int r = coordinates[1][1]-coordinates[0][1];
        for(int i=2;i<coordinates.length;i++){
            if(l*(coordinates[i][1]-coordinates[0][1])!=r*(coordinates[i][0]-coordinates[0][0]))
                return false;
        }
        return true;
    }
}
