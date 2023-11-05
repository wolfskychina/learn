package leetcode.a500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个时间列表，求列表中任意两个时刻最小的时间差
 * {sorting},{bucket sort}
 */
public class _539Solution {

    /**
     * 换算成分钟表示，然后排序后比较，注意最后一个需要和第一个比较
     * 然后就是差值可以是向前也可以是向后，所以取差值和1440-差值中小的那个
     * 
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int min = 1440;
        int[] time = new int[timePoints.size()];
        for (int i = 0; i < time.length; i++) {
            String str = timePoints.get(i);
            time[i] = Integer.valueOf(str.split(":")[0]) * 60 +
                    Integer.valueOf(str.split(":")[1]);

        }
        Arrays.sort(time);
        for (int i = 0; i < time.length - 1; i++) {
            int diff = time[i + 1] - time[i];
            diff = Math.min(diff, 1440 - diff);
            min = Math.min(min, diff);
        }
        int diff = time[time.length - 1] - time[0];
        diff = Math.min(diff, 1440 - diff);
        min = Math.min(min, diff);

        return min;

    }

    /**
     * 运用鸽巢原理和桶排序
     * 按照分钟数一天只有1440分钟，如果超过1440则最小值一定是0
     * 直接使用1440个数组保存即可，消耗空间是常数
     * 
     * @param timePoints
     * @return
     */
    public int findMinDifference1(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440)
            return 0;
        int[] cnts = new int[1440];
        for (String s : timePoints) {
            char[] a = s.toCharArray();
            cnts[((a[0] - '0') * 10 + (a[1] - '0')) * 60 + (a[3] - '0') * 10 + (a[4] - '0')]++;
        }
        int ans = 1440, last = -1, min = -1;
        for (int i = 0; i < 1440 && ans != 0; i++) {
            if (cnts[i] == 0)
                continue;
            if (cnts[i] > 1)
                return 0;
            else if (last != -1) {
                ans = Math.min(ans, i - last);
                last = i;
            } else {
                min = i;
                last = i;
            }

        }
        ans = Math.min(ans, min + 1440 - last);
        return ans;
    }

    public static void main(String[] args) {
        _539Solution so = new _539Solution();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        so.findMinDifference(list);
    }
}
