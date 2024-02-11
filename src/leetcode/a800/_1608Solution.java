package leetcode.a800;

/**
 * 判断一个数组中是否符合，存在一个数k，数组中大于等于k的元素恰好有k个
 * k本身不一定出现在数组中
 * {esay}
 * 
 */
public class _1608Solution {

    public int specialArray(int[] nums) {

        int count[] = new int[1001];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = count.length - 2; i >= 0; i--) {

            count[i] += count[i + 1];
        }

        for (int i = 100; i >= 0; i--) {

            if (count[i] == i)
                return i;
        }

        return -1;

    }
}
