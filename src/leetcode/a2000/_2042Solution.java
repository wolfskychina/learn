package leetcode.a2000;
/**
 * 检查句子中的数字是否递增
 * {easy}
 */
public class _2042Solution {
   
    public boolean areNumbersAscending(String s) {

        int max = -1;
        for(String str:s.split(" ")){

            if(str.charAt(0)>'9')
                continue;
            
            int num = Integer.parseInt(str);
            if(num>max){
                max = num;
            }else{
                return false;
            }
        }
        return true;
    }
}
