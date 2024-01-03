package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 环和杆
 * {easy}
 */
public class _2103Solution {

    public int countPoints(String rings) {

        Set<Integer> rset = new HashSet<>();
        Set<Integer> gset = new HashSet<>();
        Set<Integer> bset = new HashSet<>();
        int i = 0;
        while (i < rings.length() - 1) {
            char c = rings.charAt(i);
            int idx = rings.charAt(i + 1) - '0';
            switch (c) {
                case 'R':
                    rset.add(idx);
                    break;
                case 'G':
                    gset.add(idx);
                    break;
                default:
                    bset.add(idx);
                    break;
            }

            i += 2;
        }
        int count = 0;
        for (int j = 0; j <= 9; j++) {

            if (rset.contains(j) && gset.contains(j) && bset.contains(j)) {
                count++;
            }
        }
        return count;

    }
}
