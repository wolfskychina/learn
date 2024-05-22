package leetcode.a300;
/**
 * 357. Count Numbers with Unique Digits
 * 计算小于10的n次方的整数总共有多少个是由完全不相同的位组成的
 * {combination}
 */
public class _357Solution {

   /**
    * 排列组合问题
    * {combination}
    * @param n
    * @return
    */
    public int countNumbersWithUniqueDigits(int n) {

        if(n==0) return 1;
        if(n==1) return 10;
        if(n>10) n=10;
        int sum =10;
        int f = 1;
        for(int i =9; n>1 ;n--,i--){
            f*=i;
            sum+=9*f;

        }
        return sum;

    }
}
