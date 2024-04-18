package leetcode.a200;
/**
 * Strobogrammatic Number
 * 判断一个数字旋转180度之后是否和原数字相同
 * {easy}
 */
public class _246Solution {

    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for(char c: num.toCharArray()){
            if(c == '0' || c == '1' || c == '8'){
                sb.append(c);
            }
            else if(c == '6'){
                sb.append('9');
            }
            else if(c == '9'){
                sb.append('6');
            }
            else{
                return false;
            }
        }
        return sb.reverse().toString().equals(num);
    }
    
}
