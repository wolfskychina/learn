package leetcode.a1000;

/**
 * 让相等的条形码不相邻
 * 类似767题
 * {counting},{greedy},{TODO}
 */
public class _1054Solution {

    /**
     * 只要不超过总长度的1/2，优先放到奇数格子
     * 超过了1/2或者奇数格子已经放满，需要放到偶数格子里面
     * @param barcodes
     * @return
     */
    public int[] rearrangeBarcodes(int[] barcodes) {

        int count[] = new int[10001];

        for (int i = 0; i < barcodes.length; i++) {
            count[barcodes[i]]++;
        }

        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = barcodes.length / 2;
        int[] res = new int[barcodes.length];

        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0 && count[i] <= halfLength && oddIndex < res.length) {
                res[oddIndex] = i;
                count[i]--;
                oddIndex += 2;
            }

            while (count[i] > 0) {
                res[evenIndex] = i;
                count[i]--;
                evenIndex += 2;
            }
        }
        return res;

    }
}
