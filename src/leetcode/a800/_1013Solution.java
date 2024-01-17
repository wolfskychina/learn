package leetcode.a800;
/**
 * 能否将数组分成和相等的三个非空子数组
 */
public class _1013Solution {
   
    /**
     * 注意判断条件
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum(int[] arr) {

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%3!=0) return false;
        int found =0;
        int i=0;
        int tar = sum/3;
        while(i<arr.length){
            int tmp = arr[i++];
            while(i<arr.length&&tmp!=tar){
                tmp+= arr[i];
                i++;
            }
            if(tmp==tar){
                // found one
                found++;
            }
            // 判断条件这里比较容易出错
            if(i!=arr.length&&found==2){
                return true;
            }

        }
        return false;
        
    }
}
