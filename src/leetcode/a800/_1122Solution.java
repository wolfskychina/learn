package leetcode.a800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数组的相对排序
 */
public class _1122Solution {
   
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                    
                    list1.add(arr1[j]);
                }
                
            }
        }
        for(int j=0;j<arr1.length;j++){

            if(!set.contains(arr1[j])){
                list.add(arr1[j]);
            }

        }
        Collections.sort(list);
        int res[] = new int[list1.size()+list.size()];
        int i=0;
        for(int num:list1){
            res[i++] = num;
        }
        for(int num:list){
            res[i++] = num;
        }
        return res;
        

    }

    /**
     * 类似于计数排序
     * {counting sort}
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int i : arr1)
        {
            cnt[i]++;
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        for (int i : arr2)
        {
            while (cnt[i]-- > 0)
            {
                res[idx++] = i;
            }
        }
        for (int i = 0; i < cnt.length; i++)
        {
            while (cnt[i]-- > 0)
            {
                res[idx++] = i;
            }
        }
        return res;
    }
}
