package leetcode.a1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 数组转换，不断对相邻三个数进行平滑
 * {simulation}
 */
public class _1243Solution {
   
    public static List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        boolean feed = true;
        while(feed){
            feed = false;
            int a[] = Arrays.copyOf(arr, len);
            for(int i = 1; i < len - 1; i ++){
                if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1]){
                    a[i]++;
                    feed = true;
                }
                else if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                    a[i]--;
                    feed = true;
                }
            }
            arr = a;
        }
        return intArrayToList(arr);
    }
    
    public static List<Integer> intArrayToList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i ++){
            list.add(arr[i]);
        }
        return list;
     }
}
