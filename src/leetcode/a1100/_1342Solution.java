package leetcode.a1100;
/**
 * {esay} 数字变成0的操作次数
 */
public class _1342Solution {
   
    public int numberOfSteps(int num) {

        int step =0;
        while(num!=0){
            if(num%2==0){
                num /=2;
            }else{
                num--;
            }
            step++;
        }
        return step;
    }
}
