package leetcode.a1100;
/**
 * 字符串中第二大的数字字符
 * {easy}
 */
public class _1796Solution {
   
    public int secondHighest(String s) {
        int[] count = new int[10];
        for(char i:s.toCharArray()){

            if(i>='0'&&i<='9'){
                count[i-'0']++;
            }
        }
        int max = -1;
        for(int i=9;i>=0;i--){

            if(count[i]!=0){
                if(max ==-1){
                    max =i;
                }else{
                    return i;
                }
            }
        }
        return -1;
    }
}
