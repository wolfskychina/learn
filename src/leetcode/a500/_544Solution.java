package leetcode.a500;

import java.util.ArrayList;
import java.util.List;

/**
 * 比赛配对，要求每一轮都是比较强和比较弱的配对
 * {easy}
 * 
 */
public class _544Solution {

    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        while (list.size() != 1) {
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < list.size() / 2; i++) {
                newList.add("(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")");
            }
            list = newList;
        }

        return list.get(0);
    }

    /**
     * 优化后的
     * @param n
     * @return
     */
    public String findContestMatch1(int n) {
        String[] team = new String[n];
        for (int i = 1; i <= n; ++i)
            team[i - 1] = "" + i;

        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; ++i)
                team[i] = "(" + team[i] + "," + team[n - 1 - i] + ")";

        return team[0];
    }

}
