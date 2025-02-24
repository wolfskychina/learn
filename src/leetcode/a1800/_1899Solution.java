package leetcode.a1800;

/**
 * 通过不断合并取最大值能否得到目标三元组
 * {greedy}
 */
public class _1899Solution {

    /**
     * 考虑什么条件下三元组的每个数会保留在最后的三元组内
     * @param triplets
     * @param target
     * @return
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean exist1 = false;
        boolean exist2 = false;
        boolean exist3 = false;

        for (int[] t : triplets) {

            if (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                exist1 = true;
            }
            if (t[1] == target[1] && t[0] <= target[0] && t[2] <= target[2]) {
                exist2 = true;
            }
            if (t[2] == target[2] && t[1] <= target[1] && t[0] <= target[0]) {
                exist3 = true;
            }

            if (exist1 && exist2 && exist3)
                return true;

        }

        return false;
    }
}
