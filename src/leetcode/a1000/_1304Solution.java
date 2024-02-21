package leetcode.a1000;
/**
 * 生成和为0的n个不同的数
 * {easy}
 */
public class _1304Solution {
   
    public int[] sumZero(int n) {

        int res[] = new int[n];
        for(int i=0;i<n/2;i++){
            res[i] = i+1;
            res[i+n/2] = -i-1;
        }
        if(n%2==1)
            res[n-1]=0;
        return res;
    }
}
