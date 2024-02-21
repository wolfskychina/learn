package leetcode.a900;

import java.util.Random;
/**
 * {qsort}
 */
public class _912Solution {

    public static final Random RANDOM = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {

        boolean sorted = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted)
            return nums;

        qsort(nums, 0, nums.length - 1);

        return nums;
    }

    void qsort(int[] nums, int l, int r) {
        if (l < r) {
            int idx = partation(nums, l, r);
            qsort(nums, l, idx - 1);
            qsort(nums, idx + 1, r);
        }

    }

    /**
     * 算法导论里面的快排比较慢
     * @param nums
     * @param l
     * @param r
     * @return
     */
    int partation(int[] nums, int l, int r) {

        int random =  l + RANDOM.nextInt(r - l + 1);
        int temp = nums[random];
        nums[random] = nums[r];
        nums[r] = temp;
        int tar = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] <= tar) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }
        nums[r] = nums[i];
        nums[i] = tar;

        return i;
    }

    public  int[] sortArray2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while(true) {
            while(le <= ge && nums[le] < pivot) {
                le++;
            }
            while(le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if(le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {

        _912Solution so = new _912Solution();
        int[] nums = { 5, 2, 3, 1 };
        so.sortArray(nums);
    }
}
