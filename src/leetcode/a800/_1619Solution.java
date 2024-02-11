package leetcode.a800;

import java.util.Arrays;

/**
 * 删除某些元素后的数组均值
 * {easy}
 */
public class _1619Solution {
   
    public double trimMean(int[] arr) {

        Arrays.sort(arr);

        int ommit = arr.length/20;
        double mean = 0.0;
        for(int i=ommit;i<arr.length-ommit;i++){
            mean+=arr[i];
        }

        return mean/(arr.length*0.9);
    }

    public static void main(String[] args){

        int arr[] = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};

        _1619Solution so = new _1619Solution();
        so.trimMean(arr);
    }
}
