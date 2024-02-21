package leetcode.a2000;
/**
 * 二进制字符串中类似000111模式的最长字符串，0和1的数量相同
 * {easy}
 */
public class _2609Solution {
   
    public int findTheLongestBalancedSubstring(String s) {

        char array[] = s.toCharArray();
        int l=0;
        int max = 0;
        while(l<array.length){
            int count=0;
            while(l<array.length&&array[l]=='0'){
                l++;
                count++;
            }
            int remain =count;
            while(l<array.length&&array[l]=='1'&&remain>0){
                l++;
                remain--;
            }
            if(l<=array.length){
                max = Math.max(max, 2*(count-remain));
            }
            // 最后很容易忽略跳过开头的连续的1
            while(l<array.length&&array[l]=='1')
                l++;
        }

        return max;
    }

    public static void main(String[] args){

        _2609Solution so = new _2609Solution();
        String str = "01000111";
        so.findTheLongestBalancedSubstring(str);
    }
}
