package leetcode.array;

import java.util.Arrays;

public class _274Solution {
  
    /**
     * 排序后使用二分查找的算法
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i =0;i<citations.length/2;i++){
            int tmp = citations[i];
            citations[i] = citations[citations.length-i-1];
            citations[citations.length-i-1] = tmp;
        }
        int l =0;
        // 注意这个r是开区间
        int r = citations.length;
        // 因为r是开区间，所以是<而不是<=
        while(l<r){
            int mid = l+(r-l)/2;
            if((mid+1)<=citations[mid]){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        // 返回的是包括索引l的左侧的元素个数，而不是l本身
        // l-1+1
        return l;

    }

    /**
     * 先实现一个线性版本
     * 线性的解法通过了，所以二分查找理论上是正确的
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        for(int i =0;i<citations.length/2;i++){
            int tmp = citations[i];
            citations[i] = citations[citations.length-i-1];
            citations[citations.length-i-1] = tmp;
        }
        int l =0;
        for(;l<citations.length &&(l+1)<=citations[l];l++){
        }

        return l;

    }

    public static void main(String[] args){

        _274Solution so  = new _274Solution();
        int[] ci = {3,0,6,1,5};
        //int[] ci = {1,3,1};
        so.hIndex(ci);
    }
}
