package leetcode.a800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 带因子的二叉树的数量
 * 要求生成的二叉树的节点的值必须在arr中
 * 并且父节点的值等于左右子节点的值的积
 */
public class _823Solution {

    /**
     * {HashMap}考验对二叉树的左右子树的性质的理解
     * @param arr
     * @return
     */
    public int numFactoredBinaryTrees(int[] arr) {

        int MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int root : arr) {
            // root因式分解
            int numOfTree = 1;
            for (int i=0;arr[i]<=(int)Math.sqrt(root);i++) {

                if (root % arr[i] == 0) {
                    int j = root / arr[i];
                    if (map.containsKey(arr[i])&&map.containsKey(j)) {

                        numOfTree = (int) ((numOfTree + ((long) map.get(arr[i]) * map.get(j)*(arr[i]==j?1:2)) % MOD) % MOD);

                    }
                }
            }
           map.put(root, numOfTree);
        }
        int res = 0;
        for (int num : map.values()) {
            res = (int) (((long) res + num) % MOD);
        }
        return res;
    }

    public static void main(String[] args) {

        _823Solution so = new _823Solution();
        int[] arr = { 2, 4, 5, 10 };
        so.numFactoredBinaryTrees(arr);
    }
}
