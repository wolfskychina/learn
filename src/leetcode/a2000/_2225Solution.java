package leetcode.a2000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据一些比赛的结果，找出赢得所有参与比赛和只输了一场比赛的选手
 * 不同选手参加的比赛场次未必一致
 * {counting}
 */
public class _2225Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        short[] win = new short[100001];
        short[] lose = new short[100001];
        for (int[] a : matches) {
            win[a[0]]++;
            lose[a[1]]++;
        }
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        for (int i = 0; i < 100001; i++) {
            if (win[i] != 0 || lose[i] != 0) {
                if (lose[i] == 0) {
                    first.addLast(i);
                }
                if (lose[i] == 1) {
                    second.addLast(i);
                }
            }
        }
        return Arrays.asList(first, second);
    }
}
