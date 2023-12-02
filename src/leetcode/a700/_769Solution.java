package leetcode.a700;
/**
 * 能够将一个0-n-1的乱序数组分解成尽可能多的区块，
 * 使得只需要这些区块内部排序之后，整个数组变为有序
 */
public class _769Solution {

    /**
     * 和763题有点类似，搜索的时候如果一个区块中的值是val，那么在索引val也必须在这个区块中
     * 这样区块的右侧边界会不断的向右扩展，最后扫描到最终的右侧边界之后，这个边界就是区块的右边界
     * 也就是说这些元素必须在一个区块中。后面的元素就可以放到新的区块中。
     * {greedy},{monotonic stack} 
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {

        int start = 0;
        int max = 0;
        int num = 0;
        while (start < arr.length) {
            int idx = start;
            while (idx <= max) {

                if (arr[idx] > max) {
                    max = arr[idx];
                }
                idx++;
            }
            num++;
            start = max + 1;
            max = start;

        }

        return num;
    }
}
