package leetcode.a2000;
/**
 * 统计已测试装备
 * {easy}
 */
public class _2960Solution {
   
    public int countTestedDevices(int[] batteryPercentages) {
        int dec = 0;
        for (int x : batteryPercentages) {
            if (x > dec) {
                dec++;
            }
        }
        return dec;
    }

}
