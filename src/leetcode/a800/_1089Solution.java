package leetcode.a800;
/**
 * 复写零
 * {easy}
 */
public class _1089Solution {
   
    public void duplicateZeros(int[] arr) {

        int[] tmp = new int[arr.length];
        int idx=0;
        for(int i=0;i<arr.length;i++){

            if(idx==arr.length) break;
            if(arr[i]==0){
                tmp[idx++]=0;
                if(idx!=arr.length) tmp[idx++]=0;
            }else{
                tmp[idx++]=arr[i];
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = tmp[i];
        }
    }
}
