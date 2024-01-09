package leetcode.a800;

import java.util.Arrays;
/**
 * 按身高给人排序
 * 根据一栏联动另外一栏一起排序
 */
public class _2418Solution {
   
    public String[] sortPeople(String[] names, int[] heights) {

        Integer idx[] = new Integer[heights.length];
        for(int i=0;i<idx.length;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(o1,o2)->heights[o2]-heights[o1]);
        String[] res = new String[names.length];
        int j=0;
        for(int i:idx){
            res[j++]=names[i];
        }
        return res;

    }
}
