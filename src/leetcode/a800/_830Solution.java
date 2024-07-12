package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

/**
 * 较大分组的位置
 */
public class _830Solution {
   
    /**
     * 
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {

        /**
         * 注意当下一个字符不同的话进行长度比较的时候
         * 如果遇到字符串的结尾，那么可能少一次比较
         */
        char[] arr = (s+" ").toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int l =0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==arr[l]){
                continue;
            }else{
                if(i-l>=3){
                    List<Integer> list = new ArrayList<>();
                    list.add(l);
                    list.add(i-1);
                    res.add(list);
                }
                l=i;
            }
        }

        return res;
    }
}
