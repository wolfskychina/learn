package leetcode.a1100;
/**
 * 特殊打字机输入word所需要的时间
 * {easy}
 */
public class _1974Solution {
   
    public int minTimeToType(String word) {

            int sum  = word.length();

            char[] arr = word.toCharArray();

            for(int i=0;i<arr.length-1;i++){

                sum+=Math.min(Math.abs(arr[i]-arr[i+1]),
                26-Math.abs(arr[i]-arr[i+1]));
               
            }
            sum+=Math.min(Math.abs(arr[0]-'a'),
                26-Math.abs(arr[0]-'a'));

            return sum;
    }

    public static void main(String[] args){

        _1974Solution so = new _1974Solution();
        so.minTimeToType("bza"); //
    }

}
