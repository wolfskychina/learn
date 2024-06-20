package leetcode.a500;

import java.util.Arrays;
/**
 * 给定元素的分数，求他们的排名
 * {sorting},{index},{counting sort}
 */
public class _506Solution {

    /**
     * 添加索引信息后进行排序，按照排序后的顺序标记每个索引
     * onlogn
     * 
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {

        int[][] rank = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            rank[i][0] = score[i];
            rank[i][1] = i;
        }
        Arrays.sort(rank, (o1, o2) -> o2[0] - o1[0]);
        String[] res = new String[score.length];
        int i = 1;
        for (int[] array : rank) {
            switch (i) {
                case 1:
                    res[array[1]] = "Gold Medal";
                    break;
                case 2:
                    res[array[1]] = "Silver Medal";
                    break;
                case 3:
                    res[array[1]] = "Bronze Medal";
                    break;
                default:
                    res[array[1]] = "" + i;

            }
            i++;
        }

        return res;

    }

    /**
     * 计数排序，空间换时间，on时间复杂度
     * @param score
     * @return
     */
    public String[] findRelativeRanks1(int[] score) {
        String[] result = new String[score.length];
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }
        int[] arr = new int[max + 1];
        for (int j = 0; j < score.length; j++) {
            arr[score[j]] = j + 1;
        }
        int count = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] != 0) {
                switch (count) {
                    case 1:
                        result[arr[j] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[arr[j] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[arr[j] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[arr[j] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }
}
