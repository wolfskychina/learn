package leetcode.array;

public class _96Solution {
   
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
        
        // Gi代表求节点数为i的bst的数量
        for(int i=2; i<=n; ++i) {
          // j代表选择第j个元素为root的bst的情况
          for(int j=1; j<=i; ++j) {
              // 左边有j-1个元素，右边有i-j个元素
            G[i] += G[j-1] * G[i-j];
          }
        }
       
        return G[n];
   }
}
