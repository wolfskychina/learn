package leetcode.a400;

import java.util.HashMap;
import java.util.Map;

public class _447Solution {

    /**
     * 遍历所有的三元组，计算每个三元组中，分别以x,y,z为中点到另外两点的距离
     * 因为另外两边两个节点顺序对结果有影响，最终结果*2
     * 这个速度比较慢
     * 
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                for (int k = j + 1; k < points.length; k++) {

                    int ij0 = (int) Math.pow((points[j][0] - points[i][0]), 2);
                    int ij1 = (int) Math.pow((points[j][1] - points[i][1]), 2);
                    int ik0 = (int) Math.pow((points[k][0] - points[i][0]), 2);
                    int ik1 = (int) Math.pow((points[k][1] - points[i][1]), 2);
                    int kj0 = (int) Math.pow((points[k][0] - points[j][0]), 2);
                    int kj1 = (int) Math.pow((points[k][1] - points[j][1]), 2);

                    // i int the middle
                    if (ij0 + ij1 == ik0 + ik1) {
                        res++;
                    }
                    // j in the middle
                    if (ij0 + ij1 == kj0 + kj1) {
                        res++;
                    }
                    // k int the middle
                    if (kj0 + kj1 == ik0 + ik1) {
                        res++;
                    }

                }
            }
        }

        return res * 2;
    }

    /**
     * 调整用Hash保存已经计算过的两点的距离，耗时反而更多
     * 
     * @param points
     * @return
     */
    public int numberOfBoomerangs1(int[][] points) {

        int res = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                for (int k = j + 1; k < points.length; k++) {

                    int ij = 0;
                    if (map.containsKey(i + ":" + j)) {
                        ij = map.get(i + ":" + j);
                    } else {
                        ij = (int) Math.pow((points[j][0] - points[i][0]), 2)
                                + (int) Math.pow((points[j][1] - points[i][1]), 2);
                        map.put(i + ":" + j, ij);
                    }
                    int ik = 0;
                    if (map.containsKey(i + ":" + k)) {
                        ik = map.get(i + ":" + k);
                    } else {
                        ik = (int) Math.pow((points[k][0] - points[i][0]), 2) +
                                (int) Math.pow((points[k][1] - points[i][1]), 2);
                        map.put(i + ":" + k, ik);
                    }
                    int jk = 0;
                    if (map.containsKey(j + ":" + k)) {
                        jk = map.get(j + ":" + k);
                    } else {
                        jk = (int) Math.pow((points[k][0] - points[j][0]), 2) +
                                (int) Math.pow((points[k][1] - points[j][1]), 2);
                        map.put(j + ":" + k, jk);
                    }

                    // i int the middle
                    if (ij == ik) {
                        res++;
                    }
                    // j in the middle
                    if (ij == jk) {
                        res++;
                    }
                    // k int the middle
                    if (jk == ik) {
                        res++;
                    }

                }
            }
        }

        return res * 2;
    }

    /**
     * 对于每一个节点，考虑这个节点为中间节点的情况下，其他节点到该节点距离相同的情况
     * 如果对于每个节点距离为ki的节点有ni个，则选两个节点排序可能为n(i)*n(i-1),
     * 那么Ei n(i)*n(i-1)，就是以该节点为中点的所有回旋镖的可能
     * 时间复杂度降低为on2
     * @param points
     * @return
     */
    public int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

}
