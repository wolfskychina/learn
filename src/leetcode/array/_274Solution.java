package leetcode.array;

import java.util.Arrays;
import java.util.Collections;

public class _274Solution {
   
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l =0;
        int r = citations.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if((mid+1)>=citations[mid]){
                r = mid;
            }else{
                l =mid+1;
            }
        }

        return l+1;

    }

    public static void main(String[] args){

        _274Solution so  = new _274Solution();
        int[] ci = {3,0,6,1,5};
        so.hIndex(ci);
    }
}
