package leetcode.a1500;
/**
 * 所有奇数长度子数组的和
 */
public class _1588Solution {
   
    /**
     * 考虑每个数字在奇数长度的子数组中出现了多少次
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {

        int res = 0;
              for(int i = 0; i < arr.length; i ++){
                  int left = i + 1, right = arr.length - i,
                      left_even = (left + 1) / 2, right_even = (right + 1) / 2,
                      left_odd = left / 2, right_odd = right / 2;
                  res += (left_even * right_even + left_odd * right_odd) * arr[i];
              }
              return res;
      
          }
}
