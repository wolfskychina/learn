package leetcode.a2000;
/**
 * [1,n]之间能被3,5,7整除的数字的和
 */
public class _2652Solution {
  
    /**
     * {easy}
     * @param n
     * @return
     */
    public int sumOfMultiples(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){

            if(i%3==0||i%5==0||i%7==0)
                sum+=i;
        }
        return sum;
    }
}
