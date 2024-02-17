package leetcode.a800;
/**
 * 0和1组成的二进制串哪种连续字符串更长
 * {easy}
 */
public class _1869Solution {
   
    public boolean checkZeroOnes(String s) {

        char[] arr = s.toCharArray();
        int i=0;
        int max[] = new int[2];
        while(i<arr.length){

            int l =i;
            while(l<arr.length-1&&arr[l+1]==arr[l])
                l++;
            max[arr[i]-'0'] = Math.max(max[arr[i]-'0'], l-i+1);
            i=l+1;
        }
        return max[1]>max[0];
    }
}
