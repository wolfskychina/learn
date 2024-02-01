package leetcode.a800;
/**
 * 判断一个数是否是阿姆斯特朗数
 * {easy}
 */
public class _1134Solution {
   
    public boolean isArmstrong(int n) {

        int i = n;
        int sum =0;
        int num =0;
        while(i!=0){
            num++;
            i/=10;
        }
        i=n;
        while(i!=0){
            sum += Math.pow(i%10, num);
            i/=10;
        }
        return sum==n;
    }
}
