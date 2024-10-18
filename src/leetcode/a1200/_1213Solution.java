package leetcode.a1200;

import java.util.ArrayList;
import java.util.List;
/**
 * 三个有序数组的交集
 * {easy}
 */
public class _1213Solution {
   
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        int count[] = new int[2001];
        for(int i:arr1){
            count[i]++;
        }
        for(int i:arr2){
            count[i]++;
        }
        for(int i:arr3){
            count[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count.length;i++){
            if(count[i]==3)
                list.add(i);
        }
        return list;
    }
}
