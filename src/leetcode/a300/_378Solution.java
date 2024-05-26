package leetcode.a300;

import java.util.PriorityQueue;

/**
 * 一个逐行和逐列均为非降序排列的矩阵
 * 找出这个矩阵中第k小的元素
 * TODO 递增矩阵的性质
 * {binary search}
 */
public class _378Solution {
   
    /**
     * 优先级队列，多路归并
     * 性能一般，nlogn的时间复杂度
     * 空间复杂度on
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<matrix.length;i++){
            int [] e = {matrix[i][0],i,0};
            pq.add(e);
        }
        int res=0;
        while(k!=0){
            int [] e = pq.remove();
            res = e[0];
            k--;
            if(e[2]!=matrix.length-1){
                e[0] = matrix[e[1]][e[2]+1];
                e[2] +=1;
                pq.add(e);
            }
        }

        return res;

    }

    /**
     * 二分查找，空间复杂度o1
     * 主要是在确定mid和k大小的时候，根据矩阵行列的递增关系
     * 可以在on的时间内统计出mid是
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 统计不大于mid的元素的数量
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return
     */
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
