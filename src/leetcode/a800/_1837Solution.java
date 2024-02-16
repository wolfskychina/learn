package leetcode.a800;
/**
 * k进制的各位数字的和
 * {easy}
 */
public class _1837Solution {
   
    public int sumBase(int n, int k) {
        int sum =0;
        while(n!=0){
            sum+=n%k;
            n /=k;
        }
        return sum;
    }
}
