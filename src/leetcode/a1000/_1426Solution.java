package leetcode.a1000;
/**
 * 数组中比每个元素大1的元素是否在数组中
 * {easy}
 */
public class _1426Solution {
   
    public int countElements(int[] arr) {

        int count[] = new int[1002];
        for(int i:arr){
            count[i]++;
        }
        int res = 0;
        for(int i :arr){

            if(count[i+1]!=0){
                res++;
            }

        }
        return res;
    }
}
