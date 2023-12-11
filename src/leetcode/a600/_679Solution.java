package leetcode.a600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 24点游戏
 * 4个原始数字是可以换位置的
 */
public class _679Solution {

    List<int[]> list = new ArrayList<>();

    public boolean judgePoint24(int[] cards) {

        //
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        Queue<Integer> q = new ArrayDeque<>();
        for (int i : set) {
            q.offer(i);
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int idx = q.poll();
            int seq[] = new int[4];
            seq[0] = cards[idx];
            set.remove(idx);
            perform(1, cards, set, seq);
            set.add(idx);
        }

        for (int[] card : list) {

            int num[][] = new int[4][2];
            for (int i = 0; i < num.length; i++) {
                num[i][0] = card[i];
                num[i][1] = 1;
            }

            for (int i = 0; i < 3; i++) {

                // 四种运算
                for (int j = 1; j <= 4; j++) {
                    if (compute4(num, i, j))
                        return true;
                }

            }
        }

        return false;
    }

    private void perform(int toFill, int[] cards, Set<Integer> set, int[] seq) {

        if (toFill == 3) {
            for (int i : set) {
                seq[3] = cards[i];
            }
            int[] re = Arrays.copyOf(seq, 4);
            list.add(re);
        } else {
            Queue<Integer> q = new ArrayDeque<>();
            for (int i : set) {
                q.offer(i);
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                seq[toFill] = cards[idx];
                set.remove(idx);
                perform(toFill + 1, cards, set, seq);
                set.add(idx);
            }
        }

    }

    private boolean compute4(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int[][] newnum = new int[num.length - 1][2];
        for (int k = 0; k < i; k++) {
            newnum[k] = num[k];
        }
        for (int k = i + 1; k < newnum.length; k++) {
            newnum[k] = num[k + 1];
        }

        newnum[i] = dealtwonum(num[i], num[i + 1], j);

        for (int k = 0; k < 2; k++) {

            // 四种运算
            for (int q = 1; q <= 4; q++) {
                if (compute3(newnum, k, q))
                    return true;
            }

        }
        return false;
    }

    private boolean compute3(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int[][] newnum = new int[num.length - 1][2];
        for (int k = 0; k < i; k++) {
            newnum[k] = num[k];
        }
        for (int k = i + 1; k < newnum.length; k++) {
            newnum[k] = num[k + 1];
        }

        newnum[i] = dealtwonum(num[i], num[i + 1], j);

        // 四种运算
        for (int q = 1; q <= 4; q++) {
            if (compute2(newnum, 0, q))
                return true;
        }

        return false;
    }

    private boolean compute2(int[][] num, int i, int j) {

        if (num[i + 1][0] == 0 && j == 4)
            return false;

        int newnum[] = dealtwonum(num[i], num[i + 1], j);
        if ((newnum[0] / newnum[1] == 24)&&
        (newnum[0] % newnum[1] == 0))
            return true;
        return false;
    }

    private int[] dealtwonum(int[] a, int[] b, int i) {

        int[] res = new int[2];
        if (i == 1) {
            res[0] = a[0] * b[1] + a[1] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 2) {
            res[0] = a[0] * b[1] - a[1] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 3) {
            res[0] = a[0] * b[0];
            res[1] = a[1] * b[1];
            return res;
        }
        if (i == 4) {
            res[0] = a[0] * b[1];
            res[1] = a[1] * b[0];
            return res;
        }
        return res;
    }

    public static void main(String[] args){
        _679Solution so = new _679Solution();
        int [] cards = {1,1,7,7};
        so.judgePoint24(cards);
    }
}