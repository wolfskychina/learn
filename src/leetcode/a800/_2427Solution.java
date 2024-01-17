package leetcode.a800;
/**
 * 两个整数的公因子的数量
 * {easy}
 */
public class _2427Solution {
   
    public int commonFactors(int a, int b) {

        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int count =1;
        for(int i=2;i<=a;i++){
            if(a%i==0&&b%i==0)
                count++;
        }
        return count;
    }
}
