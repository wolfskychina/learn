package leetcode.a1100;

import java.util.Arrays;
/**
 * 一个数组能否通过不断的反转子数组，变成和另外一个数组相同
 * {easy}
 */
public class _1460Solution {

    public boolean canBeEqual(int[] target, int[] arr) {

        if (target.length != arr.length)
            return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i])
                return false;
        }
        return true;

    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        int[] hash1 = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            hash1[arr[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((--hash1[target[i]]) < 0) {
                return false;
            }
        }
        return true;
    }
}
