package leetcode.a800;
/**
 * 检查二进制字符串字段
 * {easy}
 */
public class _1784Solution {
   
    public boolean checkOnesSegment(String s) {

        char[] arr = s.toCharArray();
        int i=0;
        while(i<arr.length&&arr[i]=='1'){
            i++;
        }
        if(i==arr.length) return true;
        while(i<arr.length&&arr[i]=='0'){
            i++;
        }
        if(i==arr.length) return true;
        return false;
    }
}
