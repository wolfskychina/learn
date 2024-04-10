package leetcode.a200;

import java.util.HashSet;
import java.util.Set;
/**
 * 判断一个数是不是happy数
 * {easy}
 */
public class _202Solution {
   
    public boolean isHappy(int n) {

        int sum =n ;
        if(sum ==1) return true;
        Set<Integer> set = new HashSet<>();

        while(sum!=1){

            int sum2 = 0;
            while(sum!=0){
                //System.out.println("sum is:"+sum);
                sum2+= (sum%10)*(sum%10);
                sum /= 10;
            }
            // System.out.println("This round sum is :" +sum2);

            if(set.contains(sum2)){
                return false;
            }else{
                set.add(sum2);
            }

            sum = sum2;

        }

        return true;
        
    }

    public static void main(String[] args){


        _202Solution so = new _202Solution();
        so.isHappy(19);
    }
}
