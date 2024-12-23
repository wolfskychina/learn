package leetcode.a900;

/**
 * 判断等式组能否全部成立
 * {union find}
 */
public class _990Solution {

    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        // if(length == 1) return true;

        UnionFind unionFind = new UnionFind(26);
        // 先遍历等号,构建联通
        for (String equation : equations) {
            if (equation.charAt(1) == '!')
                continue;
            int index1 = equation.charAt(0) - 'a';
            int index2 = equation.charAt(3) - 'a';
            unionFind.union(index1, index2);
        }

        // 遍历不等号,判断是否联通，联通则返回false
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                continue;
            int index1 = equation.charAt(0) - 'a';
            int index2 = equation.charAt(3) - 'a';
            if (unionFind.isConnected(index1, index2))
                return false;
        }

        return true;
    }

    private class UnionFind {
        int[] parent = null;
        int count = 0;

        public UnionFind(int x) {
            count = x;
            parent = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
            }
        }

        public int find(int source) {
            while (source != parent[source]) {
                parent[source] = parent[parent[source]];
                source = parent[source];
            }

            return source;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int xf = find(x);
            int yf = find(y);
            if (xf == yf)
                return;
            parent[xf] = yf;
            count--;
        }
    }
}
