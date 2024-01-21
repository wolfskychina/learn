package leetcode.a800;
/**
 * 去掉最大值和最小值的平均工资
 */
public class _1491Solution {
   
    public double average(int[] salary) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:salary){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int n = 0;
        int sum = 0;
        for(int i=0;i<salary.length;i++){

            if(salary[i]!=min&&salary[i]!=max){
                sum+=salary[i];
                n++;
            }
        }

        return (double)sum/n;
    }
}
