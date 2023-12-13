package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * 最小和的分割
 * {easy}
 */
public class _2578Solution {

    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();

        while(num!=0){
            list.add(num%10);
            num/=10;
        }

        list.sort((o1, o2) -> o1-o2);

        int a1=0;
        int a2 =0;
        for(int i=0;i<list.size();i++){

            if(i%2==0){
                a1 = a1*10+list.get(i);
            }else{
                a2 = a2*10+list.get(i);
            }
        }

        return a1+a2;
    }
}
