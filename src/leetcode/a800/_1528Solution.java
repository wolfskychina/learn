package leetcode.a800;
/**
 * 重新排列字符串
 * {easy}
 */
public class _1528Solution {
   
    public String restoreString(String s, int[] indices) {

        char[] op = new char[indices.length];
        for(int i=0;i<indices.length;i++){
            op[indices[i]] = s.charAt(i);
        }
        return String.valueOf(op);
    }
}
