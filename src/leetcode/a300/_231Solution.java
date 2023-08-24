package leetcode.a300;
/**
 * 判断一个整数是不是2的幂
 */
public class _231Solution {
  
    /**
     * 运用了2的幂的特殊性质
     */
    public boolean isPowerOfTwo2(int n) {
        
        return n>0 && (n&(n-1))==0;
      }

    /**
     * 判断是否只有一个1的位，注意n有可能是负数
     */
    public boolean isPowerOfTwo(int n) {
        
        int count = 0;
        if(n<0) return false;
        while(n!=0){
            if( (n & 1 ) == 1) count++;
            n = n>>1;
        }

        if(count ==1 ) return true;
        return false;
    }



}
