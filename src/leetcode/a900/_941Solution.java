package leetcode.a900;

public class _941Solution {
    /**
     * 判断一个数组是否是有效山峰
     * 必须是严格递增然后递减
     * {easy}
     * 
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {

        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1])
            i++;
        if (i == 0 || i == arr.length - 1)
            return false;
        if (arr[i] == arr[i + 1])
            return false;
        while (i + 1 < arr.length && arr[i] > arr[i + 1])
            i++;
        if (i == arr.length - 1)
            return true;
        return false;
    }
}
