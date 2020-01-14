package leetcode.array;

public class _29Solution {

    public int divide(int dividend, int divisor){

        int sign = (dividend<0)^(divisor<0)?-1:1;

        int quotient = 0;
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1) return Integer.MIN_VALUE;
            if(divisor == Integer.MIN_VALUE) return 1;
            dividend += divisor;
            quotient++;
        }

        if(divisor == Integer.MIN_VALUE) return 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend>=divisor){
            int tmp = divisor,count =1;
            while(dividend-tmp>=tmp){
                tmp <<= 1;
                count <<= 1;
            }

            dividend -= tmp;
            quotient += count;
        }

        return sign*quotient;
    }


}
