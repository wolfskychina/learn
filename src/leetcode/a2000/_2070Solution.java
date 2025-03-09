package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不超过某个价格的所有商品的最大美丽值
 * {binary search},{sort}
 */
public class _2070Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        list.add(items[0]);
        for (int i = 1; i < items.length; i++) {
            if (items[i][0] != list.get(list.size() - 1)[0]) {
                items[i][1] = Math.max(items[i][1], list.get(list.size() - 1)[1]);
                list.add(items[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(items[i][1], list.get(list.size() - 1)[1]);
            }
        }
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = list.size();
            // 注意边界，在list.get(0)[0]左侧没有符合条件的物品
            // 在list.get(list.size() - 1)[0]的右侧的值就是所有价格物品的最大b值
            if (queries[i] < list.get(0)[0] || queries[i] > list.get(list.size() - 1)[0])
                res[i] = 0;
            else {
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid)[0] > queries[i]) {
                        r = mid;
                    } else {
                        l = mid+1;
                    }
                }
                res[i] = list.get(l - 1)[1];
            }
        }
        return res;

    }

    public static void main(String[] args){

        _2070Solution so = new _2070Solution();
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] querys = {1,2,3,4,5,6};
        so.maximumBeauty(items,querys); 
    }
}
