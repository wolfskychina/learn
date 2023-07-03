package leetcode.array;

public class _50Solution {

    public double myPow(double x, int n){

        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }

        return n%2 == 0 ? myPow(x*x,n/2):x*myPow(x*x,n/2);
    }

    double myPow2(double x, int n) {
       
        if(n == Integer.MIN_VALUE){
            x = x*x;
            n = n/2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            if ((n & 1)==0)
                result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args){

        _50Solution so = new _50Solution();
        System.out.println(so.myPow(4.0, 222));

    }

    
}
