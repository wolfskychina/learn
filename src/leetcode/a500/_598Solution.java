package leetcode.a500;
/**
 * 最大数的个数
 * {easy}
 */
public class _598Solution {
   
    public int maxCount(int m, int n, int[][] ops) {

        int l =m;
        int r =n;

        for(int [] op:ops){
            l = Math.min(op[0],l);
            r = Math.min(op[1],r);
        }

        return l*r;

    }
}
