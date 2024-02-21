package leetcode.a1000;
/**
 * 计算leetcode银行的钱
 * {easy}
 */
public class _1716Solution {
   
    public int totalMoney(int n) {

        int i = n/7;
        int sum = 28*i+7*i*(i-1)/2;

        for(int j=0;j<n%7;j++){
            sum+=j+1+n/7;
        }
        return sum;

    }
}
