package leetcode.a600;
/**
 * 给定一个整数c，判断是否有两个非负整数a和b使得a和b的平方和等于c
 */
public class _633Solution {
   
    /**
     * 注意整数乘积可能溢出
     * {overflow},{two pointers}
     */
    public boolean judgeSquareSum(int c) {

        long a =0;
        long b = (int)Math.sqrt(c);
        while(a<=b){
            long re = a*a+b*b;
            if(re ==c)
                return true;
            if(re>c)
                {b--;}
            else{a++;}
        }
        return false;

    }

    public static void main(String[] args){

        _633Solution so = new _633Solution();
        so.judgeSquareSum(2147483600);
    }
}
