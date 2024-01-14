package leetcode.a800;
/**
 * 数组中出现最多的偶数
 * {easy} 
 */
public class _2404Solution {
   
    public int mostFrequentEven(int[] nums) {

        int count[] = new int[50001];
        for(int i:nums){
            if(i%2==0)
                count[i/2]++;
        }
        int max =0;
        int idx =0;
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
                max = count[i];
                idx = i;
            }
        }
        return max==0?-1:idx*2;
    }
}
