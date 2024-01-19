package leetcode.a800;
/**
 * 能否将数组里的数划分成相等数组
 * {easy}
 */
public class _2206Solution {
   
    public boolean divideArray(int[] nums) {

        int [] count = new int[501];
        for(int i:nums){
            count[i]++;
        }
        for(int i:count){
            if(i%2!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        _2206Solution so = new _2206Solution();
        int[] arr = {3,2,3,2,2,2};
        so.divideArray(arr);
    }
}
