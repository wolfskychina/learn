package leetcode.a2000;
/**
 * 加密后的整数和
 * {easy}
 */
public class _100262Solution {
   
    public int sumOfEncryptedInt(int[] nums) {

        int sum = 0;
        for(int i:nums){
            sum+=compute(i);
        }
        return sum;
    }

    private int compute(int n){

        int max = 0;
        int len =0;
        while(n!=0){
            len++;
            max = Math.max(max,n%10);
            n /=10;
        }
        int re =0;
        for(int i=0;i<len;i++){
            re = re*10+max;
        }

        return re;
    }
}
