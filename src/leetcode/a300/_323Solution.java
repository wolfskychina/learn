package leetcode.a300;
/**
 * 无向图中连通分量的数量
 * {graph},{union-find}
 */
public class _323Solution {
   
    /**
     * union-find
     */
    public int countComponents(int n, int[][] edges) {
        // 节点编号0 - n-1
        // 保存连通分量编号的数组
        int [] idx = new int[n];
        int [] count = new int[n];
        int sum =n;

        for(int i =0;i<n;i++){
            idx[i] =i;
            count[i] = 1;
        }

        for(int i=0;i<edges.length;i++){
            int x =find(idx, edges[i][0]);
            int y =find(idx, edges[i][1]);

            if(x==y) continue;
            if(count[x]<count[y]){
                idx[x] =idx[y];
                count[y]+=count[x];
            }else{
                idx[y] =idx[x];
                count[x]+=count[y];
            }
            sum--;
        }

        return sum;


    }

    private int find(int[] idx, int p){

        while(idx[p]!=p){
            p = idx[p];
        }
        return p;

    }
}
