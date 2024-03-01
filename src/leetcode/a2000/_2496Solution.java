package leetcode.a2000;
/**
 * 字符串表示数字的最大值
 * {easy}
 */
public class _2496Solution {
   
    public int maximumValue(String[] strs) {

        int max = 0;
        for(String str:strs){
            int tmp = 0;
            for(char c:str.toCharArray()){
                if(c<'0'||c>'9'){
                    tmp = str.length();
                    break;
                }else{
                    tmp = tmp*10+c-'0';
                }
            }

            max = Math.max(max, tmp);
        }

        return max;
    }
}
