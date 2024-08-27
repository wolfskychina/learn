package leetcode.a300;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找数组中每个元素右侧比这个元素小的元素的个数
 * TODO
 */
public class _315Solution {

    private int[] index;
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;

    /**
     * 利用归并排序，找出所有的逆序对
     * 
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums) {
        this.index = new int[nums.length];
        this.temp = new int[nums.length];
        this.tempIndex = new int[nums.length];
        this.ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }
        int l = 0, r = nums.length - 1;
        mergeSort2(nums, l, r);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    public void mergeSort2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort2(a, l, mid);
        mergeSort2(a, mid + 1, r);
        merge2(a, l, mid, r);
    }

    public void merge2(int[] a, int l, int mid, int r) {
        int i = l, j = mid + 1, p = l;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[p] = a[i];
                tempIndex[p] = index[i];
                // a[i] <= a[j]时，a[i]和a[mid+1]...a[j-1]均为逆序对
                // 每个半区里面内部已经是相对有序的，所以不存在逆序对
                ans[index[i]] += (j - mid - 1);
                ++i;
                ++p;
            } else {
                temp[p] = a[j];
                tempIndex[p] = index[j];
                ++j;
                ++p;
            }
        }
        while (i <= mid) {
            temp[p] = a[i];
            tempIndex[p] = index[i];
            // 最后前半段有多余元素的话
            // a[i]同a[mid+1]...a[r]即右半边所有元素全部构成逆序对
            ans[index[i]] += (j - mid - 1);
            ++i;
            ++p;
        }
        while (j <= r) {
            temp[p] = a[j];
            tempIndex[p] = index[j];
            ++j;
            ++p;
        }
        for (int k = l; k <= r; ++k) {
            index[k] = tempIndex[k];
            a[k] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 7, 8, 9, 4, 5, 6, 10, 11, 12 };
        _315Solution so = new _315Solution();
        List<Integer> list = so.countSmaller2(a);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}
