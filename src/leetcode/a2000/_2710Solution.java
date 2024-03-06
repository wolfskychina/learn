package leetcode.a2000;
/**
 * 移除字符串末尾的连续0
 * {easy}
 */
public class _2710Solution {

    public String removeTrailingZeros(String num) {
        int len = num.length();
        int index = len - 1;
        while(index >= 0 && num.charAt(index) == '0'){
            index--;
        }
        return num.substring(0, index + 1);
    } 
}
