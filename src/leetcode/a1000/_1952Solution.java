package leetcode.a1000;
/**
 * 判断一个数是否恰好有三个除数，包括1和本身
 * {math}
 */
public class _1952Solution {
   
     public boolean isThree(int n) {
        int sq = (int)Math.sqrt(n);
        if(sq*sq!=n) return false;

        return ifPrime(sq);

    }

    private boolean ifPrime(int n){
            
            if(n==1) return false;
            int i=2;
            int sq = (int)Math.sqrt(n);
            while(i<=sq){
                if(n%i==0) return false;
                i++;
            }
            return true;

    }
}
