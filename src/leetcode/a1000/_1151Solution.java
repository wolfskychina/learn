package leetcode.a1000;

/**
 *  将数组中的1集合到一起所需要的最少交换次数
 *  集合在一起的1可以在数组的任何位置
 */
public class _1151Solution {

    /**
     * {sliding window} 
     * 先统计1的总数量k，问题转换成长度k的子数组中1的最大数量
     * @param data
     * @return
     */
    public int minSwaps(int[] data) {

        int count1 = 0;
        for (int i : data) {
            if (i == 1)
                count1++;
        }
        if (count1 == 0 || count1 == 1)
            return 0;

        int max1 = 0;
        int num = 0;
        for (int i = 0; i < count1; i++) {
            if (data[i] == 1)
                num++;
        }
        max1 = Math.max(max1, num);
        int l = 0;
        int r = count1;
        while (r < data.length) {
            if (data[l] == 1)
                num--;
            if (data[r] == 1)
                num++;
            max1 = Math.max(max1, num);
            l++;
            r++;
        }

        return count1 - max1;
    }
}
