package leetcode.a800;
/**
 * 解码异或后的数组
 * {easy}
 */
public class _1720Solution {
   
    public int[] decode(int[] encoded, int first) {

        int[] res = new int[encoded.length+1];
        res[0]= first;
        for(int i=1;i<res.length;i++){
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;

    }
}
