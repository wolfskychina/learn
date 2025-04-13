package leetcode.a900;


/**
 * 找到小镇的法官
 * 法官不相信任何人，其他所有人都相信法官
 * 符合这两个条件的必须只有一个人
 * {graph}
 */
public class _997Solution {

    /**
     * 将信任关系转换为出入度，只有入度为n-1且出度为0的节点才符合法官要求
     * 这种节点必须只有一个
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] i : trust) {
            in[i[1]]++;
            out[i[0]]++;
        }
        int num = 0;
        int can = -1;
        for (int i = 1; i < in.length; i++) {

            if (in[i] == n - 1 && out[i] == 0) {
                num++;
                if (num > 1)
                    return -1;
                can = i;
            }
        }
        return can;
    }
}
