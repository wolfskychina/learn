package leetcode.a800;
/**
 * 写字符串需要的行数
 * {easy}
 */
public class _806Solution {
   
    public int[] numberOfLines(int[] widths, String s) {

        int line =0;
        int idx =0;
        char[] arr = s.toCharArray();
        int i=0;
        while(i<arr.length){

            line++;
            idx =0;
            while(i<arr.length&&idx+widths[arr[i]-'a']<=100){
                idx += widths[arr[i]-'a'];
                i++;
            }

        }
        return new int[]{line,idx};

    }
}
