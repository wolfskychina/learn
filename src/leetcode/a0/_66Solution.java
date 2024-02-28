package leetcode.a0;
/**
 * 数组模拟加法
 * 进位处理
 */
public class _66Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int i = n-1;
        for(;i>=0;i--){
            if(digits[i]==9 && carry ==1){
                digits[i]=0;

            }else if(carry==1){
                digits[i]++;
                carry = 0;
                break;
            }
        }

        if(i==-1 && carry==1){
            int [] res = new int[n+1];
            res[0]=1;
            for(int j=0;j<n;j++){
                res[j+1]=digits[j];
            }

            return res;
        }else{
            return digits;
        }
    }
}
