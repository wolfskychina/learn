package leetcode.a1100;
/**
 * 等差数列中缺失的数字
 * 注意差为负数的时候，需要比较绝对值
 */
public class _1228Solution {
   
    public int missingNumber(int[] arr) {

        int dif1 = 0;
        int dif2 = 0;
        if(arr[0]-arr[1]==0) return arr[0];
        int p1=0;
        int p2 =0;
        for(int i=1;i<arr.length;i++){
            if(dif1==0){
                dif1 = arr[i]-arr[i-1];
                p1=arr[i];
            }else if(arr[i]-arr[i-1]!=dif1 && dif2 ==0){
                dif2 = arr[i]-arr[i-1];
                p2 =arr[i];
            }

            if(dif1!=0&&dif2!=0&&dif1!=dif2) break;
        }
        // 差有可能为负数
        if(Math.abs(dif1)<Math.abs(dif2)){
            return p2-dif1;
        }else{
            return p1-dif2;
        }
    }
}
