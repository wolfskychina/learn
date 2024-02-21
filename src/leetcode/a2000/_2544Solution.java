package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;
/**
 * 数位交替正负号的和
 * {easy}
 */
public class _2544Solution {

    public int alternateDigitSum(int n) {

        List<Integer> list = new ArrayList<>();

        while(n!=0){
            list.add(n%10);
            n /=10;
        }
        int sum=0;
        boolean sign = true;
        for(int i=list.size()-1;i>=0;i--){
            if(sign){
                sum+=list.get(i);
                sign = false;
            }else{
                sum-=list.get(i);
                sign = true;
            }
        }

        return sum;

    }
}
