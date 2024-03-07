package leetcode.a100;

/**
 * 一个数组中除了一个数，其他的数均出现了两次
 * 求该数
 * {math},{bit manipulate}
 */
public class _136Solution {
  // 异或操作的作用
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}
