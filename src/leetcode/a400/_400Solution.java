package leetcode.a400;
/**
 * 将正整数从小到大排成序列，每个数字的每一位数占一位长度
 * 求序列中的第n个数位是多少
 * 
 */
public class _400Solution {
   
    public int findNthDigit(int n) {
        int low = 1, high = 9;
        // 二分查找定位第n个数位所在数字的位数
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;//第n个数位所在的数字
        int digitIndex = index % d;// 第n个数位所在的数字的从左往右的位数
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    /**
     * 计算所有长度<=length的数字的总的数位
     * @param length
     * @return
     */
    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;//9.90.900...对应长度i的数字的总位数
        }
        return digits;
    }

}
