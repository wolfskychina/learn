package leetcode.a300;

import java.util.ArrayList;
import java.util.List;

public class _315Solution {

    int[] tmpIdx;
    int[] idx;
    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        tmpIdx = new int[nums.length];
        idx = new int[nums.length];
        ans = new int[nums.length];

        mergeSort(nums, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int i : ans) {
            list.add(i);

        }
        return list;

    }

    private void mergeSort(int[] nums, int l, int r) {

        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int ll, int mid, int rr) {

        int[] tmp = new int[rr - ll + 1];
        int l = ll;
        int r = rr;
        int k = 0;
        while (l <= mid && r <= rr) {

            if (nums[l] <= nums[r]) {
                tmp[k] = nums[l];
                tmpIdx[k] = idx[l];

                k++;
                l++;
            } else {
                // mid-l+1 reverse found !
                tmp[k] = nums[r];
                tmpIdx[k] = idx[r];
                ans[idx[r]] += mid - l + 1;
                k++;
                r++;

            }
        }

        while (l <= mid) {
            tmp[k] = nums[l];
            tmpIdx[k] = idx[l];
            k++;
            l++;
        }

        while (r <= rr) {
            tmp[k] = nums[r];
            tmpIdx[k] = idx[r];
            k++;
            r++;
        }

        for (int i = 0; i <= rr - ll; i++) {
            nums[ll + i] = tmp[i];
            idx[i] = tmpIdx[i];
        }
    }
}
