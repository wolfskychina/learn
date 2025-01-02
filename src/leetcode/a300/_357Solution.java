package leetcode.a300;
/**
 * 357. Count Numbers with Unique Digits
 * 计算小于10的n次方的整数总共有多少个是由完全不相同的位组成的
 * {combination},{math}
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
        // 最多只能有10位不重复，超过10位肯定会出现重复数字
        if(n>10) n=10;
        int sum =10;
        int f = 1;
        for(int i =9; n>1 ;n--,i--){
            f*=i;
            // 每个不同长度的独特数字的首位都有9种可能，0-9
            // 第2位第3位之后分别是9.8.7.6.5.。。种可能
            sum+=9*f;

        }
        return sum;

    }
}
