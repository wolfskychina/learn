package leetcode.a1700;
/**
 * 盒子中小球的最大数量
 * {easy}
 */
public class _1742Solution {
   
    public int countBalls(int lowLimit, int highLimit) {

        int count[] = new int[46] ;
        for(int i=lowLimit;i<=highLimit;i++){
            count[sumOfDigits(i)]++;
        }
        int max =0;
        for(int i=count.length-1;i>=0;i--){
            max = Math.max(max, count[i]);
        }

        return max;
    }

    private int sumOfDigits(int i){
        int sum= 0;
        while(i!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }
}
