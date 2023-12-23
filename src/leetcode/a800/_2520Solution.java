package leetcode.a800;
/**
 * 统计能整除数字的位数
 * {easy}
 */
public class _2520Solution {
   
    /**
     * 
     * @param num
     * @return
     */
    public int countDigits(int num) {

        int div = num;
        int count =0;
        while(div!=0){
            if(num % (div%10) ==0)
                count++;
            div /= 10;
        }
        return count;
    }
}
