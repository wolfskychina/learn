package leetcode.a800;
/**
 * 转换字符串所需要的最小步数
 * 每次可以转换3个连续的字符，将字符串中的‘x’转成‘o'
 * {greedy}
 */
public class _2027Solution {
   
    public int minimumMoves(String s) {

        char[] arr = s.toCharArray();
        int i=0;
        int count =0;
        while(i<arr.length){
            if(arr[i]!='X')
            { i++;
                continue;}
            count++;
            i+=3;
        }
        return count;
    }
}
