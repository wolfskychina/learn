package leetcode.a0;

public class _8Solution {
   
    public static int myAtoi(String str) {

        if (null == str || str.isEmpty()) return 0;
    
        int sign = 1, base = 0, i = 0;
    
        while (i< str.length() &&str.charAt(i) == ' ')
            i++;
    
        if(i== str.length()) return 0;
    
    
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
    
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    
            // Integer.MAX_VALUE = 21 4748 3647
            // 这个条件仅适用于10进制，如果是其他进制那么每一位的数字就不同了
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            /*
             * 默认让base往负的方向加，每一步如果要溢出，那么就直接返回
             * if (base < limit + digit) 
             * 这种判断适用于各种进制
             */
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
