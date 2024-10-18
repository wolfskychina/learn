package leetcode.a1100;
/**
 * 将每个元素替换为右侧最大的元素
 * {easy}
 */
public class _1299Solution {
   
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1;i>=0;i--){
            
            int tmp = Math.max(max,arr[i]);
            arr[i]=max;
            max = tmp;
        }
        return arr;
    }
}
