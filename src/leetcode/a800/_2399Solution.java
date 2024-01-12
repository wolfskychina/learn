package leetcode.a800;

import java.util.Arrays;
/**
 * 检查相同字母间的距离
 * {easy}
 */
public class _2399Solution {

    public boolean checkDistances(String s, int[] distance) {

        int sign[] = new int[26];
        Arrays.fill(sign, -1);
        char arr[] = s.toCharArray();
        int dis[] = new int[26];
        for (int i = 0; i < arr.length; i++) {

            dis[arr[i] - 'a'] += sign[arr[i] - 'a'] * i;
            sign[arr[i] - 'a'] = 1;
        }
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] != 0 && dis[i] - 1 != distance[i])
                return false;
        }
        return true;

    }
}
