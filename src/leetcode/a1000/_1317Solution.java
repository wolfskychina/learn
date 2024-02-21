package leetcode.a1000;
/**
 * 将整数拆分成两个各位上都没有0的数字之和
 * {math}
 */
public class _1317Solution {
   
    public int[] getNoZeroIntegers(int n) {
        int [] res = new int[2];
        //n <= 10 时单独讨论一下
        if(n <= 10)
        {
            res[0] = 1;
            res[1] = n - 1;
            return res;
        }

        //求数字n的十进制长度
        int length = (int)Math.log10(n);

        //数字res[0]中每一位都是9,res[1]是与res[0]互补的数
        res[0] = (int)Math.pow(10, length) - 1;
        res[1] = n - res[0];

        //判断res[1]中十进制某一位是否为0
        int temp = res[1];
        int index = 1;

        while(temp > 0)
        {
            //如果res[1]某一位为0，则res[1]该位加上1，res[0]该位减去1
            if(temp % 10 == 0)
            {
                res[0] -= index;
                res[1] += index;
            }

            index *= 10;
            temp = temp / 10;
        }

        return res;
    }
}
